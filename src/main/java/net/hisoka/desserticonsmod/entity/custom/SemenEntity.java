package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.item.ModItems;
import net.hisoka.desserticonsmod.sound.ModSounds;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.PowderSnowJumpGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SemenEntity extends PathAwareEntity{

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;




    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.updateAnimations();
        }
    }



    private void updateAnimations() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 180;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
    }



    public SemenEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }



    public static DefaultAttributeContainer.Builder createSemenAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4);
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
        this.dropItem(new ItemStack(ModItems.DESSERTICOIN, 1).getItem());
        this.dropItem(new ItemStack(ModItems.PROTEIN, 1).getItem());
    }

    @Override
    protected int getXpToDrop() {
        return 50 + this.getWorld().random.nextInt(3);
    }



    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new PowderSnowJumpGoal(this, this.getWorld()));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.3));
    }



    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isOf(ModItems.PROTEIN)) {
            return ActionResult.PASS;
        } else {
            itemStack.decrementUnlessCreative(1, player);
            ItemStack zhelmet = new ItemStack(ModItems.Z_HELMET);
            ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), zhelmet);
            this.getWorld().spawnEntity(itemEntity);
            return ActionResult.success(this.getWorld().isClient);
        }
    }



    protected SoundEvent getAmbientSound() {
        if (Random.create().nextInt(4) == 0) {
            return ModSounds.SEMEN_AMBIENT;
        }
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SEMEN_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return ModSounds.SEMEN_HURT;}

}
