package com.neonphoenix.mcrf.materials;

import com.neonphoenix.mcrf.lists.ItemList;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterials implements IItemTier
{
    STEEL(3, 1125, 5.5f, 2.5f, 12, ItemList.steel_ingot);

    private float attackDamage, efficiency;
    private int duriability, harvestLevel, enchantability;
    private Item repairMaterial;

    ToolMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, int enchantability, Item repairMaterial)
    {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.duriability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public float getAttackDamage() { return this.attackDamage; }

    @Override
    public float getEfficiency() { return this.efficiency; }

    @Override
    public int getMaxUses() { return this.duriability; }

    @Override
    public int getEnchantability() { return this.enchantability; }

    @Override
    public int getHarvestLevel() { return this.harvestLevel; }

    @Override
    public Ingredient getRepairMaterial() { return Ingredient.fromItems(this.repairMaterial); }
}
