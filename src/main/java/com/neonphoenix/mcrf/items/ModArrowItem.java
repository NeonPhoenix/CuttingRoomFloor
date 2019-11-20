package com.neonphoenix.mcrf.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

import java.util.function.BiFunction;

public class ModArrowItem extends ArrowItem
{
    private final BiFunction<World, LivingEntity, ArrowEntity> entityFactory;

    public ModArrowItem(final BiFunction<World, LivingEntity, ArrowEntity> entityFactory, final Item.Properties properties)
    {
        super(properties);
        this.entityFactory = entityFactory;
    }

    @Override
    public AbstractArrowEntity createArrow(final World worldIn, final ItemStack stack, final LivingEntity shooter)
    {
        final ArrowEntity entityModArrow = entityFactory.apply(worldIn, shooter);
        entityModArrow.setPotionEffect(stack);
        return entityModArrow;
    }

    @Override
    public boolean isInfinite(final ItemStack stack, final ItemStack bow, final PlayerEntity player)
    {
        return true;
    }
}
