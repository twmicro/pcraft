package com.twmicro.practical.utils.enums;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.types.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterials implements IArmorMaterial {
    RUBY_ARMOR_MATERIAL(PracticalMod.MODID + ":ruby_armor_material", 7, new int[] { 7, 9, 11, 7 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 100F, () -> {
        return Ingredient.fromItems(ModItems.RUBY_INGOT);
    }),
    EMERALD_ARMOR_MATERIAL(PracticalMod.MODID + ":emerald_armor_material", 2, new int[] { 7, 9, 11, 7 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 10F, () -> {
        return Ingredient.fromItems(Items.EMERALD);
    }),
    NETHER_ARMOR_MATERIAL(PracticalMod.MODID + ":nether_armor_material", 15, new int[] { 15, 18, 20, 15 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 250F, () -> {
        return Ingredient.fromItems(ModItems.NETHER_INGOT);
    });
    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;

    private ModArmorMaterials(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
                              int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
                              Supplier<Ingredient> repairMaterialIn) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = soundEventIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return 0;
    }
}
