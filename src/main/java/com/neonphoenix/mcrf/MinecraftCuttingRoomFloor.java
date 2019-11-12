package com.neonphoenix.mcrf;

import com.neonphoenix.mcrf.lists.*;
import com.neonphoenix.mcrf.materials.ArmorMaterials;
import com.neonphoenix.mcrf.materials.ToolMaterials;
import com.neonphoenix.mcrf.util.*;

import com.neonphoenix.mcrf.world.OreGeneration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.*;

@Mod("mcrf")
public class MinecraftCuttingRoomFloor
{
    public static MinecraftCuttingRoomFloor instance;
    public static final String modid = "mcrf";

    public static final ItemGroup mcrfCreativeTab = new MCRFItemGroup();

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
        OreGeneration.setupOreGeneration();

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
                        ItemList.steel_ingot = new Item(new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_ingot")),

                        ItemList.steel_axe = new AxeItem(ToolMaterials.STEEL, -1.0f, 6.0f, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_axe")),
                        ItemList.steel_hoe = new HoeItem(ToolMaterials.STEEL, 0.0f, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_hoe")),
                        ItemList.steel_pickaxe = new PickaxeItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_pickaxe")),
                        ItemList.steel_shovel = new ShovelItem(ToolMaterials.STEEL, 0.0f, 0.0f, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_shovel")),
                        ItemList.steel_sword = new SwordItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_sword")),

                        ItemList.steel_helmet = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_helmet")),
                        ItemList.steel_chestplate = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_chestplate")),
                        ItemList.steel_leggings = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_leggings")),
                        ItemList.steel_boots = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(location("steel_boots")),

                        ItemList.nether_gold_ore = new BlockItem(BlockList.nether_gold_ore, new Item.Properties().group(mcrfCreativeTab)).setRegistryName(BlockList.nether_gold_ore.getRegistryName())
                    );

            log.info("Items registered.");
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll
                    (
                        BlockList.nether_gold_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("nether_gold_ore"))
                    );

            log.info("Items registered.");
        }

        private static ResourceLocation location(String name)
        {
            return new ResourceLocation(modid, name);
        }
    }
}



