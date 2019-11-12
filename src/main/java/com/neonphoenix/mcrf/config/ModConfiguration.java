package com.neonphoenix.mcrf.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.neonphoenix.mcrf.MinecraftCuttingRoomFloor;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class ModConfiguration
{
    private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec server_config;

    private static final ForgeConfigSpec.Builder client_builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec client_config;

    static
    {
        OreGenerationConfig.init(server_builder, client_builder);

        server_config = server_builder.build();
        client_config = client_builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path)
    {
        MinecraftCuttingRoomFloor.log.info("Loading config: " + path);

        final CommentedFileConfig configData = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        MinecraftCuttingRoomFloor.log.info("Built config: " + path);

        configData.load();
        MinecraftCuttingRoomFloor.log.info("Loaded config: " + path);

        config.setConfig(configData);
    }
}
