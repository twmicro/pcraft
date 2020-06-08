package com.twmicro.practical.entities.renderers;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.entities.LightningArrow;
import com.twmicro.practical.entities.TeleportingArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class TeleportingArrowRenderer extends ArrowRenderer<TeleportingArrow> {
    public TeleportingArrowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(TeleportingArrow entity) {
        return new ResourceLocation(PracticalMod.MODID + ":textures/entities/teleporting_arrow.png");
    }
}
