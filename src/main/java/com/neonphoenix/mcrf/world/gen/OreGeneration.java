package com.neonphoenix.mcrf.world.gen;

import com.neonphoenix.mcrf.config.blocks.OreGenConfig;
import com.neonphoenix.mcrf.lists.MCRFBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class OreGeneration
{
    public static void init()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            genNetherGoldOre(biome);
            genNetherMossOre(biome);
        }
    }

    private static void genNetherGoldOre(Biome biome)
    {
        if(OreGenConfig.enableGoldOre.get())
        {
            biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                    Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, MCRFBlocks.NETHER_GOLD_ORE.getDefaultState(), OreGenConfig.oreGoldChance.get()), Placement.COUNT_RANGE,
                    new CountRangeConfig(OreGenConfig.oreGoldCount.get(), OreGenConfig.oreGoldBottomOffset.get(), OreGenConfig.oreGoldTopOffset.get(), OreGenConfig.oreGoldMaximum.get())));
        }
    }

    private static void genNetherMossOre(Biome biome)
    {
        if(OreGenConfig.enableMossOre.get())
        {
            biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                    Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, MCRFBlocks.RED_MOSS_ORE.getDefaultState(), OreGenConfig.oreMossChance.get()), Placement.COUNT_RANGE,
                    new CountRangeConfig(OreGenConfig.oreMossCount.get(), OreGenConfig.oreMossBottomOffset.get(), OreGenConfig.oreMossTopOffset.get(), OreGenConfig.oreMossMaximum.get())));
        }

    }
}
