package net.hisoka.desserticonsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;

public class ModEntitySpawns {
    public static void addSpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.CREATURE, ModEntities.CABBA, 30, 1, 1);
    }
}
