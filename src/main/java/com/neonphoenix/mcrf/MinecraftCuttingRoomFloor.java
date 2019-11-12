package com.neonphoenix.mcrf;

import com.neonphoenix.mcrf.lists.BlockList;
import com.neonphoenix.mcrf.lists.ItemList;
import com.neonphoenix.mcrf.lists.ToolMaterialList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mcrf")
public class MinecraftCuttingRoomFloor
{
    public static MinecraftCuttingRoomFloor instance;
    public static final String modid = "mcrf";

    public static final ItemGroup mcrfTab = new MCRFItemGroup();

    private static final Logger log = LogManager.getLogger(modid);

    public MinecraftCuttingRoomFloor()
    {
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        log.info("Setup method registered.");
    }

    private void clientRegistries(final FMLClientSetupEvent event)
    {
        log.info("Client registries method registered.");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            event.getRegistry().registerAll
                    (
                        ItemList.steelIngot = new Item(new Item.Properties().group(mcrfTab)).setRegistryName(location("steel_ingot")),

                        ItemList.steelAxe = new AxeItem(ToolMaterialList.steel, -1.0f, 6.0f, new Item.Properties().group(mcrfTab)).setRegistryName(location("steel_axe")),

                        ItemList.steelHoe = new HoeItem(ToolMaterialList.steel, 0.0f, new Item.Properties().group(mcrfTab)).setRegistryName(location("steel_hoe")),

                        ItemList.steelPickaxe = new PickaxeItem(ToolMaterialList.steel, 0, 0.0f, new Item.Properties().group(mcrfTab)).setRegistryName(location("steel_hoe")),

                        ItemList.steelShovel = new ShovelItem(ToolMaterialList.steel, 0.0f, 0.0f, new Item.Properties().group(mcrfTab)).setRegistryName(location("steel_hoe")),

                        ItemList.steelSword = new SwordItem(ToolMaterialList.steel, 0, 0.0f, new Item.Properties().group(mcrfTab)).setRegistryName(location("steel_hoe")),

                        ItemList.netherGoldOre = new BlockItem(BlockList.netherGoldOre, new Item.Properties().group(mcrfTab)).setRegistryName(BlockList.netherGoldOre.getRegistryName())
                    );

            log.info("Items registered.");
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll
                    (
                        BlockList.netherGoldOre = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("nether_gold_ore"))
                    );

            log.info("Items registered.");
        }

        private static ResourceLocation location(String name)
        {
            return new ResourceLocation(modid, name);
        }
    }
}



