package com.neonphoenix.mcrf;

import com.neonphoenix.mcrf.config.ModConfiguration;
import com.neonphoenix.mcrf.util.MCRFItemGroup;
import com.neonphoenix.mcrf.world.gen.OreGeneration;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mcrf")
public class MinecraftCuttingRoomFloor
{
    public static final String modid = "mcrf";

    public static final ItemGroup mcrfCreativeTab = new MCRFItemGroup();

    public static final Logger log = LogManager.getLogger(modid);

    public MinecraftCuttingRoomFloor()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ModConfiguration.server_config);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModConfiguration.client_config);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        ModConfiguration.loadConfig(ModConfiguration.client_config, FMLPaths.CONFIGDIR.get().resolve("mcrf-client.toml").toString());
        ModConfiguration.loadConfig(ModConfiguration.server_config, FMLPaths.CONFIGDIR.get().resolve("mcrf-server.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent commonSetupEvent)
    {
        OreGeneration.init();

        log.info("Setup method registered.");
    }

    private void clientRegistries(final FMLClientSetupEvent clientSetupEvent)
    {
        log.info("Client registries method registered.");
    }
}



