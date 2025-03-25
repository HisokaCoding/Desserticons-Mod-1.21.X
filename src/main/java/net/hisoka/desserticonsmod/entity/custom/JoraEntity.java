package net.hisoka.desserticonsmod.entity.custom;

import net.hisoka.desserticonsmod.item.ModItems;
import net.hisoka.desserticonsmod.sound.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class JoraEntity extends PathAwareEntity implements Monster, Angerable {
    private int angerTime;
    private UUID targetUuid;


    public JoraEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }



    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            tickAngerLogic((ServerWorld) this.getWorld(), true);
        }
    }



    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (!this.getWorld().isClient) {
            dropItems();
        }
    }
    private void dropItems() {
        this.dropItem(new ItemStack(ModItems.DESSERTICOIN, 1).getItem());
        this.dropItem(new ItemStack(ModItems.DESSERTICOIN, 1).getItem());
        this.dropItem(new ItemStack(ModItems.DESSERTICOIN, 1).getItem());
        this.dropItem(new ItemStack(ModItems.HOOKAH, 1).getItem());
    }
    @Override
    protected int getXpToDrop() {
        return 500 + this.getWorld().random.nextInt(3);
    }



    protected SoundEvent getAmbientSound() {
        if (Random.create().nextInt(2) == 0) {
            return ModSounds.JORA_AMBIENT;
        }
        return null;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.JORA_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return ModSounds.JORA_HURT;}



    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(2, new SwimGoal(this));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.6));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 10.0F));

        this.targetSelector.add(1, new RevengeGoal(this)); // Теперь атакует всех, кто его бьет
        this.targetSelector.add(2, new UniversalAngerGoal<>(this, false)); // Теперь сам становится агрессивным
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, true)); // Постоянная агрессия на игроков
    }



    @Override
    public boolean damage(DamageSource source, float amount) {
        boolean result = super.damage(source, amount);
        if (!this.getWorld().isClient) {
            Entity attacker = source.getAttacker();
            if (attacker instanceof LivingEntity) {
                this.setTarget((LivingEntity) attacker);
            }
        }
        return result;
    }
    @Override
    public boolean tryAttack(Entity target) {
        if (target instanceof LivingEntity) {
            return target.damage(this.getDamageSources().generic(), 5.0F);
        }
        return false;
    }



    public static DefaultAttributeContainer.Builder createJoraAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 300.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6);
    }


    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    @Override
    public void setAngerTime(int ticks) {
        this.angerTime = ticks;
    }

    @Override
    public @Nullable UUID getAngryAt() {
        return this.targetUuid;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.targetUuid = uuid;
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(400 + this.getWorld().random.nextInt(400)); // Рандомная агрессия на 20-40 секунд
    }
}
