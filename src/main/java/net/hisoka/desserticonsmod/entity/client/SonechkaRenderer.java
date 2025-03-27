package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.SeregaEntity;
import net.hisoka.desserticonsmod.entity.custom.SonechkaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SonechkaRenderer  extends MobEntityRenderer<SonechkaEntity, SonechkaModel<SonechkaEntity>> {

    public SonechkaRenderer(EntityRendererFactory.Context context) {
        super(context, new SonechkaModel(context.getPart(SonechkaModel.SONECHKA)), 0.65f);
    }

    @Override
    public Identifier getTexture(SonechkaEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/sonechka/sonechka_texture.png");
    }

    @Override
    public void render(SonechkaEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
