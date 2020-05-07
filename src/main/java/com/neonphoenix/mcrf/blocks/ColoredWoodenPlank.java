package com.neonphoenix.mcrf.blocks;

import com.neonphoenix.mcrf.objectholders.ColoredWoodenPlanks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;

import java.util.stream.Stream;

public class ColoredWoodenPlank extends Block
{
    public ColoredWoodenPlank(Material mat, DyeColor dyeColor)
    {
        super(Block.Properties.create(mat, dyeColor).hardnessAndResistance(1.8F));
    }

    public static Stream<Block> allBlocks()
    {
        return Stream.of(
                ColoredWoodenPlanks.WHITE,
                ColoredWoodenPlanks.ORANGE,
                ColoredWoodenPlanks.MAGENTA,
                ColoredWoodenPlanks.LIGHT_BLUE,
                ColoredWoodenPlanks.YELLOW,
                ColoredWoodenPlanks.LIME,
                ColoredWoodenPlanks.PINK,
                ColoredWoodenPlanks.GRAY,
                ColoredWoodenPlanks.LIGHT_GRAY,
                ColoredWoodenPlanks.CYAN,
                ColoredWoodenPlanks.PURPLE,
                ColoredWoodenPlanks.BLUE,
                ColoredWoodenPlanks.BROWN,
                ColoredWoodenPlanks.GREEN,
                ColoredWoodenPlanks.RED,
                ColoredWoodenPlanks.BLACK
        );
    }
}
