package net.hisoka.desserticonsmod.dimensions;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;


public class Ahineya {
    public static final RegistryKey<World> MY_CUSTOM_WORLD_KEY = RegistryKey.of(World.OVERWORLD.getRegistryRef(),
            Identifier.of(DesserticonsMod.MOD_ID, "ahineya"));

}