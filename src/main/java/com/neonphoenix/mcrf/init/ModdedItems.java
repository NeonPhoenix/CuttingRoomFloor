package com.neonphoenix.mcrf.init;

import com.neonphoenix.mcrf.MinecraftCuttingRoomFloor;
import com.neonphoenix.mcrf.entities.ExplodingArrowEntity;
import com.neonphoenix.mcrf.items.ModArrowItem;
import com.neonphoenix.mcrf.materials.ArmorMaterials;
import com.neonphoenix.mcrf.materials.ToolMaterials;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

import static com.neonphoenix.mcrf.lists.MCRFItems.*;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModdedItems
{
    public static final ItemGroup creativeTab = MinecraftCuttingRoomFloor.mcrfCreativeTab;
    public static final Logger log = MinecraftCuttingRoomFloor.log;
    public static final String modid = MinecraftCuttingRoomFloor.modid;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        //Ingots etc.
        STEEL_NUGGET = registerItem(new Item(new Item.Properties().group(creativeTab)), location("steel_nugget"));
        STEEL_INGOT = registerItem(new Item(new Item.Properties().group(creativeTab)), location("steel_ingot"));

        //Tools
        STEEL_AXE = registerItem(new AxeItem(ToolMaterials.STEEL, -1.0f, 6.0f, new Item.Properties().group(creativeTab)), location("steel_axe"));
        STEEL_HOE = registerItem(new HoeItem(ToolMaterials.STEEL, 0.0f, new Item.Properties().group(creativeTab)), location("steel_hoe"));
        STEEL_PICKAXE = registerItem(new PickaxeItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(creativeTab)), location("steel_pickaxe"));
        STEEL_SHOVEL = registerItem(new ShovelItem(ToolMaterials.STEEL, 0.0f, 0.0f, new Item.Properties().group(creativeTab)), location("steel_shovel"));
        STEEL_SWORD = registerItem(new SwordItem(ToolMaterials.STEEL, 0, 0.0f, new Item.Properties().group(creativeTab)), location("steel_sword"));

        //Armor
        STEEL_HELMET = registerItem(new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(creativeTab)), location("steel_helmet"));
        STEEL_CHESTPLATE = registerItem(new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(creativeTab)), location("steel_chestplate"));
        STEEL_LEGGINGS = registerItem(new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(creativeTab)), location("steel_leggings"));
        STEEL_BOOTS = registerItem(new ArmorItem(ArmorMaterials.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(creativeTab)), location("steel_boots"));

        //Misc Items
        RED_MOSS = registerItem(new Item(new Item.Properties().group(creativeTab)), location("red_moss"));

        //Arrows
        EXPLODING_ARROW = registerItem(new ModArrowItem(ExplodingArrowEntity::new, new Item.Properties().group(creativeTab)), location("exploding_arrow"));

        log.info("Items registered.");
    }

    public static Item registerItem(Item item, ResourceLocation name)
    {
        item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

    public static ModArrowItem registerItem(ModArrowItem item, ResourceLocation name)
    {
        item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(modid, name);
    }
}
