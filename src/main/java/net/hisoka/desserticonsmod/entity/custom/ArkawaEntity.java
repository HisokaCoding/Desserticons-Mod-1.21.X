package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.item.ModItems;
import net.hisoka.desserticonsmod.sound.ModSounds;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.PowderSnowJumpGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ArkawaEntity extends PathAwareEntity {

    public AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;



    public ArkawaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }



    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.updateAnimations();
        }
    }



    private void updateAnimations() {
        if (this.isAttacking() && idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 15;
            this.idleAnimationState.start(this.age);
        }else{
            --this.idleAnimationTimeout;
        }
        if (!this.isAttacking()){
            this.idleAnimationState.stop();
        }
    }



    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (!this.getWorld().isClient) {
            dropItems();
        }
    }
    private void dropItems() {
        this.dropItem(new ItemStack(ModItems.CRYPTOCOIN, 1).getItem());
        this.dropItem(new ItemStack(ModItems.CIGARETTES, 1).getItem());
    }
    @Override
    protected int getXpToDrop() {
        return 10 + this.getWorld().random.nextInt(3);
    }



    protected SoundEvent getAmbientSound() {
        if (Random.create().nextInt(3) == 0) {
            return ModSounds.ARKAWA_AMBIENT;
        }
        return null;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ARKAWA_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        if (Random.create().nextInt(2) == 0) {
            return ModSounds.ARKAWA_HURT;
        }
        return null;
    }



    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new PowderSnowJumpGoal(this, this.getWorld()));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.3));
        this.goalSelector.add(11, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
    }
}
