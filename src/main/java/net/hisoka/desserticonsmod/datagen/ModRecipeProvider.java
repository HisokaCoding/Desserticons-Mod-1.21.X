package net.hisoka.desserticonsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
//
    @Override
    public void generate(RecipeExporter recipeExporter) {

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.DESSERTICOIN, RecipeCategory.MISC, ModBlocks.DESSERTICOIN_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DESSERTICOIN, 9)
                .input(ModBlocks.DESSERTICOIN_BLOCK)
                .criterion(hasItem(ModBlocks.DESSERTICOIN_BLOCK),conditionsFromItem(ModBlocks.DESSERTICOIN_BLOCK))
                .offerTo(recipeExporter, Identifier.of(DesserticonsMod.MOD_ID, "desserticoin_from_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BASKET, 1)
                .input(Items.SLIME_BALL)
                .input(Blocks.PUMPKIN)
                .criterion(hasItem(Blocks.PUMPKIN),conditionsFromItem(Blocks.PUMPKIN))
                .offerTo(recipeExporter, Identifier.of(DesserticonsMod.MOD_ID, "basket_from_pumpkin"));
    }
}
