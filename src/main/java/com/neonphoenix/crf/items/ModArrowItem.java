package com.neonphoenix.crf.items;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
        int enchant = EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == ModArrowItem.class;
    }
}
