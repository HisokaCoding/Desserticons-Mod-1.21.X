package net.hisoka.desserticonsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DESSERTICOIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CUSTOM_PORTAL_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DESSERTICOIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYPTOCOIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CIGARETTES, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGYDRINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROTEIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BASKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOOKAH, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PREMIATA_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADIDAS_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MOSCOW_HOODIE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.Z_HELMET));

        itemModelGenerator.register(ModItems.CABBA_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")),Optional.empty()));
        itemModelGenerator.register(ModItems.TIMAN_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")),Optional.empty()));
        itemModelGenerator.register(ModItems.ROMA_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")),Optional.empty()));
        itemModelGenerator.register(ModItems.ARKAWA_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")),Optional.empty()));
        itemModelGenerator.register(ModItems.JORA_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")),Optional.empty()));
    }
}
