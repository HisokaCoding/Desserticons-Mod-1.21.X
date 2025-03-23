package net.hisoka.desserticonsmod.sound;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static SoundEvent TIMAN_HURT = registerSoundEvent("timan_hurt");
    public static SoundEvent TIMAN_DEATH = registerSoundEvent("timan_death");
    public static SoundEvent TIMAN_AMBIENT = registerSoundEvent("timan_ambient");

    public static SoundEvent ROMA_HURT = registerSoundEvent("roma_hurt");
    public static SoundEvent ROMA_DEATH = registerSoundEvent("roma_death");
    public static SoundEvent ROMA_AMBIENT = registerSoundEvent("roma_ambient");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(DesserticonsMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        DesserticonsMod.LOGGER.info("Registering Mod Sounds for " + DesserticonsMod.MOD_ID);
    }
}
