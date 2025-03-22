package net.hisoka.desserticonsmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.hisoka.desserticonsmod.entity.custom.CabbaEntity;
import net.hisoka.desserticonsmod.item.ModItemGroups;
import net.hisoka.desserticonsmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesserticonsMod implements ModInitializer {
	public static final String MOD_ID = "desserticonsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.CABBA, CabbaEntity.createMobAttributes());
	}
}