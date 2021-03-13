package com.neonphoenix.crf.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.neonphoenix.crf.CuttingRoomFloor;
import com.neonphoenix.crf.config.blocks.OreGenConfig;
import com.neonphoenix.crf.config.items.ExplodingArrowConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public abstract class ModConfiguration
{
    private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec server_config;

    private static final ForgeConfigSpec.Builder client_builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec client_config;

    static
    {
        OreGenConfig.init(server_builder, client_builder);
        ExplodingArrowConfig.init(server_builder, client_builder);

        server_config = server_builder.build();
        client_config = client_builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path)
    {
        CuttingRoomFloor.log.info("Loading config: " + path);

        final CommentedFileConfig configData = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        CuttingRoomFloor.log.info("Built config: " + path);

        configData.load();
        CuttingRoomFloor.log.info("Loaded config: " + path);

        config.setConfig(configData);
    }
}
