package net.hisoka.desserticonsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hisoka.desserticonsmod.entity.ModEntities;
import net.hisoka.desserticonsmod.entity.client.*;


public class DesserticonsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        EntityModelLayerRegistry.registerModelLayer(CabbaModel.CABBA, CabbaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CABBA, CabbaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(TimanModel.TIMAN, TimanModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TIMAN, TimanRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(RomaModel.ROMA, RomaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ROMA, RomaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ArkawaModel.ARKAWA, ArkawaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ARKAWA, ArkawaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(JoraModel.JORA, JoraModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.JORA, JoraRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(YuraModel.YURA, YuraModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.YURA, YuraRenderer::new);
    }
}
