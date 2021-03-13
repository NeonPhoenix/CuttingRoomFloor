package com.neonphoenix.crf.util;

import com.neonphoenix.crf.lists.CRFBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CRFItemGroup extends ItemGroup
{
    public CRFItemGroup()
    {
        super("crf");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(Item.BLOCK_TO_ITEM.get(CRFBlocks.NETHER_GOLD_ORE));
    }
}
