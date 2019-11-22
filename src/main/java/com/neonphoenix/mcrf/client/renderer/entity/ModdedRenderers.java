package com.neonphoenix.mcrf.client.renderer.entity;

import com.neonphoenix.mcrf.MinecraftCuttingRoomFloor;
import com.neonphoenix.mcrf.entities.ExplodingArrowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public abstract class ModdedRenderers
{
    public static void register()
    {
        RenderingRegistry.registerEntityRenderingHandler(ExplodingArrowEntity.class, renderManager -> new RenderModArrow(renderManager, new ResourceLocation(MinecraftCuttingRoomFloor.modid, "textures/entity/exploding_arrow.png")));
    }
}
