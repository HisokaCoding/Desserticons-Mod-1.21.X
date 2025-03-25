package net.hisoka.desserticonsmod.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


public class CustomPortalBlock extends NetherPortalBlock {
    public CustomPortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }



    public boolean isValidPortalFrame(World world, BlockPos pos) {
        // Ищем нижний левый угол рамки
        BlockPos frameStart = findFrameCorner(world, pos);
        if (frameStart == null) {
            return false; // Если не нашли — рамка неправильная
        }

        // Проверяем всю структуру
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 5; y++) {
                BlockPos portalPos = frameStart.add(x - 1, y, 0);
                if (x == 0 || x == 3 || y == 0 || y == 4) {
                    if (!world.getBlockState(portalPos).isOf(ModBlocks.DESSERTICOIN_BLOCK)) {
                        return false; // Рамка должна быть целой
                    }
                }
            }
        }

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 3; y++) {
                BlockPos portalPos = frameStart.add(x, y + 1, 0);
                if (!world.getBlockState(portalPos).isAir()) {
                    return false; // Внутри рамки не должно быть блоков
                }
            }
        }

        return true;
    }



    public BlockPos findFrameCorner(World world, BlockPos pos) {
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos checkPos = pos.add(x, 0, z);
                if (isCorrectFrame(world, checkPos)) {
                    return checkPos;
                }
            }
        }
        return null;
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
}
