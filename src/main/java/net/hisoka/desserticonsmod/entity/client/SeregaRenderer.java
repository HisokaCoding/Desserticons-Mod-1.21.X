package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.SeregaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SeregaRenderer extends MobEntityRenderer<SeregaEntity, SeregaModel<SeregaEntity>> {

    public SeregaRenderer(EntityRendererFactory.Context context) {
        super(context, new SeregaModel(context.getPart(SeregaModel.SEREGA)), 0.65f);
    }

    @Override
    public Identifier getTexture(SeregaEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/serega/serega_texture.png");
    }

    @Override
    public void render(SeregaEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
