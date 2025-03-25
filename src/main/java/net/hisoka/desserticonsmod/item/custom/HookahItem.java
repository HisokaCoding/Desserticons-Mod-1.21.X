package net.hisoka.desserticonsmod.item.custom;

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
}
