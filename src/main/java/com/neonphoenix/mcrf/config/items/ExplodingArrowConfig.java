package com.neonphoenix.mcrf.config.items;

import net.minecraftforge.common.ForgeConfigSpec;

public abstract class ExplodingArrowConfig
{
    public static ForgeConfigSpec.BooleanValue destroyBlocks;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
    {
        server.comment("Exploding Arrow Config");

        destroyBlocks = server
                .comment("Do you want exploding arrows to destroy blocks.")
                .define("explodingarrow.destroyBlocks", true);
    }
}
