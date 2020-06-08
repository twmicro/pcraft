package com.twmicro.practical.entities.renderers;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.entities.HookArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class HookArrowRenderer extends ArrowRenderer<HookArrowEntity> {

    public HookArrowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(HookArrowEntity entity) {
        return new ResourceLocation(PracticalMod.MODID + ":textures/entities/hook_arrow.png");
    }
}
