package net.hisoka.desserticonsmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class YuraEntity extends PathAwareEntity {

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;




    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.updateAnimations();
        }
    }



    private void updateAnimations() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 180;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
    }



    public YuraEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }



    public static DefaultAttributeContainer.Builder createYuraAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6);
    }
}
