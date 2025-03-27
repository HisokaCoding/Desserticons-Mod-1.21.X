package net.hisoka.desserticonsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup DESSERTICONS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DesserticonsMod.MOD_ID, "desserticons_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DESSERTICOIN))
                    .displayName(Text.translatable("itemgroup.desserticonsmod.desserticons_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.DESSERTICOIN);
                        entries.add(ModItems.CRYPTOCOIN);
                        entries.add(ModItems.BASKET);
                        entries.add(ModItems.CIGARETTES);
                        entries.add(ModItems.HOOKAH);
                        entries.add(ModItems.ENERGYDRINK);
                        entries.add(ModItems.PROTEIN);
                        entries.add(ModItems.PREMIATA_BOOTS);
                        entries.add(ModItems.ADIDAS_LEGGINGS);
                        entries.add(ModItems.MOSCOW_HOODIE);
                        entries.add(ModItems.Z_HELMET);
                        entries.add(ModBlocks.DESSERTICOIN_BLOCK);
                        entries.add(ModItems.CABBA_SPAWN_EGG);
                        entries.add(ModItems.TIMAN_SPAWN_EGG);
                        entries.add(ModItems.ROMA_SPAWN_EGG);
                        entries.add(ModItems.ARKAWA_SPAWN_EGG);
                        entries.add(ModItems.JORA_SPAWN_EGG);
                        entries.add(ModItems.YURA_SPAWN_EGG);
                        entries.add(ModItems.SEMEN_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups(){
        DesserticonsMod.LOGGER.info("Registering Item Groups for " + DesserticonsMod.MOD_ID);
    }
}
