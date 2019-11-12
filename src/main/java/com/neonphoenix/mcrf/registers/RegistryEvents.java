package com.neonphoenix.mcrf.registers;

import com.neonphoenix.mcrf.MinecraftCuttingRoomFloor;
import com.neonphoenix.mcrf.lists.BlockList;
import com.neonphoenix.mcrf.lists.ItemList;
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
                        ItemList.steel_nugget = new Item(new Item.Properties().group(creativeTab)).setRegistryName(location("steel_nugget")),
                        ItemList.steel_ingot = new Item(new Item.Properties().group(creativeTab)).setRegistryName(location("steel_ingot")),
                        ItemList.steel_block = new BlockItem(BlockList.steel_block, new Item.Properties().group(creativeTab)).setRegistryName(BlockList.steel_block.getRegistryName()),

                        ItemList.steel_axe = new AxeItem(ToolMaterials.STEEL, -1.0f, 6.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_axe")),
                        ItemList.steel_hoe = new HoeItem(ToolMaterials.STEEL, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_hoe")),
                        ItemList.steel_pickaxe = new PickaxeItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_pickaxe")),
                        ItemList.steel_shovel = new ShovelItem(ToolMaterials.STEEL, 0.0f, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_shovel")),
                        ItemList.steel_sword = new SwordItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_sword")),

                        ItemList.steel_helmet = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_helmet")),
                        ItemList.steel_chestplate = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_chestplate")),
                        ItemList.steel_leggings = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_leggings")),
                        ItemList.steel_boots = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_boots")),

                        ItemList.nether_gold_ore = new BlockItem(BlockList.nether_gold_ore, new Item.Properties().group(creativeTab)).setRegistryName(BlockList.nether_gold_ore.getRegistryName())
                );

        log.info("Items registered.");
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll
                (
                        BlockList.steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.METAL)).setRegistryName(location("steel_block")),

                        BlockList.nether_gold_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)).setRegistryName(location("nether_gold_ore"))
                );

        log.info("Items registered.");
    }

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(modid, name);
    }
}
