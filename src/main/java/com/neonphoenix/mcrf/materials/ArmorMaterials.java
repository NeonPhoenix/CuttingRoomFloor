package com.neonphoenix.mcrf.materials;

import com.neonphoenix.mcrf.MinecraftCuttingRoomFloor;
import com.neonphoenix.mcrf.lists.MCRFItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterials implements IArmorMaterial
{
    STEEL("steel", 25, new int[] {2, 5, 6, 2}, 9, "item.armor.equip_iron", 1.0f, MCRFItems.STEEL_INGOT);

    private static final int[] max_damage_array = new int[] {13, 15, 16, 11};

    private String name, equipSound;
    private int durability, enchantability;
    private int[] damageReductionAmount;
    private float toughness;
    private Item repairMaterial;

    ArmorMaterials(String name, int durability, int[] damageReductionAmount, int enchantability, String equipSound, float toughness, Item repairMaterial)
    {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
        this.equipSound = equipSound;
        this.toughness = toughness;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot)
    {
        return this.damageReductionAmount[slot.getIndex()];
    }

    @Override
    public int getDurability(EquipmentSlotType slot)
    {
        return max_damage_array[slot.getIndex()] * this.durability;
    }

    @Override
    public int getEnchantability()
    {
        return this.enchantability;
    }

    @Override
    public String getName()
    {
        return MinecraftCuttingRoomFloor.modid + ":" + this.name;
    }

    @Override
    public Ingredient getRepairMaterial()
    {
        return Ingredient.fromItems(this.repairMaterial);
    }

    @Override
    public SoundEvent getSoundEvent()
    {
        return new SoundEvent(new ResourceLocation(equipSound));
    }

    @Override
    public float getToughness()
    {
        return this.toughness;
    }
}
