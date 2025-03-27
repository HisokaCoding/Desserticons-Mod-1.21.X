package net.hisoka.desserticonsmod.entity;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.*;
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

    public static final EntityType<TimanEntity> TIMAN = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(DesserticonsMod.MOD_ID,"timan"),
            EntityType.Builder.create(TimanEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 1f).build());

    public static final EntityType<RomaEntity> ROMA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(DesserticonsMod.MOD_ID,"roma"),
            EntityType.Builder.create(RomaEntity::new, SpawnGroup.CREATURE)
                    .dimensions(2f, 3f).build());

    public static final EntityType<ArkawaEntity> ARKAWA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(DesserticonsMod.MOD_ID,"arkawa"),
            EntityType.Builder.create(ArkawaEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2f).build());

    public static final EntityType<JoraEntity> JORA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(DesserticonsMod.MOD_ID,"jora"),
            EntityType.Builder.create(JoraEntity::new, SpawnGroup.CREATURE)
                    .dimensions(2f, 2f).build());

    public static final EntityType<YuraEntity> YURA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(DesserticonsMod.MOD_ID,"yura"),
            EntityType.Builder.create(YuraEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 3f).build());

    public static void registerModEntities(){
        DesserticonsMod.LOGGER.info("Registering Mod Entities for " + DesserticonsMod.MOD_ID);
    }
}
