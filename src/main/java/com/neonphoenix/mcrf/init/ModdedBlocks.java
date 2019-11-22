package com.neonphoenix.mcrf.init;

import com.neonphoenix.mcrf.MinecraftCuttingRoomFloor;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

import static com.neonphoenix.mcrf.lists.MCRFBlocks.*;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModdedBlocks
{
    public static final ItemGroup creativeTab = MinecraftCuttingRoomFloor.mcrfCreativeTab;
    public static final Logger log = MinecraftCuttingRoomFloor.log;
    public static final String modid = MinecraftCuttingRoomFloor.modid;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent<Block> event)
    {
        //Organic


        //Metal blocks
        STEEL_BLOCK = registerBlock(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.METAL)), location("steel_block"));

        //Building blocks
        RED_MOSSY_COBBLESTONE = registerBlock(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_cobblestone"));
        RED_MOSSY_STONEBRICK = registerBlock(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_stonebrick"));

        //Ore
        NETHER_GOLD_ORE = registerBlock(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)), location("nether_gold_ore"));
        RED_MOSS_ORE = registerBlock(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)), location("red_moss_ore"));

        log.info("Blocks registered.");
    }

    public static Block registerBlock(Block block, ResourceLocation name)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(creativeTab));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);

        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);

        return block;
    }

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(modid, name);
    }
}
