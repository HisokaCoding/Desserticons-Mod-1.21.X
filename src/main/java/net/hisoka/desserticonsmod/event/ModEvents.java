package net.hisoka.desserticonsmod.event;


import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.hisoka.desserticonsmod.item.ModArmorMaterials;
import net.minecraft.block.Blocks;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class ModEvents {
    public static void register() {

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!world.isClient()) {
                ItemStack itemStack = player.getStackInHand(hand); // Получаем предмет в руке

                // Проверяем, держит ли игрок резную тыкву
                if (itemStack.getItem() instanceof BlockItem blockItem &&
                        blockItem.getBlock() == Blocks.CARVED_PUMPKIN) {

                    BlockPos pos = hitResult.getBlockPos().up(); // Позиция, куда игрок хочет поставить блок

                    BlockPos below1 = pos.down();
                    BlockPos below2 = below1.down();

                    // Проверяем, что под тыквой два нужных блока
                    if (world.getBlockState(below1).isOf(ModBlocks.DESSERTICOIN_BLOCK) &&
                            world.getBlockState(below2).isOf(ModBlocks.DESSERTICOIN_BLOCK)) {

                        // Удаляем тыкву и блоки
                        world.breakBlock(pos, false);
                        world.breakBlock(below1, false);
                        world.breakBlock(below2, false);

                        // Спавним нового моба
                        MobEntity entity = ModEntities.ROMA.create(world);
                        if (entity != null) {
                            entity.refreshPositionAndAngles(below1.getX() + 0.5, below1.getY(), below1.getZ() + 0.5, 0, 0);
                            world.spawnEntity(entity);
                        }

                        return ActionResult.SUCCESS; // Прерываем стандартное поведение
                    }
                }
            }
            return ActionResult.PASS; // Оставляем стандартное поведение, если не нашли структуру
        });
    }
}
