package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.ArkawaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ArkawaModel<T extends ArkawaEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer ARKAWA = new EntityModelLayer(Identifier.of(DesserticonsMod.MOD_ID, "arkawa"), "main");

    private final ModelPart main;
    private final ModelPart leg;
    private final ModelPart leg2;
    private final ModelPart foot;
    private final ModelPart foot2;
    private final ModelPart hip;
    private final ModelPart hip2;
    private final ModelPart torso;
    private final ModelPart shoulder;
    private final ModelPart shoulder2;
    private final ModelPart arm;
    private final ModelPart arm2;
    private final ModelPart hand;
    private final ModelPart hand2;
    private final ModelPart head;
    private final ModelPart ball;
    public ArkawaModel(ModelPart root) {
        this.main = root.getChild("main");
        this.leg = this.main.getChild("leg");
        this.leg2 = this.main.getChild("leg2");
        this.foot = this.main.getChild("foot");
        this.foot2 = this.main.getChild("foot2");
        this.hip = this.main.getChild("hip");
        this.hip2 = this.main.getChild("hip2");
        this.torso = this.main.getChild("torso");
        this.shoulder = this.main.getChild("shoulder");
        this.shoulder2 = this.main.getChild("shoulder2");
        this.arm = this.main.getChild("arm");
        this.arm2 = this.main.getChild("arm2");
        this.hand = this.main.getChild("hand");
        this.hand2 = this.main.getChild("hand2");
        this.head = this.main.getChild("head");
        this.ball = root.getChild("ball");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData leg = main.addChild("leg", ModelPartBuilder.create().uv(30, 18).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -9.0F, 0.0F));

        ModelPartData leg2 = main.addChild("leg2", ModelPartBuilder.create().uv(30, 31).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -9.0F, 0.0F));

        ModelPartData foot = main.addChild("foot", ModelPartBuilder.create().uv(38, 11).cuboid(-1.0F, 1.0F, -4.0F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(54, 19).cuboid(1.0F, 1.0F, -3.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(54, 25).cuboid(-2.0F, 1.0F, -3.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(48, 44).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(56, 54).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -2.0F, 0.0F));

        ModelPartData foot2 = main.addChild("foot2", ModelPartBuilder.create().uv(32, 44).cuboid(-1.0F, 1.0F, -4.0F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(54, 31).cuboid(1.0F, 1.0F, -3.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(54, 37).cuboid(-2.0F, 1.0F, -3.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(48, 49).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(56, 56).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -2.0F, 0.0F));

        ModelPartData hip = main.addChild("hip", ModelPartBuilder.create().uv(0, 32).cuboid(-3.0F, 0.0F, -2.0F, 5.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -15.0F, 0.0F));

        ModelPartData hip2 = main.addChild("hip2", ModelPartBuilder.create().uv(38, 0).cuboid(-2.0F, 0.0F, -2.0F, 5.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -15.0F, 0.0F));

        ModelPartData torso = main.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -6.0F, -3.0F, 12.0F, 11.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -20.0F, 0.0F));

        ModelPartData shoulder = main.addChild("shoulder", ModelPartBuilder.create().uv(0, 43).cuboid(-1.5F, 0.0F, -2.5F, 3.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.5F, -25.0F, 0.5F));

        ModelPartData shoulder2 = main.addChild("shoulder2", ModelPartBuilder.create().uv(16, 44).cuboid(-1.5F, 0.0F, -2.5F, 3.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(7.5F, -25.0F, 0.5F));

        ModelPartData arm = main.addChild("arm", ModelPartBuilder.create().uv(32, 51).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(7.5F, -17.0F, 0.5F));

        ModelPartData arm2 = main.addChild("arm2", ModelPartBuilder.create().uv(54, 11).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.5F, -17.0F, 0.5F));

        ModelPartData hand = main.addChild("hand", ModelPartBuilder.create().uv(20, 32).cuboid(-1.5F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(7.5F, -12.0F, 0.5F));

        ModelPartData hand2 = main.addChild("hand2", ModelPartBuilder.create().uv(20, 38).cuboid(-0.5F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.5F, -12.0F, 0.5F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(0, 18).cuboid(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 56).cuboid(-1.0F, -4.0F, -6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(44, 54).cuboid(-2.0F, -6.0F, 4.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(8, 56).cuboid(-1.0F, -5.0F, 3.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -26.0F, 0.0F));

        ModelPartData ball = modelPartData.addChild("ball", ModelPartBuilder.create().uv(78, 9).cuboid(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 7.5F, -8.5F));
        return TexturedModelData.of(modelData, 128, 128);
    }



    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F,30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }


    @Override
    public void setAngles(ArkawaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ArkawaAnimations.ARKAWA_WALK_ANIMATION, limbSwing, limbSwingAmount, 2.0f, 1.0f);
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
