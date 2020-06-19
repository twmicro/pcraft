package com.twmicro.practical.entities.renderers;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.entities.LightningArrow;
import com.twmicro.practical.entities.TNTArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class TNTArrowRenderer extends ArrowRenderer<TNTArrow> {
    public TNTArrowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(TNTArrow entity) {
        return new ResourceLocation(PracticalMod.MODID + ":textures/entities/tnt_arrow.png");
    }
}
