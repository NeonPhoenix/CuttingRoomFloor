package com.neonphoenix.mcrf.world;

import com.neonphoenix.mcrf.config.blocks.OreGenerationConfig;
import com.neonphoenix.mcrf.lists.ModdedBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration
{
    public static void setupOreGeneration()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            CountRangeConfig mcrf_ore_placement = new CountRangeConfig(OreGenerationConfig.oreChance.get(), OreGenerationConfig.oreBottomOffset.get(), OreGenerationConfig.oreTopOffset.get(), OreGenerationConfig.oreMaximum.get());

            if(OreGenerationConfig.generateNetherOre.get())
            {
                    biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModdedBlocks.NETHER_GOLD_ORE.getDefaultState(), OreGenerationConfig.oreChance.get()), Placement.COUNT_RANGE, mcrf_ore_placement));
            }
        }
    }
}
