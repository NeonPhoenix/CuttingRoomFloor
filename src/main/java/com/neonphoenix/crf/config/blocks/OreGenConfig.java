package com.neonphoenix.crf.config.blocks;

import net.minecraftforge.common.ForgeConfigSpec;

public abstract class OreGenConfig
{
    public static ForgeConfigSpec.BooleanValue enableGoldOre;
    public static ForgeConfigSpec.BooleanValue enableMossOre;

    public static ForgeConfigSpec.IntValue oreGoldChance;
    public static ForgeConfigSpec.IntValue oreGoldCount;
    public static ForgeConfigSpec.IntValue oreGoldBottomOffset;
    public static ForgeConfigSpec.IntValue oreGoldTopOffset;
    public static ForgeConfigSpec.IntValue oreGoldMaximum;

    public static ForgeConfigSpec.IntValue oreMossChance;
    public static ForgeConfigSpec.IntValue oreMossCount;
    public static ForgeConfigSpec.IntValue oreMossBottomOffset;
    public static ForgeConfigSpec.IntValue oreMossTopOffset;
    public static ForgeConfigSpec.IntValue oreMossMaximum;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
    {
        generateGoldOre(server, client);
        server.comment("---------------------------------------------------------------------------------------------");
        generateMossOre(server, client);
    }

    public static void generateGoldOre(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
    {
        server.comment("Gold Nether Ore Config");

        enableGoldOre = server.comment("Do you want this ore to generate in the Nether dimension.").define("oregen.enableGoldOre", true);
        oreGoldCount = server.comment("Total number of blocks generated per vein.").defineInRange("oregen.oreGoldCount", 6, 1, 20);
        oreGoldChance = server.comment("Maximum number of ore veins of the Nether Gold Ore that can spawn in a chunk.").defineInRange("oregen.oreGoldChance", 10, 1, 200);
        oreGoldBottomOffset = server.comment("Lowest point in world which ore will generate.").defineInRange("oregen.oreGoldBottomOffset", 10, 5, 30);
        oreGoldTopOffset = server.comment("How far from maximum will ore generate from.").defineInRange("oregen.oreGoldTopOffset", 1, 1, 128);
        oreGoldMaximum = server.comment("Highest point in the dimension this ore will generate.").defineInRange("oregen.oreGoldMaximum", 100, 50, 128);
    }

    public static void generateMossOre(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
    {
        server.comment("Moss Nether Ore Config");

        enableMossOre = server.comment("Do you want this ore to generate in the Nether dimension.").define("oregen.enableMossOre", true);
        oreMossCount = server.comment("Total number of blocks generated per vein.").defineInRange("oregen.oreMossCount", 6, 1, 20);
        oreMossChance = server.comment("Maximum number of ore veins of the Nether Gold Ore that can spawn in a chunk.").defineInRange("oregen.oreMossChance", 10, 1, 200);
        oreMossBottomOffset = server.comment("Lowest point in world which ore will generate.").defineInRange("oregen.oreMossBottomOffset", 10, 5, 30);
        oreMossTopOffset = server.comment("How far from maximum will ore generate from.").defineInRange("oregen.oreMossTopOffset", 1, 1, 128);
        oreMossMaximum = server.comment("Highest point in the dimension this ore will generate.").defineInRange("oregen.oreMossMaximum", 100, 50, 128);
    }
}
