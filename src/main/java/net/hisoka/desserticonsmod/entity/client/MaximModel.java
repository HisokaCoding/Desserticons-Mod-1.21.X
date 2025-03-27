package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.ArkawaEntity;
import net.hisoka.desserticonsmod.entity.custom.MaximEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class MaximModel <T extends MaximEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer MAXIM = new EntityModelLayer(Identifier.of(DesserticonsMod.MOD_ID, "maxim"), "main");

    private final ModelPart main;
    private final ModelPart leg;
    private final ModelPart leg2;
    private final ModelPart torso;
    private final ModelPart head;
    private final ModelPart arm;
    private final ModelPart arm2;
    private final ModelPart ball;
    public MaximModel(ModelPart root) {
        this.main = root.getChild("main");
        this.leg = this.main.getChild("leg");
        this.leg2 = this.main.getChild("leg2");
        this.torso = this.main.getChild("torso");
        this.head = this.main.getChild("head");
        this.arm = this.main.getChild("arm");
        this.arm2 = this.main.getChild("arm2");
        this.ball = this.main.getChild("ball");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData leg = main.addChild("leg", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -1.0F, -2.0F, 4.0F, 22.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -21.0F, -1.0F));

        ModelPartData leg2 = main.addChild("leg2", ModelPartBuilder.create().uv(16, 0).cuboid(-2.5F, -1.0F, -2.0F, 4.0F, 22.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -21.0F, -1.0F));

        ModelPartData torso = main.addChild("torso", ModelPartBuilder.create().uv(0, 26).cuboid(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -22.0F, 0.0F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(24, 26).cuboid(-3.0F, -14.0F, -4.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -22.0F, 0.0F));

        ModelPartData arm = main.addChild("arm", ModelPartBuilder.create().uv(32, 0).cuboid(-1.5F, 0.0F, -2.0F, 3.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.5F, -29.0F, -1.0F));

        ModelPartData arm2 = main.addChild("arm2", ModelPartBuilder.create().uv(32, 13).cuboid(-1.5F, 0.0F, -2.0F, 3.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.5F, -29.0F, -1.0F));

        ModelPartData ball = main.addChild("ball", ModelPartBuilder.create().uv(0, 39).cuboid(-2.0F, -2.0F, -1.8F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -33.0F, -1.2F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F,30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }


    @Override
    public void setAngles(MaximEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(MaximAnimations.MAXIM_WALK_ANIMATION, limbSwing, limbSwingAmount, 2.0f, 1.0f);
        this.updateAnimation(entity.idleAnimationState, MaximAnimations.MAXIM_IDLE_ANIMATION, ageInTicks, 1f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        main.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return main;
    }

}
