package net.hisoka.desserticonsmod;

import net.fabricmc.api.ModInitializer;

import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesserticonsMod implements ModInitializer {
	public static final String MOD_ID = "desserticonsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}