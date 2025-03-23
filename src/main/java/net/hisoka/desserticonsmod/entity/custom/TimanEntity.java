package net.hisoka.desserticonsmod.entity.custom;


import net.hisoka.desserticonsmod.item.ModItems;
import net.hisoka.desserticonsmod.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class TimanEntity extends PathAwareEntity {

    public TimanEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public void tick() {
        super.tick();
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);

        // Выпадение предметов при смерти сущности
        if (!this.getWorld().isClient) {
            dropItems();
        }
    }

    private void dropItems() {
        this.dropItem(new ItemStack(ModItems.DESSERTICOIN, 1).getItem());
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.TIMAN_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.TIMAN_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return ModSounds.TIMAN_HURT;}

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new PowderSnowJumpGoal(this, this.getWorld()));
        this.goalSelector.add(1, new TimanEntity.EscapeDangerGoal(this, 2.2));
        this.goalSelector.add(4, new TimanEntity.FleeGoal(this, PlayerEntity.class, 8.0F, 2.2, 2.2));
        this.goalSelector.add(4, new TimanEntity.FleeGoal(this, WolfEntity.class, 10.0F, 2.2, 2.2));
        this.goalSelector.add(4, new TimanEntity.FleeGoal(this, HostileEntity.class, 4.0F, 2.2, 2.2));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.6));
        this.goalSelector.add(11, new LookAtEntityGoal(this, PlayerEntity.class, 10.0F));
    }

    public static DefaultAttributeContainer.Builder createTimanAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F);
    }

    static class EscapeDangerGoal extends net.minecraft.entity.ai.goal.EscapeDangerGoal {
        private final TimanEntity timan;

        public EscapeDangerGoal(TimanEntity timan, double speed) {
            super(timan, speed);
            this.timan = timan;
        }
    }
    static class FleeGoal<T extends LivingEntity> extends FleeEntityGoal<T> {
        private final TimanEntity timan;
        public FleeGoal(TimanEntity timan, Class<T> fleeFromType, float distance, double slowSpeed, double fastSpeed) {
            super(timan, fleeFromType, distance, slowSpeed, fastSpeed);
            this.timan = timan;
        }
    }
}
