package net.hisoka.desserticonsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {
    public static void addSpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST, BiomeKeys.DRIPSTONE_CAVES, BiomeKeys.LUSH_CAVES), SpawnGroup.CREATURE, ModEntities.CABBA, 30, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FLOWER_FOREST, BiomeKeys.FOREST, BiomeKeys.MEADOW), SpawnGroup.CREATURE, ModEntities.TIMAN, 300, 3, 6);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS, BiomeKeys.DESERT, BiomeKeys.SAVANNA), SpawnGroup.CREATURE, ModEntities.ARKAWA, 100, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE), SpawnGroup.CREATURE, ModEntities.JORA, 200, 1, 1);
    }
}
