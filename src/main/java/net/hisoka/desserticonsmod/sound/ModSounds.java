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

    public static SoundEvent ARKAWA_HURT = registerSoundEvent("arkawa_hurt");
    public static SoundEvent ARKAWA_DEATH = registerSoundEvent("arkawa_death");
    public static SoundEvent ARKAWA_AMBIENT = registerSoundEvent("arkawa_ambient");
    public static SoundEvent ARKAWA_BASKET = registerSoundEvent("arkawa_basket");

    public static SoundEvent JORA_HURT = registerSoundEvent("jora_hurt");
    public static SoundEvent JORA_DEATH = registerSoundEvent("jora_death");
    public static SoundEvent JORA_AMBIENT = registerSoundEvent("jora_ambient");

    public static SoundEvent YURA_HURT = registerSoundEvent("yura_hurt");
    public static SoundEvent YURA_DEATH = registerSoundEvent("yura_death");
    public static SoundEvent YURA_AMBIENT = registerSoundEvent("yura_ambient");

    public static SoundEvent SEMEN_HURT = registerSoundEvent("semen_hurt");
    public static SoundEvent SEMEN_DEATH = registerSoundEvent("semen_death");
    public static SoundEvent SEMEN_AMBIENT = registerSoundEvent("semen_ambient");

    public static SoundEvent MAXIM_HURT = registerSoundEvent("maxim_hurt");
    public static SoundEvent MAXIM_DEATH = registerSoundEvent("maxim_death");
    public static SoundEvent MAXIM_AMBIENT = registerSoundEvent("maxim_ambient");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(DesserticonsMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        DesserticonsMod.LOGGER.info("Registering Mod Sounds for " + DesserticonsMod.MOD_ID);
    }
}
