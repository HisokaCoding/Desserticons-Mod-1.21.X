package net.hisoka.desserticonsmod.entity.client;

import net.hisoka.desserticonsmod.DesserticonsMod;
import net.hisoka.desserticonsmod.entity.custom.CabbaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class CabbaModel<T extends CabbaEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer CABBA = new EntityModelLayer(Identifier.of(DesserticonsMod.MOD_ID, "cabba"), "main");

    private final ModelPart main;
    private final ModelPart head;
    private final ModelPart lowerpart;
    private final ModelPart higherpart;
    private final ModelPart arm2;
    private final ModelPart arm;
    private final ModelPart shoulders;
    private final ModelPart leg2;
    private final ModelPart hip;
    private final ModelPart foot;
    private final ModelPart lower;
    private final ModelPart leg;
    private final ModelPart foot2;
    private final ModelPart hip2;
    private final ModelPart lower2;
    private final ModelPart spine;
    private final ModelPart vertebra2;
    private final ModelPart ribs2;
    private final ModelPart rib5;
    private final ModelPart rib6;
    private final ModelPart rib7;
    private final ModelPart rib8;
    private final ModelPart vertebra;
    private final ModelPart ribs;
    private final ModelPart rib2;
    private final ModelPart rib;
    private final ModelPart rib3;
    private final ModelPart rib4;
    private final ModelPart vertebra3;
    private final ModelPart ribs3;
    private final ModelPart rib9;
    private final ModelPart rib10;
    public CabbaModel(ModelPart root) {
        this.main = root.getChild("main");
        this.head = this.main.getChild("head");
        this.lowerpart = this.head.getChild("lowerpart");
        this.higherpart = this.head.getChild("higherpart");
        this.arm2 = this.main.getChild("arm2");
        this.arm = this.main.getChild("arm");
        this.shoulders = this.main.getChild("shoulders");
        this.leg2 = this.main.getChild("leg2");
        this.hip = this.leg2.getChild("hip");
        this.foot = this.leg2.getChild("foot");
        this.lower = this.leg2.getChild("lower");
        this.leg = this.main.getChild("leg");
        this.foot2 = this.leg.getChild("foot2");
        this.hip2 = this.leg.getChild("hip2");
        this.lower2 = this.leg.getChild("lower2");
        this.spine = this.main.getChild("spine");
        this.vertebra2 = this.spine.getChild("vertebra2");
        this.ribs2 = this.vertebra2.getChild("ribs2");
        this.rib5 = this.ribs2.getChild("rib5");
        this.rib6 = this.ribs2.getChild("rib6");
        this.rib7 = this.ribs2.getChild("rib7");
        this.rib8 = this.ribs2.getChild("rib8");
        this.vertebra = this.spine.getChild("vertebra");
        this.ribs = this.vertebra.getChild("ribs");
        this.rib2 = this.ribs.getChild("rib2");
        this.rib = this.ribs.getChild("rib");
        this.rib3 = this.ribs.getChild("rib3");
        this.rib4 = this.ribs.getChild("rib4");
        this.vertebra3 = this.spine.getChild("vertebra3");
        this.ribs3 = this.vertebra3.getChild("ribs3");
        this.rib9 = this.ribs3.getChild("rib9");
        this.rib10 = this.ribs3.getChild("rib10");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -10.8F, -2.0F));

        ModelPartData lowerpart = head.addChild("lowerpart", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -14.0F, 0.0F));

        ModelPartData cube_r1 = lowerpart.addChild("cube_r1", ModelPartBuilder.create().uv(38, 32).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(32, 38).cuboid(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(38, 31).cuboid(-4.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(38, 30).cuboid(-6.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.5F, -4.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData cube_r2 = lowerpart.addChild("cube_r2", ModelPartBuilder.create().uv(38, 34).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -0.2F, -2.3F, 1.5708F, 1.2217F, 1.5708F));

        ModelPartData cube_r3 = lowerpart.addChild("cube_r3", ModelPartBuilder.create().uv(34, 38).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -0.2F, -2.3F, 1.5708F, 1.2217F, 1.5708F));

        ModelPartData cube_r4 = lowerpart.addChild("cube_r4", ModelPartBuilder.create().uv(38, 35).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 0.5F, -4.0F, 1.5708F, 1.2217F, 1.5708F));

        ModelPartData cube_r5 = lowerpart.addChild("cube_r5", ModelPartBuilder.create().uv(38, 33).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.5F, -4.0F, 1.5708F, 1.2217F, 1.5708F));

        ModelPartData cube_r6 = lowerpart.addChild("cube_r6", ModelPartBuilder.create().uv(0, 12).cuboid(-3.0F, -1.0F, -5.0F, 7.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData higherpart = head.addChild("higherpart", ModelPartBuilder.create(), ModelTransform.of(0.0F, -14.4F, 0.6F, 1.0036F, 0.0F, 0.0F));

        ModelPartData cube_r7 = higherpart.addChild("cube_r7", ModelPartBuilder.create().uv(6, 39).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(5.4F, -2.8F, -3.9F, -1.5708F, 0.9163F, -1.5708F));

        ModelPartData cube_r8 = higherpart.addChild("cube_r8", ModelPartBuilder.create().uv(4, 39).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.4F, -2.8F, -3.9F, -1.5708F, 0.9163F, -1.5708F));

        ModelPartData cube_r9 = higherpart.addChild("cube_r9", ModelPartBuilder.create().uv(2, 39).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 39).cuboid(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(38, 38).cuboid(-4.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(36, 38).cuboid(-6.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -3.2F, -4.5F, -0.6545F, 0.0F, 0.0F));

        ModelPartData cube_r10 = higherpart.addChild("cube_r10", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -5.0F, -6.0F, 8.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -1.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData arm2 = main.addChild("arm2", ModelPartBuilder.create().uv(16, 29).cuboid(-0.5F, 0.6F, -0.7F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 35).cuboid(-1.0F, 12.7F, -1.4F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, -22.0F, -1.0F));

        ModelPartData cube_r11 = arm2.addChild("cube_r11", ModelPartBuilder.create().uv(30, 38).cuboid(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 16.9F, -2.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData cube_r12 = arm2.addChild("cube_r12", ModelPartBuilder.create().uv(24, 35).cuboid(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 16.8F, -2.3F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r13 = arm2.addChild("cube_r13", ModelPartBuilder.create().uv(38, 28).cuboid(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 15.6F, -2.4F, -0.0436F, 0.0F, 0.0F));

        ModelPartData cube_r14 = arm2.addChild("cube_r14", ModelPartBuilder.create().uv(28, 38).cuboid(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 15.5F, -2.6F, -0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r15 = arm2.addChild("cube_r15", ModelPartBuilder.create().uv(38, 26).cuboid(1.0F, -2.0F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.2F, 16.2F, -1.5F, 0.0F, 0.0F, 0.2618F));

        ModelPartData cube_r16 = arm2.addChild("cube_r16", ModelPartBuilder.create().uv(38, 24).cuboid(1.0F, -2.0F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.6F, 15.8F, -1.5F, 0.0F, 0.0F, -0.2618F));

        ModelPartData cube_r17 = arm2.addChild("cube_r17", ModelPartBuilder.create().uv(30, 32).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.6F, 10.1F, 0.2F, -0.2182F, 0.0F, 0.0F));

        ModelPartData cube_r18 = arm2.addChild("cube_r18", ModelPartBuilder.create().uv(30, 28).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 9.0F, 0.5F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r19 = arm2.addChild("cube_r19", ModelPartBuilder.create().uv(30, 8).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, 0.5F, 0.7854F, 0.0F, 0.0F));

        ModelPartData arm = main.addChild("arm", ModelPartBuilder.create().uv(26, 28).cuboid(-0.5F, 0.8F, -0.5F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F))
                .uv(34, 17).cuboid(-1.0F, 12.9F, -1.2F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -22.2F, -1.2F));

        ModelPartData cube_r20 = arm.addChild("cube_r20", ModelPartBuilder.create().uv(16, 28).cuboid(-1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 17.1F, -1.8F, 0.3491F, 0.0F, 0.0F));

        ModelPartData cube_r21 = arm.addChild("cube_r21", ModelPartBuilder.create().uv(24, 19).cuboid(-1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 17.0F, -2.1F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r22 = arm.addChild("cube_r22", ModelPartBuilder.create().uv(18, 37).cuboid(0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 15.8F, -2.2F, -0.0436F, 0.0F, 0.0F));

        ModelPartData cube_r23 = arm.addChild("cube_r23", ModelPartBuilder.create().uv(24, 33).cuboid(0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 15.7F, -2.4F, -0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r24 = arm.addChild("cube_r24", ModelPartBuilder.create().uv(24, 31).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.2F, 16.4F, -1.3F, 0.0F, 0.0F, -0.2618F));

        ModelPartData cube_r25 = arm.addChild("cube_r25", ModelPartBuilder.create().uv(24, 29).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.6F, 16.0F, -1.3F, 0.0F, 0.0F, 0.2618F));

        ModelPartData cube_r26 = arm.addChild("cube_r26", ModelPartBuilder.create().uv(20, 29).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.6F, 10.3F, 0.4F, -0.2182F, 0.0F, 0.0F));

        ModelPartData cube_r27 = arm.addChild("cube_r27", ModelPartBuilder.create().uv(30, 4).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 9.2F, 0.7F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r28 = arm.addChild("cube_r28", ModelPartBuilder.create().uv(30, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.7F, 0.7F, 0.7854F, 0.0F, 0.0F));

        ModelPartData shoulders = main.addChild("shoulders", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r29 = shoulders.addChild("cube_r29", ModelPartBuilder.create().uv(0, 19).cuboid(-2.0F, -1.0F, -1.0F, 11.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -22.2F, -0.5F, 0.7854F, 0.0F, 0.0F));

        ModelPartData leg2 = main.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

        ModelPartData hip = leg2.addChild("hip", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.0F, -1.0F));

        ModelPartData cube_r30 = hip.addChild("cube_r30", ModelPartBuilder.create().uv(34, 32).cuboid(0.0F, -5.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 5.3F, -1.5F, -0.4363F, 0.0F, 0.0F));

        ModelPartData cube_r31 = hip.addChild("cube_r31", ModelPartBuilder.create().uv(0, 28).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, 0.9F, 0.7854F, 0.0F, 0.0F));

        ModelPartData foot = leg2.addChild("foot", ModelPartBuilder.create().uv(8, 32).cuboid(-1.0F, -0.1F, -3.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(8, 28).cuboid(-1.0F, -1.1F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.9F, 0.0F));

        ModelPartData lower = leg2.addChild("lower", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.2F, -2.2F));

        ModelPartData cube_r32 = lower.addChild("cube_r32", ModelPartBuilder.create().uv(20, 34).cuboid(0.0F, -6.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 5.1F, 3.7F, 0.5236F, 0.0F, 0.0F));

        ModelPartData cube_r33 = lower.addChild("cube_r33", ModelPartBuilder.create().uv(28, 20).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.4F, 0.6F, 0.7854F, 0.0F, 0.0F));

        ModelPartData leg = main.addChild("leg", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

        ModelPartData foot2 = leg.addChild("foot2", ModelPartBuilder.create().uv(26, 24).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 32).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

        ModelPartData hip2 = leg.addChild("hip2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.2F, -0.7F));

        ModelPartData cube_r34 = hip2.addChild("cube_r34", ModelPartBuilder.create().uv(26, 12).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.7F, 0.6F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r35 = hip2.addChild("cube_r35", ModelPartBuilder.create().uv(34, 24).cuboid(0.0F, -5.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 5.5F, -1.8F, -0.4363F, 0.0F, 0.0F));

        ModelPartData lower2 = leg.addChild("lower2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.5F, -2.2F));

        ModelPartData cube_r36 = lower2.addChild("cube_r36", ModelPartBuilder.create().uv(26, 16).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.7F, 0.6F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r37 = lower2.addChild("cube_r37", ModelPartBuilder.create().uv(34, 12).cuboid(0.0F, -6.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 5.4F, 3.7F, 0.5236F, 0.0F, 0.0F));

        ModelPartData spine = main.addChild("spine", ModelPartBuilder.create().uv(18, 21).cuboid(-2.0F, 0.1F, -2.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.0F));

        ModelPartData cube_r38 = spine.addChild("cube_r38", ModelPartBuilder.create().uv(18, 24).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -12.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData vertebra2 = spine.addChild("vertebra2", ModelPartBuilder.create().uv(6, 21).cuboid(-0.5F, -4.0F, -1.0F, 1.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -9.0F, 2.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData ribs2 = vertebra2.addChild("ribs2", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, 14.0F, -3.0F));

        ModelPartData rib5 = ribs2.addChild("rib5", ModelPartBuilder.create().uv(36, 23).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(24, 36).cuboid(-2.0F, -1.0F, -3.8F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -16.0F, 4.0F));

        ModelPartData cube_r39 = rib5.addChild("cube_r39", ModelPartBuilder.create().uv(14, 38).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.3F, 0.0F, -3.1F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r40 = rib5.addChild("cube_r40", ModelPartBuilder.create().uv(38, 4).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.4F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData rib6 = ribs2.addChild("rib6", ModelPartBuilder.create().uv(34, 36).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 37).cuboid(-2.0F, -1.0F, -3.8F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -14.0F, 4.0F));

        ModelPartData cube_r41 = rib6.addChild("cube_r41", ModelPartBuilder.create().uv(38, 14).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.3F, 0.0F, -3.1F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r42 = rib6.addChild("cube_r42", ModelPartBuilder.create().uv(38, 5).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.4F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData rib7 = ribs2.addChild("rib7", ModelPartBuilder.create().uv(6, 37).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(12, 37).cuboid(-2.0F, -1.0F, -3.8F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -15.0F, 4.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r43 = rib7.addChild("cube_r43", ModelPartBuilder.create().uv(38, 15).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.3F, 0.0F, -3.1F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r44 = rib7.addChild("cube_r44", ModelPartBuilder.create().uv(6, 38).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.4F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData rib8 = ribs2.addChild("rib8", ModelPartBuilder.create().uv(24, 37).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(30, 37).cuboid(-2.0F, -1.0F, -3.8F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -17.0F, 4.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r45 = rib8.addChild("cube_r45", ModelPartBuilder.create().uv(38, 16).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.3F, 0.0F, -3.1F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r46 = rib8.addChild("cube_r46", ModelPartBuilder.create().uv(38, 6).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.4F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData vertebra = spine.addChild("vertebra", ModelPartBuilder.create().uv(0, 21).cuboid(-1.0F, -18.0F, 2.0F, 1.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 10.0F, 0.0F));

        ModelPartData ribs = vertebra.addChild("ribs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rib2 = ribs.addChild("rib2", ModelPartBuilder.create().uv(6, 35).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(6, 36).cuboid(-2.0F, -1.0F, -3.8F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -16.0F, 4.0F));

        ModelPartData cube_r47 = rib2.addChild("cube_r47", ModelPartBuilder.create().uv(24, 38).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.3F, 0.0F, -3.1F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r48 = rib2.addChild("cube_r48", ModelPartBuilder.create().uv(12, 36).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.4F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData rib = ribs.addChild("rib", ModelPartBuilder.create().uv(34, 19).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(24, 20).cuboid(-2.0F, -1.0F, -3.8F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -14.0F, 4.0F));

        ModelPartData cube_r49 = rib.addChild("cube_r49", ModelPartBuilder.create().uv(38, 10).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.3F, 0.0F, -3.1F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r50 = rib.addChild("cube_r50", ModelPartBuilder.create().uv(12, 35).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.4F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData rib3 = ribs.addChild("rib3", ModelPartBuilder.create().uv(36, 20).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(38, 2).cuboid(-2.0F, -1.0F, -3.8F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -15.0F, 4.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r51 = rib3.addChild("cube_r51", ModelPartBuilder.create().uv(38, 12).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.3F, 0.0F, -3.1F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r52 = rib3.addChild("cube_r52", ModelPartBuilder.create().uv(38, 1).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.4F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData rib4 = ribs.addChild("rib4", ModelPartBuilder.create().uv(36, 21).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(36, 37).cuboid(-2.0F, -1.0F, -3.8F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -17.0F, 4.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r53 = rib4.addChild("cube_r53", ModelPartBuilder.create().uv(38, 13).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.3F, 0.0F, -3.1F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r54 = rib4.addChild("cube_r54", ModelPartBuilder.create().uv(38, 3).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.4F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData vertebra3 = spine.addChild("vertebra3", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, -1.0F, 1.3F));

        ModelPartData cube_r55 = vertebra3.addChild("cube_r55", ModelPartBuilder.create().uv(12, 21).cuboid(-0.5F, -2.5F, -1.0F, 1.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData ribs3 = vertebra3.addChild("ribs3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rib9 = ribs3.addChild("rib9", ModelPartBuilder.create(), ModelTransform.of(-1.5F, -1.0F, 1.8F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r56 = rib9.addChild("cube_r56", ModelPartBuilder.create().uv(38, 7).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.0F, -2.8F, -1.5708F, 0.7854F, -1.5708F));

        ModelPartData cube_r57 = rib9.addChild("cube_r57", ModelPartBuilder.create().uv(38, 8).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.3F, -2.1F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r58 = rib9.addChild("cube_r58", ModelPartBuilder.create().uv(0, 38).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.1F, -0.7F, -0.7854F, 0.0F, 0.0F));

        ModelPartData rib10 = ribs3.addChild("rib10", ModelPartBuilder.create(), ModelTransform.of(1.5F, 0.3F, 1.0F, 1.309F, 0.0F, 3.1416F));

        ModelPartData cube_r59 = rib10.addChild("cube_r59", ModelPartBuilder.create().uv(10, 38).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.0F, -2.8F, -1.5708F, 0.7854F, -1.5708F));

        ModelPartData cube_r60 = rib10.addChild("cube_r60", ModelPartBuilder.create().uv(38, 9).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.3F, -2.1F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r61 = rib10.addChild("cube_r61", ModelPartBuilder.create().uv(38, 0).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.1F, -0.7F, -0.7854F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F,30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }


    @Override
    public void setAngles(CabbaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(CabbaAnimations.CABBA_WALK_ANIMATION, limbSwing, limbSwingAmount, 2.0f, 1.0f);
        this.updateAnimation(entity.idleAnimationState, CabbaAnimations.CABBA_HELLO_ANIMATION, ageInTicks, 1f);
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
