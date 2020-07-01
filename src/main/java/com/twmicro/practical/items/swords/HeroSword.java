package com.twmicro.practical.items.swords;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.raid.RaidManager;

public class HeroSword extends SwordItem {
    private static final IItemTier HeroSwordTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 2000;
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
            return Ingredient.fromStacks(new ItemStack(new RubyIngot()));
        }
    };
    public HeroSword()
    {
        super(HeroSwordTier, 7, 5, new Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean isRaider = false;
        if((target instanceof PillagerEntity) || (target instanceof RavagerEntity) || (target instanceof WitchEntity) ||(target instanceof EvokerEntity) || (target instanceof VindicatorEntity)){ isRaider = true;}
        stack.damageItem(2, attacker, (p_220045_0_) -> {
            p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        if(isRaider) target.addPotionEffect(new EffectInstance(Effects.WITHER, 120, 3));
        return true;
    }
}
