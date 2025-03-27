package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.SeregaEntity;
import net.hisoka.desserticonsmod.entity.custom.SonechkaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SonechkaModel <T extends SonechkaEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer SONECHKA = new EntityModelLayer(Identifier.of(DesserticonsMod.MOD_ID, "sonechka"), "main");

    private final ModelPart main;
    private final ModelPart leg;
    private final ModelPart foot;
    private final ModelPart hip;
    private final ModelPart butt;
    private final ModelPart leg2;
    private final ModelPart foot2;
    private final ModelPart hip2;
    private final ModelPart butt2;
    private final ModelPart torso;
    private final ModelPart arm;
    private final ModelPart shoulder;
    private final ModelPart hand;
    private final ModelPart arm2;
    private final ModelPart shoulder2;
    private final ModelPart hand2;
    private final ModelPart head;
    private final ModelPart hair;
    public SonechkaModel(ModelPart root) {
        this.main = root.getChild("main");
        this.leg = this.main.getChild("leg");
        this.foot = this.leg.getChild("foot");
        this.hip = this.leg.getChild("hip");
        this.butt = this.leg.getChild("butt");
        this.leg2 = this.main.getChild("leg2");
        this.foot2 = this.leg2.getChild("foot2");
        this.hip2 = this.leg2.getChild("hip2");
        this.butt2 = this.leg2.getChild("butt2");
        this.torso = this.main.getChild("torso");
        this.arm = this.main.getChild("arm");
        this.shoulder = this.arm.getChild("shoulder");
        this.hand = this.arm.getChild("hand");
        this.arm2 = this.main.getChild("arm2");
        this.shoulder2 = this.arm2.getChild("shoulder2");
        this.hand2 = this.arm2.getChild("hand2");
        this.head = this.main.getChild("head");
        this.hair = this.head.getChild("hair");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData leg = main.addChild("leg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData foot = leg.addChild("foot", ModelPartBuilder.create().uv(28, 0).cuboid(0.0F, -8.0F, -2.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData hip = leg.addChild("hip", ModelPartBuilder.create().uv(28, 21).cuboid(0.0F, -16.0F, -3.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData butt = leg.addChild("butt", ModelPartBuilder.create().uv(0, 43).cuboid(0.0F, -16.0F, 2.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leg2 = main.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

        ModelPartData foot2 = leg2.addChild("foot2", ModelPartBuilder.create().uv(18, 34).cuboid(0.0F, -8.0F, -2.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData hip2 = leg2.addChild("hip2", ModelPartBuilder.create().uv(0, 30).cuboid(-1.0F, -16.0F, -3.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData butt2 = leg2.addChild("butt2", ModelPartBuilder.create().uv(12, 45).cuboid(-1.0F, -16.0F, 2.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData torso = main.addChild("torso", ModelPartBuilder.create().uv(24, 11).cuboid(-3.0F, -21.0F, -3.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-4.0F, -26.0F, -3.0F, 8.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(24, 45).cuboid(-4.0F, -26.0F, -5.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(46, 11).cuboid(0.0F, -26.0F, -5.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 23).cuboid(-4.0F, -27.0F, -3.0F, 8.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData arm = main.addChild("arm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData shoulder = arm.addChild("shoulder", ModelPartBuilder.create().uv(30, 34).cuboid(4.0F, -27.0F, -1.0F, 2.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData hand = arm.addChild("hand", ModelPartBuilder.create().uv(46, 17).cuboid(4.0F, -19.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData arm2 = main.addChild("arm2", ModelPartBuilder.create(), ModelTransform.pivot(-10.0F, 0.0F, 0.0F));

        ModelPartData shoulder2 = arm2.addChild("shoulder2", ModelPartBuilder.create().uv(40, 0).cuboid(4.0F, -27.0F, -1.0F, 2.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData hand2 = arm2.addChild("hand2", ModelPartBuilder.create().uv(46, 24).cuboid(4.0F, -19.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(18, 30).cuboid(-1.0F, -29.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-3.0F, -35.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData hair = head.addChild("hair", ModelPartBuilder.create().uv(40, 34).cuboid(3.0F, -29.0F, -3.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(40, 42).cuboid(-3.0F, -29.0F, -3.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(46, 31).cuboid(-3.0F, -29.0F, 3.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }


    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F,30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }


    @Override
    public void setAngles(SonechkaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);
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
