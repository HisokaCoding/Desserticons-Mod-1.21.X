package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.CabbaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CabbaRenderer extends MobEntityRenderer<CabbaEntity, CabbaModel<CabbaEntity>> {
    public CabbaRenderer(EntityRendererFactory.Context context) {
        super(context, new CabbaModel<>(context.getPart(CabbaModel.CABBA)), 0.65f);
    }

    @Override
    public Identifier getTexture(CabbaEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/cabba/cabba_texture.png");
    }

    @Override
    public void render(CabbaEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
