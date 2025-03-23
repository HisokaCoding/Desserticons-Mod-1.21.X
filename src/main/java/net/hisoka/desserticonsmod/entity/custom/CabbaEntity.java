package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.item.ModItems;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.PowderSnowJumpGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.village.Merchant;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradedItem;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CabbaEntity extends PathAwareEntity implements Merchant {

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.updateAnimations();
        }
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    private void updateAnimations() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 180;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
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
        this.dropItem(new ItemStack(ModItems.CIGARETTES, 1).getItem());
        this.dropItem(new ItemStack(ModItems.ENERGYDRINK, 1).getItem());
    }

    @Override
    protected int getXpToDrop() {
        return 5 + this.getWorld().random.nextInt(3);
    }

    private final TradeOfferList tradeOffers = new TradeOfferList();
    private PlayerEntity tradingPlayer;

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new PowderSnowJumpGoal(this, this.getWorld()));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.3));
        this.goalSelector.add(11, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
    }


    public CabbaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        setupTrades();
    }

    private void setupTrades() {
        tradeOffers.add(new TradeOffer(
                new TradedItem(ModItems.DESSERTICOIN, 5),
                new ItemStack(ModBlocks.DESSERTICOIN_BLOCK, 1),
                10, 5, 0.05f));
        tradeOffers.add(new TradeOffer(
                new TradedItem(ModItems.DESSERTICOIN, 2),
                new ItemStack(ModItems.CIGARETTES, 1),
                10, 5, 0.05f));
        tradeOffers.add(new TradeOffer(
                new TradedItem(ModItems.DESSERTICOIN, 3),
                new ItemStack(ModItems.ENERGYDRINK, 1),
                10, 5, 0.05f));
    }


    @Override
    public void setCustomer(@Nullable PlayerEntity customer) {
        this.tradingPlayer = customer;
    }

    @Override
    public @Nullable PlayerEntity getCustomer() {
        return tradingPlayer;
    }

    @Override
    public TradeOfferList getOffers() {
        return tradeOffers;
    }

    @Override
    public void setOffersFromServer(TradeOfferList offers) {
        this.tradeOffers.clear();
        this.tradeOffers.addAll(offers);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isOf(ModItems.CRYPTOCOIN)) {
            if (!this.getWorld().isClient) {
                if (this.getOffers().isEmpty()) {
                    return ActionResult.CONSUME;
                }
                player.sendMessage(Text.literal("Братан, есть в долг?"), false);
                this.setCustomer(player);
                this.sendOffers(player, this.getDisplayName(), 1);
            }
        } else {
            itemStack.decrementUnlessCreative(1, player);
            this.kill();
        }
        return ActionResult.success(this.getWorld().isClient);
    }


    @Override
    public void trade(TradeOffer offer) {

    }

    @Override
    public void onSellingItem(ItemStack stack) {

    }

    @Override
    public int getExperience() {
        return 0;
    }

    @Override
    public void setExperienceFromServer(int experience) {

    }

    @Override
    public boolean isLeveledMerchant() {
        return false;
    }

    @Override
    public SoundEvent getYesSound() {
        return null;
    }

    @Override
    public boolean isClient() {
        return false;
    }
}
