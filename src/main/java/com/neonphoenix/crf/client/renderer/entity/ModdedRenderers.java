package com.neonphoenix.crf.client.renderer.entity;

import com.neonphoenix.crf.CuttingRoomFloor;
import com.neonphoenix.crf.entities.ExplodingArrowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public abstract class ModdedRenderers
{
    public static void register()
    {
        RenderingRegistry.registerEntityRenderingHandler(ExplodingArrowEntity.class, renderManager -> new RenderModArrow(renderManager, new ResourceLocation(CuttingRoomFloor.modid, "textures/entity/exploding_arrow.png")));
    }
}
