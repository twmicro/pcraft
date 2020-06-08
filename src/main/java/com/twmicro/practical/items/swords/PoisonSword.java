package com.twmicro.practical.items.swords;

import com.twmicro.practical.PracticalMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.*;
import net.minecraft.util.ActionResultType;

public class PoisonSword extends SwordItem {
    private static final IItemTier PoisonSwordTier = new IItemTier() {
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
            return Ingredient.fromStacks(new ItemStack(Items.ROTTEN_FLESH));
        }
    };

    public PoisonSword() {
        super(PoisonSwordTier, 7, 1, new Properties().group(ItemGroup.COMBAT));
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(2, attacker, (p_220045_0_) -> {
            p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        target.addPotionEffect(new EffectInstance(Effects.WITHER, 120));
        target.addPotionEffect(new EffectInstance(Effects.POISON, 120));
        return true;
    }
}
