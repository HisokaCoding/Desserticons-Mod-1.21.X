package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.screen.CustomCreditsScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SonechkaEntity extends PathAwareEntity {

    public SonechkaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!player.getWorld().isClient) {
            teleportToRespawn((ServerPlayerEntity) player);
            return ActionResult.SUCCESS;
        }

        // Запускаем кастомные титры
        MinecraftClient.getInstance().setScreen(new CustomCreditsScreen(true, () -> {
            MinecraftClient.getInstance().setScreen(null);
        }));

        return ActionResult.SUCCESS;
    }

    public static void teleportToRespawn(ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld(); // Получаем мир игрока
        BlockPos respawnPos = player.getSpawnPointPosition(); // Получаем точку респавна

        if (respawnPos == null) {
            // Если нет кровати или респавн-точки, используем стандартный спавн мира
            respawnPos = world.getSpawnPos();
        }

        // Телепортируем игрока
        player.teleport(world, respawnPos.getX() + 0.5, respawnPos.getY(), respawnPos.getZ() + 0.5,
                player.getYaw(), player.getPitch());
    }
}
