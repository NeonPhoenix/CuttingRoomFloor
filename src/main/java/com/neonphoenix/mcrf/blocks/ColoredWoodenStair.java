package com.neonphoenix.mcrf.blocks;

import com.neonphoenix.mcrf.objectholders.ColoredWoodenStairs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.stream.Stream;

public class ColoredWoodenStair extends Block
{
    public ColoredWoodenStair(Material mat, DyeColor dyeColor)
    {
        super(Properties.create(mat, dyeColor).hardnessAndResistance(1.8F));
    }

    public static Stream<Block> allBlocks()
    {
        return Stream.of(
                ColoredWoodenStairs.WHITE,
                ColoredWoodenStairs.ORANGE,
                ColoredWoodenStairs.MAGENTA,
                ColoredWoodenStairs.LIGHT_BLUE,
                ColoredWoodenStairs.YELLOW,
                ColoredWoodenStairs.LIME,
                ColoredWoodenStairs.PINK,
                ColoredWoodenStairs.GRAY,
                ColoredWoodenStairs.LIGHT_GRAY,
                ColoredWoodenStairs.CYAN,
                ColoredWoodenStairs.PURPLE,
                ColoredWoodenStairs.BLUE,
                ColoredWoodenStairs.BROWN,
                ColoredWoodenStairs.GREEN,
                ColoredWoodenStairs.RED,
                ColoredWoodenStairs.BLACK
        );
    }
}
