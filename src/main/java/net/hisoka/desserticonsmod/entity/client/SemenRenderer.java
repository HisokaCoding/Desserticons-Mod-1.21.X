package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.RomaEntity;
import net.hisoka.desserticonsmod.entity.custom.SemenEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SemenRenderer extends MobEntityRenderer<SemenEntity, SemenModel<SemenEntity>> {

    public SemenRenderer(EntityRendererFactory.Context context) {
        super(context, new SemenModel<>(context.getPart(SemenModel.SEMEN)), 0.85f);
    }

    @Override
    public Identifier getTexture(SemenEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/semen/semen_texture.png");
    }

    @Override
    public void render(SemenEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
