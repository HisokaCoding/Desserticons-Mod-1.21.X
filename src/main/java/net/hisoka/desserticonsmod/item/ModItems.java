package net.hisoka.desserticonsmod.item;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.hisoka.desserticonsmod.item.custom.CigarettesItem;
import net.hisoka.desserticonsmod.item.custom.HookahItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DESSERTICOIN = registerItem("desserticoin", new Item(new Item.Settings()));
    public static final Item CRYPTOCOIN = registerItem("cryptocoin", new Item(new Item.Settings()));
    public static final Item BASKET = registerItem("basket", new Item(new Item.Settings()));
    public static final Item ENERGYDRINK = registerItem("energydrink", new Item(new Item.Settings().food(ModFoodComponents.ENERGYDRINK)));
    public static final Item PROTEIN = registerItem("protein", new Item(new Item.Settings().food(ModFoodComponents.PROTEIN)));

    public static final Item HOOKAH = registerItem("hookah", new HookahItem(new Item.Settings().maxDamage(32)));
    public static final Item CIGARETTES = registerItem("cigarettes", new CigarettesItem(new Item.Settings().maxDamage(20)));


    public static final Item PREMIATA_BOOTS = registerItem("premiata_boots",
            new ArmorItem(ModArmorMaterials.DESSERTICONS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(50))));
    public static final Item ADIDAS_LEGGINGS = registerItem("adidas_leggings",
            new ArmorItem(ModArmorMaterials.DESSERTICONS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(80))));
    public static final Item MOSCOW_HOODIE = registerItem("moscow_hoodie",
            new ArmorItem(ModArmorMaterials.DESSERTICONS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(100))));
    public static final Item Z_HELMET = registerItem("z_helmet",
            new ArmorItem(ModArmorMaterials.DESSERTICONS_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(60))));

    public static final Item CABBA_SPAWN_EGG = registerItem("cabba_spawn_egg",
            new SpawnEggItem(ModEntities.CABBA, 0xE0E0E0, 0x808080, new Item.Settings()));
    public static final Item TIMAN_SPAWN_EGG = registerItem("timan_spawn_egg",
            new SpawnEggItem(ModEntities.TIMAN, 0x66FFFF, 0x663300, new Item.Settings()));
    public static final Item ROMA_SPAWN_EGG = registerItem("roma_spawn_egg",
            new SpawnEggItem(ModEntities.ROMA, 0xCC0000, 0xFF8000, new Item.Settings()));
    public static final Item ARKAWA_SPAWN_EGG = registerItem("arkawa_spawn_egg",
            new SpawnEggItem(ModEntities.ARKAWA, 0xFF3333, 0xFFFF00, new Item.Settings()));
    public static final Item JORA_SPAWN_EGG = registerItem("jora_spawn_egg",
            new SpawnEggItem(ModEntities.JORA, 0x663300, 0xFFCCCC, new Item.Settings()));
    public static final Item YURA_SPAWN_EGG = registerItem("yura_spawn_egg",
            new SpawnEggItem(ModEntities.YURA, 0x99CCFF, 0xFFE5CC, new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(DesserticonsMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        DesserticonsMod.LOGGER.info("Registering Mod Items for " + DesserticonsMod.MOD_ID);
    }
}
