package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.item.ModItems;
import net.hisoka.desserticonsmod.sound.ModSounds;
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

public class SeregaEntity extends PathAwareEntity {

    public SeregaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (!this.getWorld().isClient) {
            dropItems();
        }
    }
    private void dropItems() {
        this.dropItem(new ItemStack(ModItems.DESSERTICOIN, 1).getItem());
        this.dropItem(new ItemStack(ModItems.DESSERTICOIN, 1).getItem());
    }
    @Override
    protected int getXpToDrop() {
        return 10 + this.getWorld().random.nextInt(3);
    }



    protected SoundEvent getAmbientSound() {
        if (Random.create().nextInt(5) == 0) {
            return ModSounds.SEREGA_AMBIENT;
        }
        return null;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SEREGA_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        if (Random.create().nextInt(2) == 0) {
            return ModSounds.SEREGA_HURT;
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
        if (!itemStack.isOf(ModItems.CRYPTOCOIN)) {
            return ActionResult.PASS;
        } else {
            itemStack.decrementUnlessCreative(1, player);
            ItemStack adidasLeggings = new ItemStack(ModItems.FOOTBALL);
            ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), adidasLeggings);
            this.getWorld().spawnEntity(itemEntity);
            return ActionResult.success(this.getWorld().isClient);
        }
    }
}
