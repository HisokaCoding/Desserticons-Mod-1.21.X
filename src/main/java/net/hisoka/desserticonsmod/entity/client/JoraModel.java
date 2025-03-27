package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.JoraEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class JoraModel<T extends JoraEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer JORA = new EntityModelLayer(Identifier.of(DesserticonsMod.MOD_ID, "jora"), "main");

    private final ModelPart main;
    private final ModelPart arm_main;
    private final ModelPart arm;
    private final ModelPart shoulder;
    private final ModelPart fist;
    private final ModelPart arm_main2;
    private final ModelPart arm2;
    private final ModelPart shoulder2;
    private final ModelPart fist2;
    private final ModelPart torso;
    private final ModelPart leg;
    private final ModelPart leg2;
    private final ModelPart head;
    private final ModelPart head_upper;
    private final ModelPart head_low;
    public JoraModel(ModelPart root) {
        this.main = root.getChild("main");
        this.arm_main = this.main.getChild("arm_main");
        this.arm = this.arm_main.getChild("arm");
        this.shoulder = this.arm_main.getChild("shoulder");
        this.fist = this.arm_main.getChild("fist");
        this.arm_main2 = this.main.getChild("arm_main2");
        this.arm2 = this.arm_main2.getChild("arm2");
        this.shoulder2 = this.arm_main2.getChild("shoulder2");
        this.fist2 = this.arm_main2.getChild("fist2");
        this.torso = this.main.getChild("torso");
        this.leg = this.main.getChild("leg");
        this.leg2 = this.main.getChild("leg2");
        this.head = this.main.getChild("head");
        this.head_upper = this.head.getChild("head_upper");
        this.head_low = this.head.getChild("head_low");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData arm_main = main.addChild("arm_main", ModelPartBuilder.create(), ModelTransform.pivot(18.0F, -28.0F, 5.0F));

        ModelPartData arm = arm_main.addChild("arm", ModelPartBuilder.create().uv(60, 40).cuboid(4.0F, -20.0F, 0.0F, 12.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 28.0F, -5.0F));

        ModelPartData shoulder = arm_main.addChild("shoulder", ModelPartBuilder.create().uv(0, 64).cuboid(-6.0F, -18.0F, -2.0F, 12.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.0F, -1.0F));

        ModelPartData fist = arm_main.addChild("fist", ModelPartBuilder.create().uv(36, 76).cuboid(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(52, 76).cuboid(2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(68, 76).cuboid(-6.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(44, 98).cuboid(-2.0F, -2.0F, 2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(60, 98).cuboid(2.0F, -2.0F, 2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(92, 98).cuboid(-6.0F, -2.0F, 2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(12, 100).cuboid(-6.0F, -4.0F, 2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(80, 90).cuboid(-8.0F, -10.0F, 2.0F, 2.0F, 8.0F, 4.0F, new Dilation(0.0F))
                .uv(32, 90).cuboid(-2.0F, -10.0F, 2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(64, 90).cuboid(-6.0F, -10.0F, 2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(48, 90).cuboid(2.0F, -10.0F, 2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 28.0F, -5.0F));

        ModelPartData arm_main2 = main.addChild("arm_main2", ModelPartBuilder.create(), ModelTransform.pivot(-18.0F, -28.0F, 5.0F));

        ModelPartData arm2 = arm_main2.addChild("arm2", ModelPartBuilder.create().uv(60, 58).cuboid(-16.0F, -20.0F, 0.0F, 12.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 28.0F, -5.0F));

        ModelPartData shoulder2 = arm_main2.addChild("shoulder2", ModelPartBuilder.create().uv(72, 0).cuboid(-6.0F, -18.0F, -2.0F, 12.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.0F, -1.0F));

        ModelPartData fist2 = arm_main2.addChild("fist2", ModelPartBuilder.create().uv(0, 78).cuboid(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(16, 78).cuboid(-6.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(84, 76).cuboid(2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(100, 40).cuboid(-2.0F, -2.0F, 2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(100, 46).cuboid(-6.0F, -2.0F, 2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(100, 52).cuboid(2.0F, -2.0F, 2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(100, 58).cuboid(2.0F, -4.0F, 2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 92).cuboid(6.0F, -10.0F, 2.0F, 2.0F, 8.0F, 4.0F, new Dilation(0.0F))
                .uv(12, 92).cuboid(-2.0F, -10.0F, 2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(92, 90).cuboid(2.0F, -10.0F, 2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(28, 98).cuboid(-6.0F, -10.0F, 2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 28.0F, -5.0F));

        ModelPartData torso = main.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-12.0F, -28.0F, -2.0F, 24.0F, 12.0F, 12.0F, new Dilation(0.0F))
                .uv(60, 24).cuboid(-8.0F, -16.0F, 0.0F, 16.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(36, 64).cuboid(-2.0F, -8.0F, 0.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

        ModelPartData leg = main.addChild("leg", ModelPartBuilder.create().uv(72, 14).cuboid(2.0F, -10.0F, 2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
                .uv(100, 64).cuboid(2.0F, -8.0F, 6.0F, 4.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leg2 = main.addChild("leg2", ModelPartBuilder.create().uv(88, 14).cuboid(2.0F, -10.0F, 2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
                .uv(100, 72).cuboid(2.0F, -8.0F, 6.0F, 4.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 0.0F, 0.0F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head_upper = head.addChild("head_upper", ModelPartBuilder.create().uv(0, 24).cuboid(-8.0F, -8.0F, -10.0F, 16.0F, 10.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -28.0F, 0.0F));

        ModelPartData head_low = head.addChild("head_low", ModelPartBuilder.create().uv(0, 48).cuboid(-8.0F, -26.0F, -10.0F, 16.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F,30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }


    @Override
    public void setAngles(JoraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(JoraAnimations.JORA_WALK_ANIMATION, limbSwing, limbSwingAmount, 2.0f, 1.0f);
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
