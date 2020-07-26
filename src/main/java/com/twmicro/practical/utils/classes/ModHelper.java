package com.twmicro.practical.utils.classes;

import com.twmicro.practical.utils.enums.ModArmorMaterials;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class ModHelper {
    public static boolean hasLavaArmor(LivingEntity entity)
    {
        ItemStack HEAD = entity.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack CHEST = entity.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack LEGS = entity.getItemStackFromSlot(EquipmentSlotType.LEGS);
        ItemStack FEET = entity.getItemStackFromSlot(EquipmentSlotType.FEET);


        if (HEAD.getItem() instanceof ArmorItem) {
            boolean headResult = ((ArmorItem) (HEAD.getItem())).getArmorMaterial() == ModArmorMaterials.LAVA_ARMOR_MATERIAL;
            if (headResult) return true;
        }

        if (CHEST.getItem() instanceof ArmorItem) {
            boolean chestResult = ((ArmorItem) CHEST.getItem()).getArmorMaterial() == ModArmorMaterials.LAVA_ARMOR_MATERIAL;
            if (chestResult) return true;
        }

        if (LEGS.getItem() instanceof ArmorItem) {
           boolean legsResult = ((ArmorItem) (LEGS.getItem())).getArmorMaterial() == ModArmorMaterials.LAVA_ARMOR_MATERIAL;
           if(legsResult) return true;
        }

        if (FEET.getItem() instanceof ArmorItem) {
            return ((ArmorItem) (FEET.getItem())).getArmorMaterial() == ModArmorMaterials.LAVA_ARMOR_MATERIAL;
        }

        return false;
    }

    public static boolean hasStarArmor(LivingEntity entity)
    {
        ItemStack HEAD = entity.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack CHEST = entity.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack LEGS = entity.getItemStackFromSlot(EquipmentSlotType.LEGS);
        ItemStack FEET = entity.getItemStackFromSlot(EquipmentSlotType.FEET);


        if (HEAD.getItem() instanceof ArmorItem) {
            boolean headResult = ((ArmorItem) (HEAD.getItem())).getArmorMaterial() == ModArmorMaterials.STAR_ARMOR_MATERIAL;
            if (headResult) return true;
        }

        if (CHEST.getItem() instanceof ArmorItem) {
            boolean chestResult = ((ArmorItem) CHEST.getItem()).getArmorMaterial() == ModArmorMaterials.STAR_ARMOR_MATERIAL;
            if (chestResult) return true;
        }

        if (LEGS.getItem() instanceof ArmorItem) {
            boolean legsResult = ((ArmorItem) (LEGS.getItem())).getArmorMaterial() == ModArmorMaterials.STAR_ARMOR_MATERIAL;
            if(legsResult) return true;
        }

        if (FEET.getItem() instanceof ArmorItem) {
            return ((ArmorItem) (FEET.getItem())).getArmorMaterial() == ModArmorMaterials.STAR_ARMOR_MATERIAL;
        }

        return false;
    }

    public static boolean hasEnderArmor(LivingEntity entity)
    {
        ItemStack HEAD = entity.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack CHEST = entity.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack LEGS = entity.getItemStackFromSlot(EquipmentSlotType.LEGS);
        ItemStack FEET = entity.getItemStackFromSlot(EquipmentSlotType.FEET);


        if (HEAD.getItem() instanceof ArmorItem) {
            boolean headResult = ((ArmorItem) (HEAD.getItem())).getArmorMaterial() == ModArmorMaterials.ENDER_ARMOR_MATERIAL;
            if (headResult) return true;
        }

        if (CHEST.getItem() instanceof ArmorItem) {
            boolean chestResult = ((ArmorItem) CHEST.getItem()).getArmorMaterial() == ModArmorMaterials.ENDER_ARMOR_MATERIAL;
            if (chestResult) return true;
        }

        if (LEGS.getItem() instanceof ArmorItem) {
            boolean legsResult = ((ArmorItem) (LEGS.getItem())).getArmorMaterial() == ModArmorMaterials.ENDER_ARMOR_MATERIAL;
            if(legsResult) return true;
        }

        if (FEET.getItem() instanceof ArmorItem) {
            return ((ArmorItem) (FEET.getItem())).getArmorMaterial() == ModArmorMaterials.ENDER_ARMOR_MATERIAL;
        }

        return false;
    }
}
