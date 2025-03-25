package net.hisoka.desserticonsmod.item.custom;

import net.hisoka.desserticonsmod.block.CustomPortalBlock;
import net.hisoka.desserticonsmod.block.ModBlocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class HookahItem extends Item {
    public HookahItem(Settings settings) {
        super(settings);
    }



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Direction portalDirection = findPortalDirection(world, context.getBlockPos());
        if (context.getPlayer() != null) {
            releaseSmokeParticles(context.getPlayer());
            if (Math.random() < 0.5) {
                context.getPlayer().addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000, 0));
            }
        }
        if (world.getBlockState(context.getBlockPos()).isOf(ModBlocks.DESSERTICOIN_BLOCK)) {
            // Проверяем, что рамка валидна
            if (((CustomPortalBlock) ModBlocks.CUSTOM_PORTAL_BLOCK).isValidPortalFrame(world, context.getBlockPos())) {
                // Активируем портал
                activatePortal(world, context.getBlockPos(), portalDirection);
            }
        }
        if (!world.isClient()) {
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_PLAYER_HURT_DROWN, SoundCategory.PLAYERS);
        }
        return ActionResult.SUCCESS;
    }
    private Direction findPortalDirection(World world, BlockPos pos) {
        // Проверяем, есть ли рамка по оси X (восток-запад)
        if (world.getBlockState(pos.east()).isOf(ModBlocks.DESSERTICOIN_BLOCK) ||
                world.getBlockState(pos.west()).isOf(ModBlocks.DESSERTICOIN_BLOCK)) {
            return Direction.EAST; // Портал направлен по X
        }

        // Проверяем, есть ли рамка по оси Z (север-юг)
        if (world.getBlockState(pos.north()).isOf(ModBlocks.DESSERTICOIN_BLOCK) ||
                world.getBlockState(pos.south()).isOf(ModBlocks.DESSERTICOIN_BLOCK)) {
            return Direction.SOUTH; // Портал направлен по Z
        }

        return null; // Направление не найдено
    }



    private void releaseSmokeParticles(PlayerEntity player) {
        Vec3d headPos = player.getCameraPosVec(1.0F);
        Vec3d mouthPos = headPos.subtract(0, 0.3, 0);

        double offsetX = (Math.random() - 0.5) * 0.5;
        double offsetY = 0.2;
        double offsetZ = (Math.random() - 0.5) * 0.5;

        player.getWorld().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, mouthPos.getX() + offsetX, mouthPos.getY() + offsetY, mouthPos.getZ() + offsetZ, 0, 0.1, 0);
    }



    private void activatePortal(World world, BlockPos pos, Direction direction) {
        // Ищем угол рамки портала
        BlockPos frameStart = ((CustomPortalBlock) ModBlocks.CUSTOM_PORTAL_BLOCK).findFrameCorner(world, pos, direction);
        if (frameStart != null) {
            int width = 2; // Внутренний размер портала (ширина)
            int height = 3; // Внутренний размер портала (высота)

            // Определяем смещения по направлению портала
            int dx = direction == Direction.EAST ? 1 : 0;
            int dz = direction == Direction.SOUTH ? 1 : 0;

            // Заполняем внутреннее пространство порталами
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    BlockPos portalPos = frameStart.add(x * dx, y + 1, x * dz);
                    world.setBlockState(portalPos, ModBlocks.CUSTOM_PORTAL_BLOCK.getDefaultState(), 3);
                }
            }
        }
    }
}
