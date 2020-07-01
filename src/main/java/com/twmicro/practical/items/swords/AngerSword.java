package com.twmicro.practical.items.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class AngerSword extends SwordItem {

    private static final IItemTier AngerSwordTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 600;
        }

        @Override
        public float getEfficiency() {
            return 5;
        }

        @Override
        public float getAttackDamage() {
            return 0;
        }

        @Override
        public int getHarvestLevel() {
            return 1;
        }

        @Override
        public int getEnchantability() {
            return 320;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromStacks(new ItemStack(Items.NETHER_STAR));
        }
    };
    public AngerSword() {
        super(AngerSwordTier, 20, 0.6F, new Properties().group(ItemGroup.COMBAT));
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(2, attacker, (p_220045_0_) -> {
            p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        attacker.addPotionEffect(new EffectInstance(Effects.REGENERATION, 50, 2));
        attacker.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 120));
        attacker.addPotionEffect(new EffectInstance(Effects.STRENGTH, 120, 2));
        attacker.addPotionEffect(new EffectInstance(Effects.SPEED, 200, 3));
        return true;
    }
}
