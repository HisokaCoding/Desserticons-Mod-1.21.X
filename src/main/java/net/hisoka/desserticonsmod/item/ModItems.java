package net.hisoka.desserticonsmod.item;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DESSERTICOIN = registerItem("desserticoin", new Item(new Item.Settings()));
    public static final Item CIGARETTES = registerItem("cigarettes", new Item(new Item.Settings().food(ModFoodComponents.CIGARETTES)));
    public static final Item ENERGYDRINK = registerItem("energydrink", new Item(new Item.Settings().food(ModFoodComponents.ENERGYDRINK)));
    public static final Item CABBA_SPAWN_EGG = registerItem("cabba_spawn_egg",
            new SpawnEggItem(ModEntities.CABBA, 0xE0E0E0, 0x808080, new Item.Settings()));
    public static final Item TIMAN_SPAWN_EGG = registerItem("timan_spawn_egg",
            new SpawnEggItem(ModEntities.TIMAN, 0x66FFFF, 0x663300, new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(DesserticonsMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        DesserticonsMod.LOGGER.info("Registering Mod Items for " + DesserticonsMod.MOD_ID);
    }
}
