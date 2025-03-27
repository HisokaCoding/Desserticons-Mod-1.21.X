package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.item.ModItems;
import net.hisoka.desserticonsmod.sound.ModSounds;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.PowderSnowJumpGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class MaximEntity extends PathAwareEntity {

    private boolean isBasketballing = false;
    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;
    private int basketAnimationTimer = -1;

    public MaximEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public void tick() {
        super.tick();

        if (this.basketAnimationTimer > 0) {
            this.basketAnimationTimer--;
        }

        if (this.getWorld().isClient()) {
            this.updateAnimations();
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
        this.dropItem(new ItemStack(ModItems.DESSERTICOIN, 1).getItem());
    }
    @Override
    protected int getXpToDrop() {
        return 10 + this.getWorld().random.nextInt(3);
    }



    protected SoundEvent getAmbientSound() {
        if (Random.create().nextInt(5) == 0) {
            return ModSounds.MAXIM_AMBIENT;
        }
        return null;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.MAXIM_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        if (Random.create().nextInt(2) == 0) {
            return ModSounds.MAXIM_HURT;
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



    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isOf(ModItems.FOOTBALL)) {
            return ActionResult.PASS;
        } else {
            itemStack.decrementUnlessCreative(1, player);
            ItemStack adidasLeggings = new ItemStack(ModItems.ADIDAS_LEGGINGS);
            ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), adidasLeggings);
            this.getWorld().spawnEntity(itemEntity);
            this.setSpecialAnimation(true);
            return ActionResult.success(this.getWorld().isClient);
        }
    }



    public void setSpecialAnimation(boolean value) {
        if (value) {
            this.basketAnimationTimer = 160;
            this.isBasketballing = true;
        }
    }



    private void updateAnimations() {
        if (this.isBasketballing & this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 180;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
    }
}
