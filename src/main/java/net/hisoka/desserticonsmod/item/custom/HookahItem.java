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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class HookahItem extends Item {
    public HookahItem(Settings settings) {
        super(settings);
    }



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
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
                activatePortal(world, context.getBlockPos());
            }
        }
        if (!world.isClient()) {
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_PLAYER_HURT_DROWN, SoundCategory.PLAYERS);
        }
        return ActionResult.SUCCESS;
    }



    private void releaseSmokeParticles(PlayerEntity player) {
        Vec3d headPos = player.getCameraPosVec(1.0F);
        Vec3d mouthPos = headPos.subtract(0, 0.3, 0);

        double offsetX = (Math.random() - 0.5) * 0.5;
        double offsetY = 0.2;
        double offsetZ = (Math.random() - 0.5) * 0.5;

        player.getWorld().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, mouthPos.getX() + offsetX, mouthPos.getY() + offsetY, mouthPos.getZ() + offsetZ, 0, 0.1, 0);
    }



    private void activatePortal(World world, BlockPos pos) {
        // Здесь заполняем рамку блоками портала
        BlockPos frameStart = ((CustomPortalBlock) ModBlocks.CUSTOM_PORTAL_BLOCK).findFrameCorner(world, pos);
        if (frameStart != null) {
            int width = 4; // Задай ширину рамки
            int height = 5; // Задай высоту рамки
            // Создаем и активируем портал
            for (int x = 0; x < width - 2; x++) {
                for (int y = 1; y < height - 1; y++) {
                    BlockPos portalPos = frameStart.add(x, y, 0);
                    world.setBlockState(portalPos, ModBlocks.CUSTOM_PORTAL_BLOCK.getDefaultState(), 3); // Заполняем блоками портала
                }
            }
        }
    }



}
