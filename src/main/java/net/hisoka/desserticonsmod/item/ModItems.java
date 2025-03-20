package net.hisoka.desserticonsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hisoka.desserticonsmod.DesserticonsMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DESSERTICOIN = registerItem("desserticoin", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(DesserticonsMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        DesserticonsMod.LOGGER.info("Registering Mod Items for " + DesserticonsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(DESSERTICOIN);
        });
    }
}
