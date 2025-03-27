package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.YuraEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class YuraRenderer extends MobEntityRenderer<YuraEntity, YuraModel<YuraEntity>> {

    public YuraRenderer(EntityRendererFactory.Context context) {
        super(context, new YuraModel<>(context.getPart(YuraModel.YURA)), 0.5f);
    }

    @Override
    public Identifier getTexture(YuraEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/yura/yura_texture.png");
    }

    @Override
    public void render(YuraEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
