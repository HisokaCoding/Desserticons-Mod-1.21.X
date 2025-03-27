package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.TimanEntity;
import net.hisoka.desserticonsmod.entity.custom.YuraEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class YuraModel<T extends YuraEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer YURA = new EntityModelLayer(Identifier.of(DesserticonsMod.MOD_ID, "yura"),"main");

    private final ModelPart main;
    private final ModelPart head;
    private final ModelPart torso;
    private final ModelPart full_leg1;
    private final ModelPart foot;
    private final ModelPart leg_low;
    private final ModelPart hip;
    private final ModelPart full_leg2;
    private final ModelPart foot2;
    private final ModelPart leg_low2;
    private final ModelPart hip2;
    private final ModelPart full_arm1;
    private final ModelPart arm;
    private final ModelPart arm3;
    private final ModelPart shoulder;
    private final ModelPart full_arm2;
    private final ModelPart shoulder2;
    private final ModelPart arm2;
    private final ModelPart arm4;
    public YuraModel(ModelPart root) {
        this.main = root.getChild("main");
        this.head = this.main.getChild("head");
        this.torso = this.main.getChild("torso");
        this.full_leg1 = this.main.getChild("full_leg1");
        this.foot = this.full_leg1.getChild("foot");
        this.leg_low = this.full_leg1.getChild("leg_low");
        this.hip = this.full_leg1.getChild("hip");
        this.full_leg2 = this.main.getChild("full_leg2");
        this.foot2 = this.full_leg2.getChild("foot2");
        this.leg_low2 = this.full_leg2.getChild("leg_low2");
        this.hip2 = this.full_leg2.getChild("hip2");
        this.full_arm1 = this.main.getChild("full_arm1");
        this.arm = this.full_arm1.getChild("arm");
        this.arm3 = this.full_arm1.getChild("arm3");
        this.shoulder = this.full_arm1.getChild("shoulder");
        this.full_arm2 = this.main.getChild("full_arm2");
        this.shoulder2 = this.full_arm2.getChild("shoulder2");
        this.arm2 = this.full_arm2.getChild("arm2");
        this.arm4 = this.full_arm2.getChild("arm4");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(32, 51).cuboid(-2.0F, -35.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 25).cuboid(-3.0F, -41.0F, -4.0F, 6.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData torso = main.addChild("torso", ModelPartBuilder.create().uv(0, 12).cuboid(-5.0F, -27.0F, -2.0F, 10.0F, 8.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-6.0F, -33.0F, -3.0F, 12.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData full_leg1 = main.addChild("full_leg1", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, -19.0F, 1.0F));

        ModelPartData foot = full_leg1.addChild("foot", ModelPartBuilder.create().uv(0, 49).cuboid(1.0F, -2.0F, -3.0F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 19.0F, -1.0F));

        ModelPartData leg_low = full_leg1.addChild("leg_low", ModelPartBuilder.create().uv(26, 25).cuboid(0.0F, -12.0F, -2.0F, 5.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 19.0F, -1.0F));

        ModelPartData hip = full_leg1.addChild("hip", ModelPartBuilder.create().uv(30, 15).cuboid(0.0F, -19.0F, -1.0F, 4.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 19.0F, -1.0F));

        ModelPartData full_leg2 = main.addChild("full_leg2", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, -19.0F, 0.0F));

        ModelPartData foot2 = full_leg2.addChild("foot2", ModelPartBuilder.create().uv(16, 51).cuboid(1.0F, -2.0F, -3.0F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 19.0F, 0.0F));

        ModelPartData leg_low2 = full_leg2.addChild("leg_low2", ModelPartBuilder.create().uv(36, 0).cuboid(0.0F, -12.0F, -2.0F, 5.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 19.0F, 0.0F));

        ModelPartData hip2 = full_leg2.addChild("hip2", ModelPartBuilder.create().uv(46, 26).cuboid(0.0F, -19.0F, -1.0F, 4.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 19.0F, 0.0F));

        ModelPartData full_arm1 = main.addChild("full_arm1", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -33.0F, 0.0F));

        ModelPartData arm = full_arm1.addChild("arm", ModelPartBuilder.create().uv(44, 40).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

        ModelPartData arm3 = full_arm1.addChild("arm3", ModelPartBuilder.create().uv(48, 51).cuboid(-1.5F, -3.5F, -1.0F, 3.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 14.5F, 0.0F));

        ModelPartData shoulder = full_arm1.addChild("shoulder", ModelPartBuilder.create().uv(0, 38).cuboid(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 1.5F, 0.0F));

        ModelPartData full_arm2 = main.addChild("full_arm2", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -33.0F, 0.0F));

        ModelPartData shoulder2 = full_arm2.addChild("shoulder2", ModelPartBuilder.create().uv(22, 40).cuboid(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 1.5F, 0.0F));

        ModelPartData arm2 = full_arm2.addChild("arm2", ModelPartBuilder.create().uv(46, 15).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

        ModelPartData arm4 = full_arm2.addChild("arm4", ModelPartBuilder.create().uv(0, 56).cuboid(-1.5F, -3.5F, -1.0F, 3.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 14.5F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(YuraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(YuraAnimations.YURA_WALK_ANIMATION, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, YuraAnimations.YURA_IDLE_ANIMATION, ageInTicks, 1f);
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
