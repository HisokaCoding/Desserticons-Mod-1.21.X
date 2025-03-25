package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.ArkawaEntity;
import net.hisoka.desserticonsmod.entity.custom.JoraEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class JoraRenderer extends MobEntityRenderer<JoraEntity, JoraModel<JoraEntity>>{

    public JoraRenderer(EntityRendererFactory.Context context) {
        super(context, new JoraModel(context.getPart(JoraModel.JORA)), 0.65f);
    }

    @Override
    public Identifier getTexture(JoraEntity entity) {
        return Identifier.of(DesserticonsMod.MOD_ID, "textures/entity/jora/jora_texture.png");
    }

    @Override
    public void render(JoraEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
