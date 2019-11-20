package com.neonphoenix.mcrf.registry;

import com.neonphoenix.mcrf.MinecraftCuttingRoomFloor;
import com.neonphoenix.mcrf.entities.ExplodingArrowEntity;
import com.neonphoenix.mcrf.items.ModArrowItem;
import com.neonphoenix.mcrf.lists.ModdedBlocks;
import com.neonphoenix.mcrf.lists.ModdedItems;
import com.neonphoenix.mcrf.materials.ArmorMaterials;
import com.neonphoenix.mcrf.materials.ToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents
{
    public static final ItemGroup creativeTab = MinecraftCuttingRoomFloor.mcrfCreativeTab;
    public static final Logger log = MinecraftCuttingRoomFloor.log;
    public static final String modid = MinecraftCuttingRoomFloor.modid;
    
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll
                (
                        ModdedItems.STEEL_NUGGET = new Item(new Item.Properties().group(creativeTab)).setRegistryName(location("steel_nugget")),
                        ModdedItems.STEEL_INGOT = new Item(new Item.Properties().group(creativeTab)).setRegistryName(location("steel_ingot")),

                        ModdedItems.STEEL_AXE = new AxeItem(ToolMaterials.STEEL, -1.0f, 6.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_axe")),
                        ModdedItems.STEEL_HOE = new HoeItem(ToolMaterials.STEEL, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_hoe")),
                        ModdedItems.STEEL_PICKAXE = new PickaxeItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_pickaxe")),
                        ModdedItems.STEEL_SHOVEL = new ShovelItem(ToolMaterials.STEEL, 0.0f, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_shovel")),
                        ModdedItems.STEEL_SWORD = new SwordItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_sword")),

                        ModdedItems.STEEL_HELMET = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_helmet")),
                        ModdedItems.STEEL_CHESTPLATE = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_chestplate")),
                        ModdedItems.STEEL_LEGGINGS = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_leggings")),
                        ModdedItems.STEEL_BOOTS = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_boots")),

                        ModdedItems.EXPLODING_ARROW = (ModArrowItem) new ModArrowItem(ExplodingArrowEntity::new, defaultItemProperties()).setRegistryName("exploding_arrow"),

                        ModdedItems.STEEL_BLOCK = new BlockItem(ModdedBlocks.STEEL_BLOCK, new Item.Properties().group(creativeTab)).setRegistryName(ModdedBlocks.STEEL_BLOCK.getRegistryName()),
                        ModdedItems.RED_MOSSY_COBBLESTONE = new BlockItem(ModdedBlocks.RED_MOSSY_COBBLESTONE, new Item.Properties().group(creativeTab)).setRegistryName(ModdedBlocks.RED_MOSSY_COBBLESTONE.getRegistryName()),
                        ModdedItems.RED_MOSSY_STONEBRICK = new BlockItem(ModdedBlocks.RED_MOSSY_STONEBRICK, new Item.Properties().group(creativeTab)).setRegistryName(ModdedBlocks.RED_MOSSY_STONEBRICK.getRegistryName()),
                        ModdedItems.NETHER_GOLD_ORE = new BlockItem(ModdedBlocks.NETHER_GOLD_ORE, new Item.Properties().group(creativeTab)).setRegistryName(ModdedBlocks.NETHER_GOLD_ORE.getRegistryName())
                );

        log.info("Items registered.");
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll
                (
                        ModdedBlocks.STEEL_BLOCK = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.METAL)).setRegistryName(location("steel_block")),
                        ModdedBlocks.RED_MOSSY_COBBLESTONE = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)).setRegistryName(location("red_mossy_cobblestone")),
                        ModdedBlocks.RED_MOSSY_STONEBRICK = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)).setRegistryName(location("red_mossy_stone_bricks")),
                        ModdedBlocks.NETHER_GOLD_ORE = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)).setRegistryName(location("nether_gold_ore"))
                );

        log.info("Blocks registered.");
    }

    private static Item.Properties defaultItemProperties()
    {
        return new Item.Properties().group(creativeTab);
    }

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(modid, name);
    }
}
