package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.SemenEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SemenModel <T extends SemenEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer SEMEN = new EntityModelLayer(Identifier.of(DesserticonsMod.MOD_ID, "semen"),"main");

    private final ModelPart main;
    private final ModelPart leg;
    private final ModelPart leg2;
    private final ModelPart torso;
    private final ModelPart head;
    private final ModelPart headup;
    private final ModelPart headlow;
    private final ModelPart arm;
    private final ModelPart arm2;
    public SemenModel(ModelPart root) {
        this.main = root.getChild("main");
        this.leg = this.main.getChild("leg");
        this.leg2 = this.main.getChild("leg2");
        this.torso = this.main.getChild("torso");
        this.head = this.main.getChild("head");
        this.headup = this.head.getChild("headup");
        this.headlow = this.head.getChild("headlow");
        this.arm = this.main.getChild("arm");
        this.arm2 = this.main.getChild("arm2");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData leg = main.addChild("leg", ModelPartBuilder.create().uv(0, 68).cuboid(-2.0F, 5.0F, -4.0F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(22, 52).cuboid(-3.0F, 0.0F, -2.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -6.0F, 0.0F));

        ModelPartData leg2 = main.addChild("leg2", ModelPartBuilder.create().uv(40, 70).cuboid(-2.0F, 5.0F, -4.0F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(44, 60).cuboid(-3.0F, 0.0F, -2.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -6.0F, 0.0F));

        ModelPartData torso = main.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -17.0F, -7.0F, 18.0F, 11.0F, 13.0F, new Dilation(0.0F))
                .uv(48, 24).cuboid(1.0F, -24.0F, -5.0F, 8.0F, 7.0F, 11.0F, new Dilation(0.0F))
                .uv(0, 52).cuboid(-1.0F, -24.0F, -3.0F, 2.0F, 7.0F, 9.0F, new Dilation(0.0F))
                .uv(48, 42).cuboid(-9.0F, -24.0F, -5.0F, 8.0F, 7.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -26.0F, 3.0F));

        ModelPartData headup = head.addChild("headup", ModelPartBuilder.create().uv(0, 24).cuboid(-7.0F, -6.0F, -10.0F, 14.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

        ModelPartData headlow = head.addChild("headlow", ModelPartBuilder.create().uv(0, 40).cuboid(-7.0F, -26.0F, -6.0F, 14.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 26.0F, -3.0F));

        ModelPartData arm = main.addChild("arm", ModelPartBuilder.create().uv(62, 0).cuboid(-2.0F, 0.0F, -2.0F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F))
                .uv(22, 62).cuboid(-2.0F, 7.0F, -2.0F, 4.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(11.0F, -23.0F, 0.0F));

        ModelPartData arm2 = main.addChild("arm2", ModelPartBuilder.create().uv(62, 12).cuboid(-3.0F, 0.0F, -2.0F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F))
                .uv(66, 60).cuboid(-2.0F, 7.0F, -2.0F, 4.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-11.0F, -23.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(SemenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(SemenAnimations.SEMEN_WALK_ANIMATION, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, SemenAnimations.SEMEN_IDLE_ANIMATION, ageInTicks, 1f);
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
