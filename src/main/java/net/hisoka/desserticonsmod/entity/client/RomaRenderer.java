package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.RomaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RomaRenderer extends MobEntityRenderer<RomaEntity, RomaModel<RomaEntity>> {

    public RomaRenderer(EntityRendererFactory.Context context) {
        super(context, new RomaModel<>(context.getPart(RomaModel.ROMA)), 0.85f);
    }

    @Override
    public Identifier getTexture(RomaEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/roma/roma_texture.png");
    }

    @Override
    public void render(RomaEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
