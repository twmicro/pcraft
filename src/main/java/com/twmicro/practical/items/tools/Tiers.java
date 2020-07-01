package com.twmicro.practical.items.tools;

import com.twmicro.practical.types.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public enum Tiers {
    RUBY_AXE(TierClass.RUBY, 25),
    RUBY_HOE(TierClass.RUBY, 4),
    RUBY_PICKAXE(TierClass.RUBY, 12),
    RUBY_SHOVEL(TierClass.RUBY, 7),
    EMERALD_AXE(TierClass.EMERALD, 9),
    EMERALD_HOE(TierClass.EMERALD, 4),
    EMERALD_PICKAXE(TierClass.EMERALD, 5),
    EMERALD_SHOVEL(TierClass.EMERALD, 2),
    NETHER_AXE(TierClass.NETHER, 35),
    NETHER_HOE(TierClass.NETHER, 9),
    NETHER_PICKAXE(TierClass.NETHER, 25),
    NETHER_SHOVEL(TierClass.NETHER, 7),
    RUBY_UNIVERSAL(5, 10000, 10, 25F, 20F, Ingredient.fromItems(ModItems.RUBY_INGOT), TierClass.RUBY),
    EMERALD_UNIVERSAL(10000, 3000, 10, 9F, 5F, Ingredient.fromItems(Items.EMERALD), TierClass.EMERALD),
    NETHER_UNIVERSAL(10, 32500, 10, 35F, 35F, Ingredient.fromItems(ModItems.NETHER_INGOT), TierClass.NETHER)
    ;
    public int enchantability;
    public int maxUses;
    public int harvestLevel;
    public float attackDamage;
    public float efficiency;
    public Ingredient repairMaterial;
    public IItemTier tier;
    public TierClass tierClass;

    Tiers(TierClass tierClass, int attackDamage)
    {
        switch(tierClass)
        {
            case RUBY:
                this.enchantability = 5;
                this.maxUses = 2500;
                this.harvestLevel = 10;
                this.efficiency = 20;
                this.attackDamage = attackDamage;
                this.tierClass = tierClass;
                this.repairMaterial = Ingredient.fromItems(ModItems.RUBY_INGOT);
                this.tier = generateTier(enchantability, maxUses, harvestLevel, attackDamage, efficiency, repairMaterial);
                break;
            case EMERALD:
                this.enchantability = 100;
                this.maxUses = 750;
                this.harvestLevel = 3;
                this.efficiency = 5;
                this.attackDamage = attackDamage;
                this.tierClass = tierClass;
                this.repairMaterial = Ingredient.fromItems(Items.EMERALD);
                this.tier = generateTier(enchantability, maxUses, harvestLevel, attackDamage, efficiency, repairMaterial);
                break;
        case NETHER:
                this.enchantability = 15;
                this.maxUses = 7500;
                this.harvestLevel = 10;
                this.efficiency = 35;
                this.attackDamage = attackDamage;
                this.tierClass = tierClass;
                this.repairMaterial = Ingredient.fromItems(ModItems.NETHER_INGOT);
                this.tier = generateTier(enchantability, maxUses, harvestLevel, attackDamage, efficiency, repairMaterial);
                break;
        case CUSTOM:
                if(tierClass == TierClass.CUSTOM)
                    throw new IllegalArgumentException("Only run this with ready-to-use tier classes!");
        }
    }

    Tiers(int enchantability, int maxUses, int harvestLevel, float attackDamage, float efficiency, Ingredient repairMaterial, TierClass tierClass)
    {
        this.enchantability = enchantability;
        this.maxUses = maxUses;
        this.harvestLevel = harvestLevel;
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.repairMaterial = repairMaterial;
        this.tierClass = tierClass;
        this.tier = generateTier(enchantability, maxUses, harvestLevel,attackDamage, efficiency, repairMaterial);
    }
    IItemTier generateTier(int enchantability, int maxUses, int harvestLevel, float attackDamage, float efficiency, Ingredient repairMaterial)
    {
        return new IItemTier() {
            @Override
            public int getMaxUses() {
                return maxUses;
            }

            @Override
            public float getEfficiency() {
                return efficiency;
            }

            @Override
            public float getAttackDamage() {
                return attackDamage;
            }

            @Override
            public int getHarvestLevel() {
                return harvestLevel;
            }

            @Override
            public int getEnchantability() {
                return enchantability;
            }

            @Override
            public Ingredient getRepairMaterial() {
                return repairMaterial;
            }
        };
    }
    public enum TierClass
    {
        RUBY,
        EMERALD,
        NETHER,
        CUSTOM
    }
}
