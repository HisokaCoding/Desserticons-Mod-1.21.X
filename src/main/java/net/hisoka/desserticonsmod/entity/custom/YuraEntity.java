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
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class YuraEntity extends PathAwareEntity {

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



    public YuraEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }



    public static DefaultAttributeContainer.Builder createYuraAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6);
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
        this.dropItem(new ItemStack(Items.COOKED_PORKCHOP, 1).getItem());
    }

    @Override
    protected int getXpToDrop() {
        return 5 + this.getWorld().random.nextInt(3);
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
        if (!itemStack.isOf(ModItems.DESSERTICOIN) || player.getInventory().count(ModItems.DESSERTICOIN) < 3) {
            return ActionResult.PASS;
        } else if (itemStack.isOf(ModItems.DESSERTICOIN) && player.getInventory().count(ModItems.DESSERTICOIN) >= 3){
            itemStack.decrementUnlessCreative(3, player);
            ItemStack protein = new ItemStack(ModItems.PROTEIN);
            ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), protein);
            this.getWorld().spawnEntity(itemEntity);
            return ActionResult.success(this.getWorld().isClient);
        } else {
            return ActionResult.PASS;
        }
    }



    protected SoundEvent getAmbientSound() {
        if (Random.create().nextInt(4) == 0) {
            return ModSounds.YURA_AMBIENT;
        }
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.YURA_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return ModSounds.YURA_HURT;}
}
