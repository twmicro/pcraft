package com.twmicro.practical.types;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import com.twmicro.practical.utils.enums.ModArmorMaterials;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModArmor implements IRegistryList<Item> {
    private static final ImmutableMap.Builder<Item, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static DeferredRegister<Item> DEFERRED_REGISTER = null;

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
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item NETHER_LEGGINGS = new ArmorItem(ModArmorMaterials.NETHER_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item NETHER_CHESTPLATE = new ArmorItem(ModArmorMaterials.NETHER_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
            new Item.Properties().group(ItemGroup.COMBAT));

    public static final Item NETHER_HELMET = new ArmorItem(ModArmorMaterials.NETHER_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
            new Item.Properties().group(ItemGroup.COMBAT));
    private static void add(Item item, String name)
    {
        REGISTRY_MAP.put(item, name);
    }

    static
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
    }

    @Override
    public void setDeferredRegister(DeferredRegister<?> register) {
        DEFERRED_REGISTER = (DeferredRegister<Item>) register;
    }

    @Override
    public Map<Item, String> getRegistryNames() {
        return REGISTRY_MAP.build();
    }

    @Override
    public void register() {
        Map<Item, String> MAP = getRegistryNames();
        MAP.forEach((item, name) -> DEFERRED_REGISTER.register(name, () -> item));
    }
}
