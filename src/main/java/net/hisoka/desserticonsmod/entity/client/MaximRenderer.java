package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.MaximEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MaximRenderer  extends MobEntityRenderer<MaximEntity, MaximModel<MaximEntity>> {

    public MaximRenderer(EntityRendererFactory.Context context) {
        super(context, new MaximModel(context.getPart(MaximModel.MAXIM)), 0.65f);
    }

    @Override
    public Identifier getTexture(MaximEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/maxim/maxim_texture.png");
    }

    @Override
    public void render(MaximEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
