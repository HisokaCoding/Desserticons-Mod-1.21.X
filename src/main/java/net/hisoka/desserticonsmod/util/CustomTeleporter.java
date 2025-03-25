package net.hisoka.desserticonsmod.util;

import net.minecraft.entity.Entity;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.HashSet;
import java.util.Set;

public class CustomTeleporter {

    public static void teleportEntity(Entity entity, ServerWorld destinationWorld, BlockPos targetPos) {
        if (entity == null || destinationWorld == null) return;


        Vec3d finalPos = new Vec3d(targetPos.getX() + 0.5, targetPos.getY() + 0.5, targetPos.getZ() + 0.5);

        Set<PositionFlag> s = new HashSet<>();
        //s.add();
        entity.teleport(destinationWorld, finalPos.x, finalPos.y, finalPos.z, s, entity.getYaw(), entity.getPitch());
    }
}