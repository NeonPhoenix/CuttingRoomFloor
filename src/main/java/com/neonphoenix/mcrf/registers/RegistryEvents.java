package com.neonphoenix.mcrf.registers;

import com.neonphoenix.mcrf.MinecraftCuttingRoomFloor;
import com.neonphoenix.mcrf.entities.ExplodingArrowEntity;
import com.neonphoenix.mcrf.items.ModArrowItem;
import com.neonphoenix.mcrf.lists.BlockList;
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
                        ModdedItems.steel_nugget = new Item(new Item.Properties().group(creativeTab)).setRegistryName(location("steel_nugget")),
                        ModdedItems.steel_ingot = new Item(new Item.Properties().group(creativeTab)).setRegistryName(location("steel_ingot")),

                        ModdedItems.steel_axe = new AxeItem(ToolMaterials.STEEL, -1.0f, 6.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_axe")),
                        ModdedItems.steel_hoe = new HoeItem(ToolMaterials.STEEL, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_hoe")),
                        ModdedItems.steel_pickaxe = new PickaxeItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_pickaxe")),
                        ModdedItems.steel_shovel = new ShovelItem(ToolMaterials.STEEL, 0.0f, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_shovel")),
                        ModdedItems.steel_sword = new SwordItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_sword")),

                        ModdedItems.steel_helmet = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_helmet")),
                        ModdedItems.steel_chestplate = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_chestplate")),
                        ModdedItems.steel_leggings = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_leggings")),
                        ModdedItems.steel_boots = new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(creativeTab)).setRegistryName(location("steel_boots")),

                        ModdedItems.EXPLODING_ARROW = (ModArrowItem) new ModArrowItem(ExplodingArrowEntity::new, defaultItemProperties()).setRegistryName("exploding_arrow"),

                        ModdedItems.steel_block = new BlockItem(BlockList.steel_block, new Item.Properties().group(creativeTab)).setRegistryName(BlockList.steel_block.getRegistryName()),
                        ModdedItems.red_mossy_cobblestone = new BlockItem(BlockList.red_mossy_cobblestone, new Item.Properties().group(creativeTab)).setRegistryName(BlockList.red_mossy_cobblestone.getRegistryName()),
                        ModdedItems.red_mossy_stone_bricks = new BlockItem(BlockList.red_mossy_stone_bricks, new Item.Properties().group(creativeTab)).setRegistryName(BlockList.red_mossy_stone_bricks.getRegistryName()),
                        ModdedItems.nether_gold_ore = new BlockItem(BlockList.nether_gold_ore, new Item.Properties().group(creativeTab)).setRegistryName(BlockList.nether_gold_ore.getRegistryName())
                );

        log.info("Items registered.");
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll
                (
                        BlockList.steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.METAL)).setRegistryName(location("steel_block")),
                        BlockList.red_mossy_cobblestone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)).setRegistryName(location("red_mossy_cobblestone")),
                        BlockList.red_mossy_stone_bricks = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)).setRegistryName(location("red_mossy_stone_bricks")),
                        BlockList.nether_gold_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)).setRegistryName(location("nether_gold_ore"))
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
