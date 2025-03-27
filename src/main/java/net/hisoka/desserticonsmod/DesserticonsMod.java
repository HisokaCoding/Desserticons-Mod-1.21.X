package net.hisoka.desserticonsmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.hisoka.desserticonsmod.block.ModBlocks;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.hisoka.desserticonsmod.entity.custom.*;
import net.hisoka.desserticonsmod.event.ModEvents;
import net.hisoka.desserticonsmod.item.ModItemGroups;
import net.hisoka.desserticonsmod.item.ModItems;
import net.hisoka.desserticonsmod.sound.ModSounds;
import net.hisoka.desserticonsmod.world.gen.ModEntitySpawns;
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
		ModEntitySpawns.addSpawn();
		ModSounds.registerSounds();
		ModEvents.register();

		ModBlocks.registerRenderLayer();


		FabricDefaultAttributeRegistry.register(ModEntities.CABBA, CabbaEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.TIMAN, TimanEntity.createTimanAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ROMA, RomaEntity.createRomaAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ARKAWA, ArkawaEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.JORA, JoraEntity.createJoraAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.YURA, YuraEntity.createYuraAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SEMEN, YuraEntity.createYuraAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MAXIM, MaximEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SEREGA, MaximEntity.createMobAttributes());
	}
}