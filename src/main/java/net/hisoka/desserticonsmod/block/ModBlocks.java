package net.hisoka.desserticonsmod.block;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.hisoka.desserticonsmod.DesserticonsMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block DESSERTICOIN_BLOCK = registerBlock("desserticoin_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block CUSTOM_PORTAL_BLOCK = registerBlock("custom_portal_block",
            new CustomPortalBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .nonOpaque()
                    .luminance(state -> 10)
                    .strength(-1.0F)));

    public static final Block BLOCK_WITH_PROTECTION = registerBlock("block_with_protection",
            new Block(AbstractBlock.Settings.create()
                    .strength(-1.0F)));

    public static void registerRenderLayer() {
        BlockRenderLayerMap.INSTANCE.putBlock(CUSTOM_PORTAL_BLOCK, RenderLayer.getTranslucent());
    }



    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DesserticonsMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DesserticonsMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        DesserticonsMod.LOGGER.info("Registering Mod Blocks for " + DesserticonsMod.MOD_ID);
    }
}
