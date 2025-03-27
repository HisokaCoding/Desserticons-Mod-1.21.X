package net.hisoka.desserticonsmod.item;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.hisoka.desserticonsmod.item.custom.*;
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
    public static final Item FOOTBALL = registerItem("football", new Item(new Item.Settings()));
    public static final Item ENERGYDRINK = registerItem("energydrink", new Item(new Item.Settings().food(ModFoodComponents.ENERGYDRINK)));
    public static final Item PROTEIN = registerItem("protein", new Item(new Item.Settings().food(ModFoodComponents.PROTEIN)));

    public static final Item HOOKAH = registerItem("hookah", new HookahItem(new Item.Settings().maxDamage(32)));
    public static final Item CIGARETTES = registerItem("cigarettes", new CigarettesItem(new Item.Settings().maxDamage(20)));


    public static final Item PREMIATA_BOOTS = registerItem("premiata_boots",
            new PremiataBootsItem(ModArmorMaterials.DESSERTICONS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(500))));
    public static final Item ADIDAS_LEGGINGS = registerItem("adidas_leggings",
            new AdidasLeggingsItem(ModArmorMaterials.DESSERTICONS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(800))));
    public static final Item MOSCOW_HOODIE = registerItem("moscow_hoodie",
            new MoscowHoodieItem(ModArmorMaterials.DESSERTICONS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(1000))));
    public static final Item Z_HELMET = registerItem("z_helmet",
            new ZHelmetItem(ModArmorMaterials.DESSERTICONS_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(600))));

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
    public static final Item SEMEN_SPAWN_EGG = registerItem("semen_spawn_egg",
            new SpawnEggItem(ModEntities.SEMEN, 0xFFE5CC, 0x99CCFF, new Item.Settings()));
    public static final Item MAXIM_SPAWN_EGG = registerItem("maxim_spawn_egg",
            new SpawnEggItem(ModEntities.MAXIM, 0x202020, 0xFFFFFF, new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(DesserticonsMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        DesserticonsMod.LOGGER.info("Registering Mod Items for " + DesserticonsMod.MOD_ID);
    }
}
