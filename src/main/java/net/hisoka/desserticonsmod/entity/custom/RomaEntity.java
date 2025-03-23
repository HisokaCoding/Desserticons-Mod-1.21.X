package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class RomaEntity extends PathAwareEntity {

    public RomaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public void tick() {
        super.tick();
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);

        // Выпадение предметов при смерти сущности
        if (!this.getWorld().isClient) {
            dropItems();
        }
    }

    private void dropItems() {
        this.dropItem(new ItemStack(ModBlocks.DESSERTICOIN_BLOCK, 1).getItem());
        this.dropItem(new ItemStack(ModBlocks.DESSERTICOIN_BLOCK, 1).getItem());
    }

    protected SoundEvent getAmbientSound() {
        // Вероятность проигрывания звука, например 1 из 10
        if (Random.create().nextInt(4) == 0) {  // 0 - это означает, что звук будет проигрываться 1 раз из 10
            return ModSounds.ROMA_AMBIENT;
        }
        return null;  // Если условие не выполнено, звук не будет проигрываться
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ROMA_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        if (Random.create().nextInt(2) == 0) {
            return ModSounds.ROMA_HURT;
        }
        return null;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(2, new WanderNearTargetGoal(this, 0.9, 32.0F));
        this.goalSelector.add(4, new IronGolemWanderAroundGoal(this, 0.6));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(2, new RevengeGoal(this));
    }

    public static DefaultAttributeContainer.Builder createRomaAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.0);
    }
}
