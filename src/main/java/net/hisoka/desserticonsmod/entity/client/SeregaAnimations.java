package net.hisoka.desserticonsmod.entity.client;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class SeregaAnimations {

    public static final Animation SEREGA_WALK_ANIMATION = Animation.Builder.create(0.5f).looping()
            .addBoneAnimation("leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(-40f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(27.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(27.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(27.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(27.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("arm",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -2f, -3f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, -2f, -3f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("arm",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(65f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(85f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(65f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("arm2",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -1f, -3f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, -1f, -3f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("arm2",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(65f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(85f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(65f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("ball",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(2f, -27f, -10f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createTranslationalVector(2f, -15f, -10f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(2f, -27f, -10f),
                                    Transformation.Interpolations.LINEAR))).build();
}
