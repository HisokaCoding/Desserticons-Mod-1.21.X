package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.RomaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class RomaModel <T extends RomaEntity> extends SinglePartEntityModel<T>{
    public static final EntityModelLayer ROMA = new EntityModelLayer(Identifier.of(DesserticonsMod.MOD_ID, "roma"),"main");

    private final ModelPart main;
    private final ModelPart hip_left;
    private final ModelPart hip_right;
    private final ModelPart golen_left;
    private final ModelPart golen_righht;
    private final ModelPart left_foot;
    private final ModelPart right_foot;
    private final ModelPart body;
    private final ModelPart arm_left;
    private final ModelPart arm_right;
    private final ModelPart halfarm_left;
    private final ModelPart halarm_right;
    private final ModelPart fist_right;
    private final ModelPart fist_left;
    private final ModelPart low_head;
    private final ModelPart head;
    public RomaModel(ModelPart root) {
        this.main = root.getChild("main");
        this.hip_left = this.main.getChild("hip_left");
        this.hip_right = this.main.getChild("hip_right");
        this.golen_left = this.main.getChild("golen_left");
        this.golen_righht = this.main.getChild("golen_righht");
        this.left_foot = this.main.getChild("left_foot");
        this.right_foot = this.main.getChild("right_foot");
        this.body = this.main.getChild("body");
        this.arm_left = this.main.getChild("arm_left");
        this.arm_right = this.main.getChild("arm_right");
        this.halfarm_left = this.main.getChild("halfarm_left");
        this.halarm_right = this.main.getChild("halarm_right");
        this.fist_right = this.main.getChild("fist_right");
        this.fist_left = this.main.getChild("fist_left");
        this.low_head = this.main.getChild("low_head");
        this.head = this.main.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData hip_left = main.addChild("hip_left", ModelPartBuilder.create(), ModelTransform.pivot(-4.5F, -18.5F, 3.0F));

        ModelPartData __r1 = hip_left.addChild("__r1", ModelPartBuilder.create().uv(118, 97).cuboid(-4.5F, -5.0F, -3.5F, 7.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 4.0F, -2.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData hip_right = main.addChild("hip_right", ModelPartBuilder.create(), ModelTransform.pivot(7.5F, -18.5F, 3.0F));

        ModelPartData __r2 = hip_right.addChild("__r2", ModelPartBuilder.create().uv(112, 81).cuboid(-4.5F, -5.0F, -3.5F, 7.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 4.0F, -2.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData golen_left = main.addChild("golen_left", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, -10.0F, 1.0F));

        ModelPartData __r3 = golen_left.addChild("__r3", ModelPartBuilder.create().uv(26, 120).cuboid(-3.5F, -6.0F, -2.5F, 6.0F, 11.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 4.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData golen_righht = main.addChild("golen_righht", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -10.0F, 1.0F));

        ModelPartData __r4 = golen_righht.addChild("__r4", ModelPartBuilder.create().uv(124, 0).cuboid(-3.5F, -6.0F, -2.5F, 6.0F, 11.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData left_foot = main.addChild("left_foot", ModelPartBuilder.create().uv(100, 122).cuboid(-1.0F, 0.0F, -8.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(74, 122).cuboid(0.0F, 0.0F, -10.0F, 3.0F, 2.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 120).cuboid(-4.0F, 0.0F, -10.0F, 3.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -2.0F, 5.0F));

        ModelPartData right_foot = main.addChild("right_foot", ModelPartBuilder.create().uv(124, 16).cuboid(0.0F, 0.0F, -7.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(48, 122).cuboid(1.0F, 0.0F, -9.0F, 3.0F, 2.0F, 10.0F, new Dilation(0.0F))
                .uv(118, 113).cuboid(-3.0F, 0.0F, -9.0F, 3.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, -2.0F, 4.0F));

        ModelPartData body = main.addChild("body", ModelPartBuilder.create().uv(64, 28).cuboid(-4.5F, -23.4F, 0.3F, 19.0F, 13.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, -19.5F, 1.0F));

        ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(0, 54).cuboid(-9.0F, -12.0F, 1.0F, 21.0F, 12.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -18.5F, 0.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(0, 28).cuboid(-5.0F, -14.0F, -4.0F, 20.0F, 14.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData arm_left = main.addChild("arm_left", ModelPartBuilder.create(), ModelTransform.pivot(-13.0F, -47.0F, 10.0F));

        ModelPartData __r5 = arm_left.addChild("__r5", ModelPartBuilder.create().uv(66, 0).cuboid(-8.0F, -8.0F, -17.0F, 9.0F, 8.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, 0.0F, 1.4399F, 0.0F, 0.0F));

        ModelPartData arm_right = main.addChild("arm_right", ModelPartBuilder.create(), ModelTransform.pivot(16.0F, -47.0F, 10.0F));

        ModelPartData arm_right_r1 = arm_right.addChild("arm_right_r1", ModelPartBuilder.create().uv(66, 53).cuboid(-7.0F, -8.0F, -17.0F, 9.0F, 8.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, 0.0F, 1.4399F, 0.0F, 0.0F));

        ModelPartData halfarm_left = main.addChild("halfarm_left", ModelPartBuilder.create(), ModelTransform.pivot(-14.0F, -31.0F, 4.0F));

        ModelPartData __r6 = halfarm_left.addChild("__r6", ModelPartBuilder.create().uv(62, 81).cuboid(-5.0F, -6.0F, -13.0F, 7.0F, 7.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 3.0F, 0.0F, 0.8727F, 0.0F, 0.0F));

        ModelPartData halarm_right = main.addChild("halarm_right", ModelPartBuilder.create(), ModelTransform.pivot(16.0F, -31.0F, 7.0F));

        ModelPartData __r7 = halarm_right.addChild("__r7", ModelPartBuilder.create().uv(0, 95).cuboid(-5.0F, -6.0F, -13.0F, 7.0F, 7.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 3.0F, -3.0F, 0.8727F, 0.0F, 0.0F));

        ModelPartData fist_right = main.addChild("fist_right", ModelPartBuilder.create().uv(84, 106).cuboid(-5.0F, -5.0F, -4.0F, 9.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(17.0F, -19.0F, -7.0F));

        ModelPartData fist_left = main.addChild("fist_left", ModelPartBuilder.create().uv(50, 106).cuboid(-4.0F, -5.0F, -4.0F, 9.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-14.0F, -19.0F, -7.0F));

        ModelPartData low_head = main.addChild("low_head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.0F, 0.5F));

        ModelPartData low_head_r1 = low_head.addChild("low_head_r1", ModelPartBuilder.create().uv(0, 78).cuboid(-6.0F, -2.0F, -6.0F, 16.0F, 2.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -13.0F, -15.5F, 18.0F, 13.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -54.0F, 9.5F));
        return TexturedModelData.of(modelData, 256, 256);
    }
    @Override
    public void setAngles(RomaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(RomaAnimations.ROMA_WALK_ANIMATION, limbSwing, limbSwingAmount, 2f, 2.5f);
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
