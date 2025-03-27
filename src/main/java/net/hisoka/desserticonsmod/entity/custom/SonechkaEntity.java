package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SonechkaEntity extends PathAwareEntity {

    public SonechkaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

//    @Override
//    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
//        ItemStack itemStack = player.getStackInHand(hand);
//        if (!itemStack.isOf(ModItems.CRYPTOCOIN)) {
//            return ActionResult.PASS;
//        } else {
//            itemStack.decrementUnlessCreative(1, player);
//            ItemStack adidasLeggings = new ItemStack(ModItems.FOOTBALL);
//            ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), adidasLeggings);
//            this.getWorld().spawnEntity(itemEntity);
//            return ActionResult.success(this.getWorld().isClient);
//        }
//    }
}
