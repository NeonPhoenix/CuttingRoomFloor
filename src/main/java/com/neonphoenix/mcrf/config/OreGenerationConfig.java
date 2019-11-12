package com.neonphoenix.mcrf.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenerationConfig
{
    public static ForgeConfigSpec.IntValue oreChance;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
    {
        server.comment("Oregen Config");

        oreChance = server
                .comment("Maximum number of ore veins of the Nether Gold Ore that can spawn in a chunk.")
                .defineInRange("oregen.oreChance", 100, 1, 200);

    }
}
