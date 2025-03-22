package net.hisoka.desserticonsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.hisoka.desserticonsmod.entity.client.CabbaModel;
import net.hisoka.desserticonsmod.entity.client.CabbaRenderer;
import net.hisoka.desserticonsmod.entity.client.TimanModel;
import net.hisoka.desserticonsmod.entity.client.TimanRenderer;


public class DesserticonsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(CabbaModel.CABBA, CabbaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CABBA, CabbaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(TimanModel.TIMAN, TimanModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TIMAN, TimanRenderer::new);
    }
}
