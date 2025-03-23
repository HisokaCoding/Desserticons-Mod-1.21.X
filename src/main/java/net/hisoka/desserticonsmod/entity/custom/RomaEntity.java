package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.sound.ModSounds;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;


public class RomaEntity extends IronGolemEntity {
    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public RomaEntity(EntityType<? extends IronGolemEntity> entityType, World world) {
        super(entityType, world);
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
    @Override
    protected int getXpToDrop() {
        return 20 + this.getWorld().random.nextInt(3);
    }



    protected SoundEvent getAmbientSound() {
        if (Random.create().nextInt(4) == 0) {  // звук будет проигрываться 1 раз из 10
            return ModSounds.ROMA_AMBIENT;
        }
        return null;
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
        this.goalSelector.add(1, new MeleeAttackGoal(this, 0.6, true));
        this.goalSelector.add(3, new WanderNearTargetGoal(this, 0.6, 32.0F));
        this.goalSelector.add(4, new IronGolemWanderAroundGoal(this, 0.6));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackIronGolemTargetGoal(this));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
    }



    @Override
    public boolean damage(DamageSource source, float amount) {
        boolean result = super.damage(source, amount);
        if (!this.getWorld().isClient) {
            Entity attacker = source.getAttacker();
            if (attacker instanceof LivingEntity) {
                this.setTarget((LivingEntity) attacker);
            }
        }
        return result;
    }



    @Override
    public boolean tryAttack(Entity target) {
        if (target instanceof LivingEntity) {
            return target.damage(this.getDamageSources().generic(), 10.0F);
        }
        return false;
    }



    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.updateAnimations();
        }
    }



    private void updateAnimations() {
        if (this.isAttacking() && attackAnimationTimeout <= 0){
            this.attackAnimationTimeout = 15;
            this.attackAnimationState.start(this.age);
        }else{
            --this.attackAnimationTimeout;
        }
        if (!this.isAttacking()){
            this.attackAnimationState.stop();
        }
    }



    public static DefaultAttributeContainer.Builder createRomaAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.0);
    }
}
