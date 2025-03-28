package net.hisoka.desserticonsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hisoka.desserticonsmod.item.ModItems;
import net.hisoka.desserticonsmod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.VALUEABLE_ITEMS)
                .add(ModItems.DESSERTICOIN)
                .add(ModItems.CRYPTOCOIN);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PREMIATA_BOOTS)
                .add(ModItems.Z_HELMET)
                .add(ModItems.MOSCOW_HOODIE)
                .add(ModItems.ADIDAS_LEGGINGS);
    }
}
