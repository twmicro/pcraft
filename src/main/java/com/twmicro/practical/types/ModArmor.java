package com.twmicro.practical.types;

import com.twmicro.practical.utils.classes.RegistryList;
import com.twmicro.practical.utils.enums.ModArmorMaterials;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;

public class ModArmor extends RegistryList<Item> {
    public static final Item EMERALD_BOOTS = new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, EquipmentSlotType.FEET,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item EMERALD_LEGGINGS = new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item EMERALD_CHESTPLATE = new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item EMERALD_HELMET = new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item RUBY_BOOTS = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlotType.FEET,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item RUBY_LEGGINGS = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item RUBY_CHESTPLATE = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item RUBY_HELMET = new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
            new Item.Properties().group(ItemGroup.COMBAT));


    public static final Item NETHER_BOOTS = new ArmorItem(ModArmorMaterials.NETHER_ARMOR_MATERIAL, EquipmentSlotType.FEET,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item NETHER_LEGGINGS = new ArmorItem(ModArmorMaterials.NETHER_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item NETHER_CHESTPLATE = new ArmorItem(ModArmorMaterials.NETHER_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item NETHER_HELMET = new ArmorItem(ModArmorMaterials.NETHER_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item LAVA_BOOTS = new ArmorItem(ModArmorMaterials.LAVA_ARMOR_MATERIAL, EquipmentSlotType.FEET,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item LAVA_LEGGINGS = new ArmorItem(ModArmorMaterials.LAVA_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item LAVA_CHESTPLATE = new ArmorItem(ModArmorMaterials.LAVA_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item LAVA_HELMET = new ArmorItem(ModArmorMaterials.LAVA_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item STAR_BOOTS = new ArmorItem(ModArmorMaterials.STAR_ARMOR_MATERIAL, EquipmentSlotType.FEET,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item STAR_LEGGINGS = new ArmorItem(ModArmorMaterials.STAR_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item STAR_CHESTPLATE = new ArmorItem(ModArmorMaterials.STAR_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item STAR_HELMET = new ArmorItem(ModArmorMaterials.STAR_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
            new Item.Properties().group(ItemGroup.COMBAT).func_234689_a_());

    public static final Item ENDER_BOOTS = new ArmorItem(ModArmorMaterials.ENDER_ARMOR_MATERIAL, EquipmentSlotType.FEET,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item ENDER_LEGGINGS = new ArmorItem(ModArmorMaterials.ENDER_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item ENDER_CHESTPLATE = new ArmorItem(ModArmorMaterials.ENDER_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item ENDER_HELMET = new ArmorItem(ModArmorMaterials.ENDER_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
            new Item.Properties().group(ItemGroup.COMBAT));

    public ModArmor()
    {
        add(RUBY_HELMET, "ruby_helmet");
        add(RUBY_CHESTPLATE, "ruby_chestplate");
        add(RUBY_LEGGINGS, "ruby_leggings");
        add(RUBY_BOOTS, "ruby_boots");
        add(EMERALD_HELMET, "emerald_helmet");
        add(EMERALD_CHESTPLATE, "emerald_chestplate");
        add(EMERALD_LEGGINGS, "emerald_leggings");
        add(EMERALD_BOOTS, "emerald_boots");
        add(NETHER_HELMET, "nether_helmet");
        add(NETHER_CHESTPLATE, "nether_chestplate");
        add(NETHER_LEGGINGS, "nether_leggings");
        add(NETHER_BOOTS, "nether_boots");
        add(LAVA_HELMET, "lava_helmet");
        add(LAVA_CHESTPLATE, "lava_chestplate");
        add(LAVA_LEGGINGS, "lava_leggings");
        add(LAVA_BOOTS, "lava_boots");
        add(STAR_HELMET, "star_helmet");
        add(STAR_CHESTPLATE, "star_chestplate");
        add(STAR_LEGGINGS, "star_leggings");
        add(STAR_BOOTS, "star_boots");
        add(ENDER_HELMET, "ender_helmet");
        add(ENDER_CHESTPLATE, "ender_chestplate");
        add(ENDER_LEGGINGS, "ender_leggings");
        add(ENDER_BOOTS, "ender_boots");
    }
}
