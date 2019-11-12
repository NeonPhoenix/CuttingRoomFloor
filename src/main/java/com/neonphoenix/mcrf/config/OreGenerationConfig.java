package com.neonphoenix.mcrf.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenerationConfig
{
    public static ForgeConfigSpec.BooleanValue generateNetherOre;

    public static ForgeConfigSpec.IntValue oreChance;
    public static ForgeConfigSpec.IntValue oreCount;
    public static ForgeConfigSpec.IntValue oreBottomOffset;
    public static ForgeConfigSpec.IntValue oreTopOffset;
    public static ForgeConfigSpec.IntValue oreMaximum;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
    {
        server.comment("Oregen Config");

        generateNetherOre = server
                .comment("Do you want this ore to generate in the Nether dimension.")
                .define("oregen.generateNetherOre", true);

        oreChance = server
                .comment("Maximum number of ore veins of the Nether Gold Ore that can spawn in a chunk.")
                .defineInRange("oregen.oreChance", 10, 1, 200);

        oreCount = server
                .comment("Maximum number of blocks per vein.")
                .defineInRange("oregen.oreCount", 3, 1, 10);

        oreBottomOffset = server
                .comment("Lowest point in world which ore will generate.")
                .defineInRange("oregen.oreBottomOffset", 10, 5, 30);

        oreMaximum = server
                .comment("Highest point in the dimension this ore will generate.")
                .defineInRange("oregen.oreMaximum", 100, 100, 256);

        oreTopOffset = server
                .comment("How far from maximum will ore generate from.")
                .defineInRange("oregen.oreTopOffset", 1, 1, 256);
    }
}
