package com.twmicro.practical.items.food;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class GodApple extends Item {
    public GodApple()
    {
        super(new Item.Properties().group(ItemGroup.FOOD).food(
                (new Food.Builder()).
                        saturation(1F).
                        effect(() -> new EffectInstance(Effects.REGENERATION, 1000, 2), 1F).
                        effect(() -> new EffectInstance(Effects.STRENGTH, 1000, 4), 1F).
                        effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 1000, 255), 1F).
                        effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 1000, 20), 1F).
                        effect(() -> new EffectInstance(Effects.SPEED, 1000, 3), 1F).
                        effect(() -> new EffectInstance(Effects.JUMP_BOOST, 1000, 3), 1F).
                        build()));
    }
}
