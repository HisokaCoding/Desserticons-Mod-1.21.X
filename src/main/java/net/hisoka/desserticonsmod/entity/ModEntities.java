package net.hisoka.desserticonsmod.entity;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.CabbaEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<CabbaEntity> CABBA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(DesserticonsMod.MOD_ID,"cabba"),
            EntityType.Builder.create(CabbaEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2f).build());

    public static void registerModEntities(){
        DesserticonsMod.LOGGER.info("Registering Mod Entities for " + DesserticonsMod.MOD_ID);
    }
}
