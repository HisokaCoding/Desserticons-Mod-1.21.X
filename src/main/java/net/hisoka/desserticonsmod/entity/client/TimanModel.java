package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.TimanEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class TimanModel<T extends TimanEntity> extends SinglePartEntityModel<T>{
    public static final EntityModelLayer TIMAN = new EntityModelLayer(Identifier.of(DesserticonsMod.MOD_ID, "timan"),"main");

    private final ModelPart main;
    private final ModelPart leg;
    private final ModelPart leg2;
    private final ModelPart butt;
    private final ModelPart torso;
    private final ModelPart arm;
    private final ModelPart arm2;
    private final ModelPart head;
    public TimanModel(ModelPart root) {
        this.main = root.getChild("main");
        this.leg = this.main.getChild("leg");
        this.leg2 = this.main.getChild("leg2");
        this.butt = this.main.getChild("butt");
        this.torso = this.main.getChild("torso");
        this.arm = this.main.getChild("arm");
        this.arm2 = this.main.getChild("arm2");
        this.head = this.main.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData leg = main.addChild("leg", ModelPartBuilder.create().uv(4, 10).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -2.0F, 0.0F));

        ModelPartData leg2 = main.addChild("leg2", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.0F, 0.0F));

        ModelPartData butt = main.addChild("butt", ModelPartBuilder.create().uv(8, 6).cuboid(-2.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(12, 3).cuboid(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 12).cuboid(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

        ModelPartData torso = main.addChild("torso", ModelPartBuilder.create().uv(0, 6).cuboid(-2.0F, -6.0F, 0.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData arm = main.addChild("arm", ModelPartBuilder.create().uv(8, 8).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -6.0F, 0.0F));

        ModelPartData arm2 = main.addChild("arm2", ModelPartBuilder.create().uv(0, 10).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -6.0F, 0.0F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -9.0F, -1.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }


    @Override
    public void setAngles(TimanEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(TimanAnimations.TIMAN_WALK_ANIMATION, limbSwing, limbSwingAmount, 2f, 2.5f);
    }


    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        main.render(matrices, vertexConsumer, light, overlay, color);
    }
    @Override
    public ModelPart getPart() {
        return main;
    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F,30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

}
