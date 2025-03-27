package net.hisoka.desserticonsmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class ZHelmetItem extends ArmorItem {
    public ZHelmetItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {
            if (livingEntity.getEquippedStack(this.getSlotType()).getItem() == this) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20, 1, false, false));
            } else {
                livingEntity.removeStatusEffect(StatusEffects.NIGHT_VISION);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
