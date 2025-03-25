package net.hisoka.desserticonsmod.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;


public class CustomPortalBlock extends Block implements Portal {

    public CustomPortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (neighborState.isOf(Blocks.AIR)){
            destroyPortal((World) world, pos);
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }



    public boolean isValidPortalFrame(World world, BlockPos pos) {
        // Определяем направление рамки
        BlockPos frameStartX = findFrameCorner(world, pos, Direction.EAST); // По оси X
        BlockPos frameStartZ = findFrameCorner(world, pos, Direction.SOUTH); // По оси Z

        if (frameStartX != null && checkFrame(world, frameStartX, Direction.EAST)) {
            return true;
        }
        if (frameStartZ != null && checkFrame(world, frameStartZ, Direction.SOUTH)) {
            return true;
        }
        return false;
    }

    public BlockPos findFrameCorner(World world, BlockPos pos, Direction direction) {
        int dx = direction == Direction.EAST ? 1 : 0;
        int dz = direction == Direction.SOUTH ? 1 : 0;

        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos checkPos = pos.add(x * dx, 0, z * dz);
                if (isCorrectFrame(world, checkPos)) {
                    return checkPos;
                }
            }
        }
        return null;
    }

    private boolean checkFrame(World world, BlockPos frameStart, Direction direction) {
        int dx = direction == Direction.EAST ? 1 : 0;
        int dz = direction == Direction.SOUTH ? 1 : 0;

        // Проверяем рамку
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 5; y++) {
                BlockPos portalPos = frameStart.add((x - 1) * dx, y, (x - 1) * dz);
                if (x == 0 || x == 3 || y == 0 || y == 4) {
                    if (!world.getBlockState(portalPos).isOf(ModBlocks.DESSERTICOIN_BLOCK)) {
                        return false;
                    }
                }
            }
        }

        // Проверяем, что внутри рамки нет блоков
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 3; y++) {
                BlockPos portalPos = frameStart.add(x * dx, (y + 1), x * dz);
                if (!world.getBlockState(portalPos).isAir()) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isCorrectFrame(World world, BlockPos pos) {
        return world.getBlockState(pos).isOf(ModBlocks.DESSERTICOIN_BLOCK) &&
                world.getBlockState(pos.up()).isAir();
    }



    @Override
    public Portal.Effect getPortalEffect() {
        return Portal.Effect.CONFUSION;
    }



    @Override
    public int getPortalDelay(ServerWorld world, Entity entity) {
        return entity instanceof PlayerEntity playerEntity
                ? Math.max(
                1,
                world.getGameRules()
                        .getInt(playerEntity.getAbilities().invulnerable ? GameRules.PLAYERS_NETHER_PORTAL_CREATIVE_DELAY : GameRules.PLAYERS_NETHER_PORTAL_DEFAULT_DELAY)
        )
                : 0;
    }



    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(100) == 0) {
            world.playSound(
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false
            );
        }

        for (int i = 0; i < 4; i++) {
            double d = pos.getX() + random.nextDouble();
            double e = pos.getY() + random.nextDouble();
            double f = pos.getZ() + random.nextDouble();
            double g = (random.nextDouble() - 0.5) * 0.04;
            double h = (random.nextDouble() - 0.5) * 0.04;
            double j = (random.nextDouble() - 0.5) * 0.04;

            world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d, e, f, g, h, j);
        }
    }



    private void destroyPortal(World world, BlockPos pos) {
        // Удаление блока портала (заменяем на воздух)
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }





    @Override
    public @Nullable TeleportTarget createTeleportTarget(ServerWorld world, Entity entity, BlockPos pos) {
        return null;
    }
}
