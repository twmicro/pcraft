package com.twmicro.practical.setup;

import com.twmicro.practical.entities.TNTTank;
import com.twmicro.practical.types.*;
import com.twmicro.practical.types.not_deferred.ModTrades;
import com.twmicro.practical.utils.classes.ModHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

public class Events {
    public int tick = -1;
    @SubscribeEvent
    public void onTradesSetup(VillagerTradesEvent event) {
        ModTrades modTrades = new ModTrades();
        modTrades.addEvent(event);
        modTrades.register();
    }

    public void initialSpawn(FMLLoadCompleteEvent event) {
        GlobalEntityTypeAttributes.put(ModEntities.TNT_TANK, TNTTank.func_234237_fg_().func_233813_a_());
    }

    public void setup(final FMLCommonSetupEvent event)
    {
        //OreGenerator.setup();
    }

    @SubscribeEvent
    public void tick(LivingEvent.LivingUpdateEvent e)
    {
            LivingEntity entity = e.getEntityLiving();
            if (ModHelper.hasLavaArmor(entity)) {
                entity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 50, 2));
            }
            if (ModHelper.hasStarArmor(entity)) {
                entity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 50, 2));
                entity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 50, 2));
                entity.addPotionEffect(new EffectInstance(Effects.SPEED, 50, 2));
                entity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 50, 2));
                entity.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 50, 3));
                entity.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 50, 3));
            }
            if (ModHelper.hasEnderArmor(entity)) {
                entity.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 50, 2));
                entity.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 50, 2));
                entity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 50, 2));
            }

    }
}
