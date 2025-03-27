package net.hisoka.desserticonsmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ENERGYDRINK = new FoodComponent.Builder().nutrition(0).saturationModifier(0)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1500), 1).build();
    public static final FoodComponent PROTEIN = new FoodComponent.Builder().nutrition(10).saturationModifier(10).build();
}
