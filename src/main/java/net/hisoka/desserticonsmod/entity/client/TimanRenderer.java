package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.CabbaEntity;
import net.hisoka.desserticonsmod.entity.custom.TimanEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class TimanRenderer extends MobEntityRenderer<TimanEntity, TimanModel<TimanEntity>> {
    public TimanRenderer(EntityRendererFactory.Context context) {
        super(context, new TimanModel<>(context.getPart(TimanModel.TIMAN)), 0.75f);
    }

    @Override
    public Identifier getTexture(TimanEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/timan/timan_texture.png");
    }

    @Override
    public void render(TimanEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
