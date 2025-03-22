package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.item.ModItems;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.MerchantScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
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

    private void updateAnimations() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 180;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
    }

    private final TradeOfferList tradeOffers = new TradeOfferList();
    private PlayerEntity tradingPlayer;

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.3));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
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
        if (!this.getWorld().isClient && player instanceof ServerPlayerEntity serverPlayer) {
            this.setCustomer(player);
            player.sendMessage(Text.literal("Братан, есть в долг?"), false);
            serverPlayer.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                    (syncId, inventory, playerEntity) -> new MerchantScreenHandler(syncId, inventory, this),
                    Text.literal("Торговец")
            ));
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
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
