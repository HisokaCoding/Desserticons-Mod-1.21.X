package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.ArkawaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ArkawaRenderer extends MobEntityRenderer<ArkawaEntity, ArkawaModel<ArkawaEntity>> {

    public ArkawaRenderer(EntityRendererFactory.Context context) {
        super(context, new ArkawaModel(context.getPart(ArkawaModel.ARKAWA)), 0.65f);
    }

    @Override
    public Identifier getTexture(ArkawaEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/arkawa/arkawa_texture.png");
    }

    @Override
    public void render(ArkawaEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
