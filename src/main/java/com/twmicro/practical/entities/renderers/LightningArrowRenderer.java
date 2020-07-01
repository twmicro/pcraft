package com.twmicro.practical.entities.renderers;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.entities.LightningArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class LightningArrowRenderer extends ArrowRenderer<LightningArrow> {

    public LightningArrowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(LightningArrow entity) {
        return new ResourceLocation(PracticalMod.MODID + ":textures/entities/lightning_arrow.png");
    }
}