package com.neonphoenix.mcrf;

import com.neonphoenix.mcrf.config.ModConfiguration;
import com.neonphoenix.mcrf.util.*;

import com.neonphoenix.mcrf.world.gen.OreGeneration;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.*;

@Mod("mcrf")
public class MinecraftCuttingRoomFloor
{
    public static MinecraftCuttingRoomFloor instance;
    public static final String modid = "mcrf";

    public static final ItemGroup mcrfCreativeTab = new MCRFItemGroup();

    public static final Logger log = LogManager.getLogger(modid);

    public MinecraftCuttingRoomFloor()
    {
        instance = this;

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ModConfiguration.server_config);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModConfiguration.client_config);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        ModConfiguration.loadConfig(ModConfiguration.client_config, FMLPaths.CONFIGDIR.get().resolve("mcrf-client.toml").toString());
        ModConfiguration.loadConfig(ModConfiguration.server_config, FMLPaths.CONFIGDIR.get().resolve("mcrf-server.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        OreGeneration.setupOreGeneration();

        log.info("Setup method registered.");
    }

    private void clientRegistries(final FMLClientSetupEvent event)
    {
        //ModdedBlocks.init(event);
        log.info("Client registries method registered.");
    }
}



