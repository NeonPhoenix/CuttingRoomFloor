package com.neonphoenix.mcrf.init;

import com.neonphoenix.mcrf.MinecraftCuttingRoomFloor;
import com.neonphoenix.mcrf.entities.ExplodingArrowEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModdedEntities
{
    public static final EntityType<ExplodingArrowEntity> EXPLODING_ARROW = null;

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
    {
        final EntityType<ExplodingArrowEntity> explodingArrow = build("exploding_arrow", EntityType.Builder.<ExplodingArrowEntity>create(ExplodingArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f));

        event.getRegistry().registerAll(
                explodingArrow
        );
    }

    private static <T extends Entity> EntityType<T> build(final String name, final EntityType.Builder<T> builder)
    {
        final ResourceLocation registryName = new ResourceLocation(MinecraftCuttingRoomFloor.modid, name);
        final EntityType<T> entityType = builder.build(registryName.toString());

        entityType.setRegistryName(registryName);

        return entityType;
    }
}
