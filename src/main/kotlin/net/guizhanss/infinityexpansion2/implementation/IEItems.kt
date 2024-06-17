@file:Suppress("deprecation", "unused", "MemberVisibilityCanBePrivate")

package net.guizhanss.infinityexpansion2.implementation

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture
import net.guizhanss.infinityexpansion2.implementation.groups.IEItemGroups
import net.guizhanss.infinityexpansion2.implementation.items.gears.InfinityArmor
import net.guizhanss.infinityexpansion2.implementation.items.gears.InfinityBow
import net.guizhanss.infinityexpansion2.implementation.items.gears.InfinityTool
import net.guizhanss.infinityexpansion2.implementation.items.machines.CobblePress
import net.guizhanss.infinityexpansion2.implementation.items.machines.Decompressor
import net.guizhanss.infinityexpansion2.implementation.items.machines.DustExtractor
import net.guizhanss.infinityexpansion2.implementation.items.machines.ExtremeFreezer
import net.guizhanss.infinityexpansion2.implementation.items.machines.GeoQuarry
import net.guizhanss.infinityexpansion2.implementation.items.machines.InfinityWorkbench
import net.guizhanss.infinityexpansion2.implementation.items.machines.IngotFormer
import net.guizhanss.infinityexpansion2.implementation.items.machines.MaterialGenerator
import net.guizhanss.infinityexpansion2.implementation.items.machines.Quarry
import net.guizhanss.infinityexpansion2.implementation.items.machines.ResourceSynthesizer
import net.guizhanss.infinityexpansion2.implementation.items.machines.SingularityConstructor
import net.guizhanss.infinityexpansion2.implementation.items.machines.StoneworksFactory
import net.guizhanss.infinityexpansion2.implementation.items.machines.TreeGrower
import net.guizhanss.infinityexpansion2.implementation.items.machines.UraniumExtractor
import net.guizhanss.infinityexpansion2.implementation.items.machines.VirtualFarm
import net.guizhanss.infinityexpansion2.implementation.items.machines.VoidHarvester
import net.guizhanss.infinityexpansion2.implementation.items.materials.EnderEssence
import net.guizhanss.infinityexpansion2.implementation.items.materials.SimpleMaterial
import net.guizhanss.infinityexpansion2.implementation.items.materials.Singularity
import net.guizhanss.infinityexpansion2.implementation.items.materials.VoidBlock
import net.guizhanss.infinityexpansion2.implementation.items.materials.VoidGlass
import net.guizhanss.infinityexpansion2.implementation.items.sfextension.AutoDisenchanter
import net.guizhanss.infinityexpansion2.implementation.items.sfextension.AutoEnchanter
import net.guizhanss.infinityexpansion2.implementation.items.sfextension.Capacitor
import net.guizhanss.infinityexpansion2.implementation.items.sfextension.ChargingBench
import net.guizhanss.infinityexpansion2.implementation.items.sfextension.GeoMiner
import net.guizhanss.infinityexpansion2.implementation.items.sfextension.Smeltery
import net.guizhanss.infinityexpansion2.implementation.items.tools.Oscillator
import net.guizhanss.infinityexpansion2.implementation.items.tools.Strainer
import net.guizhanss.infinityexpansion2.implementation.items.tools.StrainerBase
import net.guizhanss.infinityexpansion2.implementation.recipes.IERecipeTypes
import net.guizhanss.infinityexpansion2.utils.buildHiddenPotionEffect
import net.guizhanss.infinityexpansion2.utils.emptyRecipe
import net.guizhanss.infinityexpansion2.utils.fillRecipe
import net.guizhanss.infinityexpansion2.utils.items.applyInfinityGearEnchantment
import net.guizhanss.infinityexpansion2.utils.items.buildSlimefunItem
import net.guizhanss.infinityexpansion2.utils.items.convert
import net.guizhanss.infinityexpansion2.utils.surroundedBy
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object IEItems {
    private val GLASS = ItemStack(Material.GLASS)
    private val COBBLESTONE = ItemStack(Material.COBBLESTONE)
    private val STICK = ItemStack(Material.STICK)
    private val STRING = ItemStack(Material.STRING)
    private val DIAMOND_PICKAXE = ItemStack(Material.DIAMOND_PICKAXE)
    private val WATER_BUCKET = ItemStack(Material.WATER_BUCKET)
    private val LAVA_BUCKET = ItemStack(Material.LAVA_BUCKET)
    private val GRASS_BLOCK = ItemStack(Material.GRASS_BLOCK)
    private val PODZOL = ItemStack(Material.PODZOL)

    // <editor-fold desc="Singularities" collapsed="true">
    val IRON_SINGULARITY = buildSlimefunItem<Singularity>(
        2000, mapOf(
            ItemStack(Material.IRON_INGOT) to 1,
            ItemStack(Material.IRON_BLOCK) to 9,
        )
    ) {
        id = "IRON_SINGULARITY"
        material = Material.IRON_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val GOLD_SINGULARITY = buildSlimefunItem<Singularity>(
        2000, mapOf(
            ItemStack(Material.GOLD_INGOT) to 1,
            ItemStack(Material.GOLD_BLOCK) to 9,
            SlimefunItems.GOLD_4K to 1,
            SlimefunItems.GOLD_6K to 2,
            SlimefunItems.GOLD_8K to 3,
            SlimefunItems.GOLD_10K to 4,
            SlimefunItems.GOLD_12K to 5,
            SlimefunItems.GOLD_14K to 6,
            SlimefunItems.GOLD_16K to 7,
            SlimefunItems.GOLD_18K to 8,
            SlimefunItems.GOLD_20K to 9,
            SlimefunItems.GOLD_22K to 10,
            SlimefunItems.GOLD_24K to 11,
            SlimefunItems.GOLD_24K_BLOCK to 99,
        )
    ) {
        id = "GOLD_SINGULARITY"
        material = Material.GOLD_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val LAPIS_SINGULARITY = buildSlimefunItem<Singularity>(
        1500, mapOf(
            ItemStack(Material.LAPIS_LAZULI) to 1,
            ItemStack(Material.LAPIS_BLOCK) to 9,
        )
    ) {
        id = "LAPIS_SINGULARITY"
        material = Material.LAPIS_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val REDSTONE_SINGULARITY = buildSlimefunItem<Singularity>(
        3000, mapOf(
            ItemStack(Material.REDSTONE) to 1,
            ItemStack(Material.REDSTONE_BLOCK) to 9,
        )
    ) {
        id = "REDSTONE_SINGULARITY"
        material = Material.REDSTONE_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val QUARTZ_SINGULARITY = buildSlimefunItem<Singularity>(
        3000, mapOf(
            ItemStack(Material.QUARTZ) to 1,
            ItemStack(Material.QUARTZ_BLOCK) to 4,
        )
    ) {
        id = "QUARTZ_SINGULARITY"
        material = Material.QUARTZ_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val COPPER_SINGULARITY = buildSlimefunItem<Singularity>(
        3000, mapOf(
            ItemStack(Material.COPPER_INGOT) to 1,
            ItemStack(Material.COPPER_BLOCK) to 9,
            SlimefunItems.COPPER_INGOT to 1,
        )
    ) {
        id = "COPPER_SINGULARITY"
        material = Material.COPPER_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val TIN_SINGULARITY = buildSlimefunItem<Singularity>(
        3000, mapOf(
            SlimefunItems.TIN_INGOT to 1,
        )
    ) {
        id = "TIN_SINGULARITY"
        material = Material.IRON_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val LEAD_SINGULARITY = buildSlimefunItem<Singularity>(
        3000, mapOf(
            SlimefunItems.LEAD_INGOT to 1,
        )
    ) {
        id = "LEAD_SINGULARITY"
        material = Material.IRON_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val SILVER_SINGULARITY = buildSlimefunItem<Singularity>(
        3000, mapOf(
            SlimefunItems.SILVER_INGOT to 1,
        )
    ) {
        id = "SILVER_SINGULARITY"
        material = Material.IRON_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val ZINC_SINGULARITY = buildSlimefunItem<Singularity>(
        3000, mapOf(
            SlimefunItems.ZINC_INGOT to 1,
        )
    ) {
        id = "ZINC_SINGULARITY"
        material = Material.IRON_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val ALUMINUM_SINGULARITY = buildSlimefunItem<Singularity>(
        3000, mapOf(
            SlimefunItems.ALUMINUM_INGOT to 1,
        )
    ) {
        id = "ALUMINUM_SINGULARITY"
        material = Material.IRON_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val MAGNESIUM_SINGULARITY = buildSlimefunItem<Singularity>(
        3000, mapOf(
            SlimefunItems.MAGNESIUM_INGOT to 1,
        )
    ) {
        id = "MAGNESIUM_SINGULARITY"
        material = Material.IRON_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val DIAMOND_SINGULARITY = buildSlimefunItem<Singularity>(
        500, mapOf(
            ItemStack(Material.DIAMOND) to 1,
            ItemStack(Material.DIAMOND_BLOCK) to 9,
            SlimefunItems.SYNTHETIC_DIAMOND to 1,
        )
    ) {
        id = "DIAMOND_SINGULARITY"
        material = Material.DIAMOND_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val EMERALD_SINGULARITY = buildSlimefunItem<Singularity>(
        500, mapOf(
            ItemStack(Material.EMERALD) to 1,
            ItemStack(Material.EMERALD_BLOCK) to 9,
            SlimefunItems.SYNTHETIC_EMERALD to 1,
        )
    ) {
        id = "EMERALD_SINGULARITY"
        material = Material.EMERALD_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val NETHERITE_SINGULARITY = buildSlimefunItem<Singularity>(
        200, mapOf(
            ItemStack(Material.NETHERITE_INGOT) to 1,
            ItemStack(Material.NETHERITE_BLOCK) to 9,
        )
    ) {
        id = "NETHERITE_SINGULARITY"
        material = Material.NETHERITE_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val COAL_SINGULARITY = buildSlimefunItem<Singularity>(
        1500, mapOf(
            ItemStack(Material.COAL) to 1,
            ItemStack(Material.COAL_BLOCK) to 9,
            SlimefunItems.CARBON to 8,
            SlimefunItems.COMPRESSED_CARBON to 32,
            SlimefunItems.CARBON_CHUNK to 256,
        )
    ) {
        id = "COAL_SINGULARITY"
        material = Material.COAL_BLOCK.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val FORTUNE_SINGULARITY = buildSlimefunItem<SimpleMaterial> {
        id = "FORTUNE_SINGULARITY"
        material = Material.NETHER_STAR.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            GOLD_SINGULARITY, DIAMOND_SINGULARITY, EMERALD_SINGULARITY,
            NETHERITE_SINGULARITY, ADAMANTITE,
        )
    }

    val MAGIC_SINGULARITY = buildSlimefunItem<SimpleMaterial> {
        id = "MAGIC_SINGULARITY"
        material = Material.NETHER_STAR.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            REDSTONE_SINGULARITY, LAPIS_SINGULARITY, QUARTZ_SINGULARITY,
            MAGNESIUM_SINGULARITY, MAGNONIUM,
        )
    }

    val EARTH_SINGULARITY = buildSlimefunItem<SimpleMaterial> {
        id = "EARTH_SINGULARITY"
        material = Material.NETHER_STAR.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            COMPRESSED_COBBLESTONE_4, COAL_SINGULARITY, IRON_SINGULARITY,
            COPPER_SINGULARITY, LEAD_SINGULARITY,
        )
    }

    val METAL_SINGULARITY = buildSlimefunItem<SimpleMaterial> {
        id = "METAL_SINGULARITY"
        material = Material.NETHER_STAR.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            SILVER_SINGULARITY, ALUMINUM_SINGULARITY, TIN_SINGULARITY,
            ZINC_SINGULARITY, TITANIUM,
        )
    }
    // </editor-fold>

    // <editor-fold desc="Materials" collapsed="true">
    val ENDER_ESSENCE = buildSlimefunItem<EnderEssence> {
        id = "ENDER_ESSENCE"
        material = Material.BLAZE_POWDER.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.GEO_MINER
    }

    val COMPRESSED_COBBLESTONE_1 = buildSlimefunItem<SimpleMaterial> {
        id = "COMPRESSED_COBBLESTONE_1"
        material = Material.ANDESITE.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = COBBLESTONE.fillRecipe()
    }

    val COMPRESSED_COBBLESTONE_2 = buildSlimefunItem<SimpleMaterial> {
        id = "COMPRESSED_COBBLESTONE_2"
        material = Material.ANDESITE.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = COMPRESSED_COBBLESTONE_1.fillRecipe()
    }

    val COMPRESSED_COBBLESTONE_3 = buildSlimefunItem<SimpleMaterial> {
        id = "COMPRESSED_COBBLESTONE_3"
        material = Material.ANDESITE.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = COMPRESSED_COBBLESTONE_2.fillRecipe()
    }

    val COMPRESSED_COBBLESTONE_4 = buildSlimefunItem<SimpleMaterial> {
        id = "COMPRESSED_COBBLESTONE_4"
        material = Material.STONE.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = COMPRESSED_COBBLESTONE_3.fillRecipe()
    }

    val COMPRESSED_COBBLESTONE_5 = buildSlimefunItem<SimpleMaterial> {
        id = "COMPRESSED_COBBLESTONE_5"
        material = Material.STONE.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = COMPRESSED_COBBLESTONE_4.fillRecipe()
    }

    val MAGSTEEL = buildSlimefunItem<SimpleMaterial> {
        id = "MAGSTEEL"
        material = Material.BRICK.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            SlimefunItems.MAGNESIUM_INGOT,
            SlimefunItems.STEEL_INGOT,
            SlimefunItems.MAGNESIUM_DUST,
        )
    }

    val TITANIUM = buildSlimefunItem<SimpleMaterial> {
        id = "TITANIUM"
        material = Material.IRON_INGOT.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            SlimefunItems.REINFORCED_ALLOY_INGOT,
            SlimefunItems.DAMASCUS_STEEL_INGOT,
            SlimefunItems.HARDENED_METAL_INGOT,
        )
    }

    val MYTHRIL = buildSlimefunItem<SimpleMaterial> {
        id = "MYTHRIL"
        material = Material.IRON_INGOT.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            SlimefunItems.MAGNESIUM_INGOT,
            IRON_SINGULARITY,
            SlimefunItems.MAGNESIUM_DUST,
        )
    }

    val ADAMANTITE = buildSlimefunItem<SimpleMaterial> {
        id = "ADAMANTITE"
        material = Material.BRICK.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            SlimefunItems.REDSTONE_ALLOY,
            DIAMOND_SINGULARITY,
            MAGSTEEL,
        )
    }

    val MAGNONIUM = buildSlimefunItem<SimpleMaterial> {
        id = "MAGNONIUM"
        material = Material.NETHER_BRICK.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            MAGSTEEL,
            MAGNESIUM_SINGULARITY,
            ENDER_ESSENCE,
        )
    }

    val VOID_BIT = buildSlimefunItem<SimpleMaterial> {
        id = "VOID_BIT"
        material = Material.IRON_NUGGET.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = IERecipeTypes.VOID_HARVESTER
    }

    val VOID_DUST = buildSlimefunItem<SimpleMaterial> {
        id = "VOID_DUST"
        material = Material.GUNPOWDER.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = VOID_BIT.fillRecipe()
    }

    val VOID_INGOT = buildSlimefunItem<SimpleMaterial> {
        id = "VOID_INGOT"
        material = Material.NETHERITE_INGOT.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = VOID_DUST.fillRecipe()
    }

    val VOID_BLOCK = buildSlimefunItem<VoidBlock> {
        id = "VOID_BLOCK"
        material = Material.NETHERITE_BLOCK.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = VOID_INGOT.fillRecipe()
    }

    val INFINITY_INGOT = buildSlimefunItem<SimpleMaterial> {
        id = "INFINITY_INGOT"
        material = Material.IRON_INGOT.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.SMELTERY
        recipe = arrayOf(
            EARTH_SINGULARITY,
            MYTHRIL,
            FORTUNE_SINGULARITY,
            MAGIC_SINGULARITY,
            VOID_INGOT,
            METAL_SINGULARITY,
        )
    }

    // Singularity put here due to load order
    val INFINITY_SINGULARITY = buildSlimefunItem<Singularity>(
        100, mapOf(
            INFINITY_INGOT to 1,
        )
    ) {
        id = "INFINITY_SINGULARITY"
        material = Material.SMOOTH_QUARTZ.convert()
        itemGroup = IEItemGroups.SINGULARITIES
        recipeType = IERecipeTypes.SINGULARITY_CONSTRUCTOR
    }

    val MAGSTEEL_PLATE = buildSlimefunItem<SimpleMaterial> {
        id = "MAGSTEEL_PLATE"
        material = Material.NETHERITE_SCRAP.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = SlimefunItems.HARDENED_METAL_INGOT surroundedBy MAGSTEEL
    }

    val MACHINE_CIRCUIT = buildSlimefunItem<SimpleMaterial> {
        id = "MACHINE_CIRCUIT"
        material = Material.GOLD_INGOT.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            SlimefunItems.COPPER_INGOT, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.COPPER_INGOT,
            SlimefunItems.COPPER_INGOT, SlimefunItems.SILICON, SlimefunItems.COPPER_INGOT,
            SlimefunItems.COPPER_INGOT, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.COPPER_INGOT,
        )
    }

    val MACHINE_PLATE = buildSlimefunItem<SimpleMaterial> {
        id = "MACHINE_PLATE"
        material = Material.PAPER.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_ALLOY_INGOT,
            MAGSTEEL_PLATE, TITANIUM, MAGSTEEL_PLATE,
            SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_ALLOY_INGOT,
        )
    }

    val MACHINE_CORE = buildSlimefunItem<SimpleMaterial> {
        id = "MACHINE_CORE"
        material = Material.IRON_BLOCK.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            TITANIUM, MACHINE_CIRCUIT, TITANIUM,
            MACHINE_CIRCUIT, MACHINE_PLATE, MACHINE_CIRCUIT,
            TITANIUM, MACHINE_CIRCUIT, TITANIUM,
        )
    }

    val VOID_GLASS = buildSlimefunItem<VoidGlass>(16) {
        id = "VOID_GLASS"
        material = Material.GLASS.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = VOID_BLOCK surroundedBy GLASS
    }

    val INFINITY_MACHINE_CIRCUIT = buildSlimefunItem<SimpleMaterial> {
        id = "INFINITY_MACHINE_CIRCUIT"
        material = Material.DIAMOND.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            MACHINE_CIRCUIT, INFINITY_INGOT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, INFINITY_INGOT, MACHINE_CIRCUIT,
            VOID_INGOT, MACHINE_CIRCUIT, VOID_INGOT, VOID_INGOT, MACHINE_CIRCUIT, VOID_INGOT,
            INFINITY_INGOT, VOID_INGOT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, VOID_INGOT, INFINITY_INGOT,
            INFINITY_INGOT, VOID_INGOT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, VOID_INGOT, INFINITY_INGOT,
            VOID_INGOT, MACHINE_CIRCUIT, VOID_INGOT, VOID_INGOT, MACHINE_CIRCUIT, VOID_INGOT,
            MACHINE_CIRCUIT, INFINITY_INGOT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, INFINITY_INGOT, MACHINE_CIRCUIT,
        )
    }

    val INFINITY_MACHINE_CORE = buildSlimefunItem<SimpleMaterial> {
        id = "INFINITY_MACHINE_CORE"
        material = Material.DIAMOND_BLOCK.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            MACHINE_PLATE, MACHINE_CORE, INFINITY_INGOT, INFINITY_INGOT, MACHINE_CORE, MACHINE_PLATE,
            MACHINE_CORE, MACHINE_PLATE, MACHINE_CIRCUIT, MACHINE_CIRCUIT, MACHINE_PLATE, MACHINE_CORE,
            INFINITY_INGOT, MACHINE_CIRCUIT, INFINITY_INGOT, INFINITY_INGOT, MACHINE_CIRCUIT, INFINITY_INGOT,
            INFINITY_INGOT, MACHINE_CIRCUIT, INFINITY_INGOT, INFINITY_INGOT, MACHINE_CIRCUIT, INFINITY_INGOT,
            MACHINE_CORE, MACHINE_PLATE, MACHINE_CIRCUIT, MACHINE_CIRCUIT, MACHINE_PLATE, MACHINE_CORE,
            MACHINE_PLATE, MACHINE_CORE, INFINITY_INGOT, INFINITY_INGOT, MACHINE_CORE, MACHINE_PLATE,
        )
    }

    val OSCILLATOR_FRAME = buildSlimefunItem<SimpleMaterial> {
        id = "OSCILLATOR_FRAME"
        material = Material.IRON_BARS.convert()
        itemGroup = IEItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MACHINE_PLATE, SlimefunItems.BLISTERING_INGOT_3, MACHINE_PLATE,
            SlimefunItems.BLISTERING_INGOT_3, null, SlimefunItems.BLISTERING_INGOT_3,
            MACHINE_PLATE, SlimefunItems.BLISTERING_INGOT_3, MACHINE_PLATE,
        )
    }
    // </editor-fold>

    // <editor-fold desc="Slimefun Expansion" collapsed="true">
    val VOID_CAPACITOR = buildSlimefunItem<Capacitor>(16_000_000) {
        id = "VOID_CAPACITOR"
        material = HeadTexture.CAPACITOR_25.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            VOID_INGOT,
            REDSTONE_SINGULARITY,
            VOID_INGOT,
            VOID_INGOT,
            SlimefunItems.ENERGIZED_CAPACITOR,
            VOID_INGOT,
            VOID_INGOT,
            REDSTONE_SINGULARITY,
            VOID_INGOT
        )
    }

    val INFINITY_CAPACITOR = buildSlimefunItem<Capacitor>(64_000_000) {
        id = "INFINITY_CAPACITOR"
        material = HeadTexture.CAPACITOR_25.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, INFINITY_INGOT, VOID_INGOT, VOID_INGOT, INFINITY_INGOT, null,
            null, INFINITY_INGOT, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CIRCUIT, INFINITY_INGOT, null,
            null, INFINITY_INGOT, SlimefunItems.ENERGIZED_CAPACITOR, SlimefunItems.ENERGIZED_CAPACITOR, INFINITY_INGOT, null,
            null, INFINITY_INGOT, SlimefunItems.ENERGIZED_CAPACITOR, SlimefunItems.ENERGIZED_CAPACITOR, INFINITY_INGOT, null,
            null, INFINITY_INGOT, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CIRCUIT, INFINITY_INGOT, null,
            null, INFINITY_INGOT, VOID_INGOT, VOID_INGOT, INFINITY_INGOT, null
            // @formatter:on
        )
    }

    val ADVANCED_ENCHANTER = buildSlimefunItem<AutoEnchanter>(5, 180) {
        id = "ADVANCED_ENCHANTER"
        material = Material.ENCHANTING_TABLE.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL,
            MAGSTEEL,
            MAGSTEEL,
            MAGSTEEL_PLATE,
            SlimefunItems.AUTO_ENCHANTER,
            MAGSTEEL_PLATE,
            MACHINE_CIRCUIT,
            MACHINE_CORE,
            MACHINE_CIRCUIT
        )
    }

    val INFINITY_ENCHANTER = buildSlimefunItem<AutoEnchanter>(75, 12_000) {
        id = "INFINITY_ENCHANTER"
        material = Material.ENCHANTING_TABLE.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, null, null, null, null, null,
            VOID_INGOT, null, null, null, null, VOID_INGOT,
            VOID_INGOT, VOID_INGOT, ADVANCED_ENCHANTER, ADVANCED_ENCHANTER, VOID_INGOT, VOID_INGOT,
            MACHINE_PLATE, VOID_INGOT, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CIRCUIT, VOID_INGOT, MACHINE_PLATE,
            MACHINE_PLATE, VOID_INGOT, INFINITY_MACHINE_CORE, INFINITY_MACHINE_CORE, VOID_INGOT, MACHINE_PLATE,
            MACHINE_PLATE, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, MACHINE_PLATE
            // @formatter:on
        )
    }

    val ADVANCED_DISENCHANTER = buildSlimefunItem<AutoDisenchanter>(5, 180) {
        id = "ADVANCED_DISENCHANTER"
        material = Material.ENCHANTING_TABLE.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL,
            MAGSTEEL,
            MAGSTEEL,
            MAGSTEEL_PLATE,
            SlimefunItems.AUTO_DISENCHANTER,
            MAGSTEEL_PLATE,
            MACHINE_CIRCUIT,
            MACHINE_CORE,
            MACHINE_CIRCUIT
        )
    }

    val INFINITY_DISENCHANTER = buildSlimefunItem<AutoDisenchanter>(90, 12_000) {
        id = "INFINITY_DISENCHANTER"
        material = Material.ENCHANTING_TABLE.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, null, null, null, null, null,
            VOID_INGOT, null, null, null, null, VOID_INGOT,
            VOID_INGOT, VOID_INGOT, ADVANCED_DISENCHANTER, ADVANCED_DISENCHANTER, VOID_INGOT, VOID_INGOT,
            MACHINE_PLATE, VOID_INGOT, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CIRCUIT, VOID_INGOT, MACHINE_PLATE,
            MACHINE_PLATE, VOID_INGOT, INFINITY_MACHINE_CORE, INFINITY_MACHINE_CORE, VOID_INGOT, MACHINE_PLATE,
            MACHINE_PLATE, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, MACHINE_PLATE
            // @formatter:on
        )
    }

    val ADVANCED_CHARGER = buildSlimefunItem<ChargingBench>(30, 180) {
        id = "ADVANCED_CHARGER"
        material = Material.HONEYCOMB_BLOCK.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL_PLATE, MACHINE_CIRCUIT, MAGSTEEL_PLATE,
            MACHINE_CIRCUIT, SlimefunItems.CHARGING_BENCH, MACHINE_CIRCUIT,
            MAGSTEEL_PLATE, MACHINE_CORE, MAGSTEEL_PLATE,
        )
    }

    val INFINITY_CHARGER = buildSlimefunItem<ChargingBench>(6000, 60_000) {
        id = "INFINITY_CHARGER"
        material = Material.SEA_LANTERN.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, null, null, null, null, null,
            VOID_INGOT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, VOID_INGOT,
            VOID_INGOT, MACHINE_CIRCUIT, ADVANCED_CHARGER, ADVANCED_CHARGER, MACHINE_CIRCUIT, VOID_INGOT,
            VOID_INGOT, MACHINE_CIRCUIT, ADVANCED_CHARGER, ADVANCED_CHARGER, MACHINE_CIRCUIT, VOID_INGOT,
            VOID_INGOT, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CORE, INFINITY_MACHINE_CORE, INFINITY_MACHINE_CIRCUIT, VOID_INGOT,
            INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT
            // @formatter:on
        )
    }

    val ADVANCED_GEO_MINER = buildSlimefunItem<GeoMiner>(4, 120) {
        id = "ADVANCED_GEO_MINER"
        material = HeadTexture.GEO_MINER.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL_PLATE,
            MAGSTEEL_PLATE,
            MAGSTEEL_PLATE,
            SlimefunItems.COBALT_PICKAXE,
            SlimefunItems.GEO_MINER,
            SlimefunItems.COBALT_PICKAXE,
            MACHINE_CIRCUIT,
            MACHINE_CORE,
            MACHINE_CIRCUIT
        )
    }

    val ADVANCED_SMELTERY = buildSlimefunItem<Smeltery>(24, 240) {
        id = "ADVANCED_SMELTERY"
        material = Material.FURNACE.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            SlimefunItems.ELECTRIC_SMELTERY_2,
            SlimefunItems.ELECTRIC_SMELTERY_2,
            SlimefunItems.ELECTRIC_SMELTERY_2,
            SlimefunItems.ELECTRIC_SMELTERY_2,
            SlimefunItems.ELECTRIC_SMELTERY_2,
            SlimefunItems.ELECTRIC_SMELTERY_2,
            MACHINE_CIRCUIT,
            MACHINE_CORE,
            MACHINE_CIRCUIT
        )
    }

    val VOID_SMELTERY = buildSlimefunItem<Smeltery>(72, 1200) {
        id = "VOID_SMELTERY"
        material = Material.FURNACE.convert()
        itemGroup = IEItemGroups.SLIMEFUN_EXPANSION
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            VOID_BLOCK,
            MACHINE_CORE,
            VOID_BLOCK,
            MACHINE_CIRCUIT,
            ADVANCED_SMELTERY,
            MACHINE_CIRCUIT,
            VOID_BLOCK,
            ADVANCED_SMELTERY,
            VOID_BLOCK
        )
    }
    // </editor-fold>

    // <editor-fold desc="Tools" collapsed="true">
    val ENDER_FLAME = buildSlimefunItem<SimpleMaterial> {
        id = "ENDER_FLAME"
        material = Material.ENCHANTED_BOOK.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = RecipeType.MAGIC_WORKBENCH
        recipe = ItemStack(Material.BOOK) surroundedBy ENDER_ESSENCE

        postCreate = {
            it.addUnsafeEnchantment(Enchantment.getByName("fire_aspect")!!, 10)
        }
    }

    val VEIN_MINER_RUNE = buildSlimefunItem<SimpleMaterial> {
        id = "VEIN_MINER_RUNE"
        material = Material.DIAMOND.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = RecipeType.MAGIC_WORKBENCH
        recipe = arrayOf(
            MAGSTEEL_PLATE, SlimefunItems.PICKAXE_OF_VEIN_MINING, MAGSTEEL_PLATE,
            ENDER_ESSENCE, SlimefunItems.BLANK_RUNE, ENDER_ESSENCE,
            MAGSTEEL_PLATE, SlimefunItems.PICKAXE_OF_VEIN_MINING, MAGSTEEL_PLATE,
        )
    }

    val STRAINER_BASE = buildSlimefunItem<StrainerBase> {
        id = "STRAINER_BASE"
        material = Material.SANDSTONE_WALL.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            STICK, STRING, STICK,
            STICK, STRING, STICK,
            MAGSTEEL, MAGSTEEL, MAGSTEEL,
        )
    }

    val STRAINER_1 = buildSlimefunItem<Strainer>(30) {
        id = "STRAINER_1"
        material = Material.FISHING_ROD.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            STICK, STRING, STICK,
            STRING, STICK, STRING,
            STICK, STRING, STICK,
        )
    }

    val STRAINER_2 = buildSlimefunItem<Strainer>(60) {
        id = "STRAINER_2"
        material = Material.FISHING_ROD.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL, STRING, MAGSTEEL,
            STRING, STRAINER_1, STRING,
            MAGSTEEL, STRING, MAGSTEEL,
        )
    }

    val STRAINER_3 = buildSlimefunItem<Strainer>(90) {
        id = "STRAINER_3"
        material = Material.FISHING_ROD.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            SlimefunItems.REINFORCED_ALLOY_INGOT, STRING, SlimefunItems.REINFORCED_ALLOY_INGOT,
            STRING, STRAINER_2, STRING,
            SlimefunItems.REINFORCED_ALLOY_INGOT, STRING, SlimefunItems.REINFORCED_ALLOY_INGOT,
        )
    }

    val INFINITY_PICKAXE = buildSlimefunItem<InfinityTool> {
        id = "INFINITY_PICKAXE"
        material = Material.NETHERITE_PICKAXE.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, null,
            null, null, null, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT,
            null, null, null, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT,
            null, null, VOID_INGOT, null, null, INFINITY_INGOT,
            null, VOID_INGOT, null, null, null, VOID_INGOT,
            VOID_INGOT, null, null, null, null, null,
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINITY_AXE = buildSlimefunItem<InfinityTool> {
        id = "INFINITY_AXE"
        material = Material.NETHERITE_AXE.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, null, null,
            VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, null,
            null, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT,
            null, null, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT,
            null, VOID_INGOT, null, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, null, null, null, VOID_INGOT, null
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINITY_SHOVEL = buildSlimefunItem<InfinityTool> {
        id = "INFINITY_SHOVEL"
        material = Material.NETHERITE_SHOVEL.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, null, null, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT,
            null, null, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT,
            null, null, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT,
            null, null, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, null,
            null, VOID_INGOT, null, null, null, null,
            VOID_INGOT, null, null, null, null, null
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINITY_HOE = buildSlimefunItem<InfinityTool> {
        id = "INFINITY_HOE"
        material = Material.NETHERITE_HOE.convert()
        itemGroup = IEItemGroups.TOOLS
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT,
            null, null, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT,
            null, null, null, VOID_INGOT, null, null,
            null, null, VOID_INGOT, null, null, null,
            null, VOID_INGOT, null, null, null, null,
            VOID_INGOT, null, null, null, null, null,
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }
    // </editor-fold>

    // <editor-fold desc="Gears" collapsed="true">
    val INFINITY_HELMET = buildSlimefunItem<InfinityArmor>(
        arrayOf(
            buildHiddenPotionEffect("night_vision", 600, 0),
            buildHiddenPotionEffect("conduit_power", 600, 0),
        ),
        arrayOf(ProtectionType.FLYING_INTO_WALL),
    ) {
        id = "INFINITY_HELMET"
        material = Material.NETHERITE_HELMET.convert()
        itemGroup = IEItemGroups.GEAR
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, null,
            INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT,
            INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT,
            null, INFINITY_INGOT, null, null, INFINITY_INGOT, null,
            null, null, null, null, null, null,
            null, null, null, null, null, null,
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINIYT_CHESTPLATE = buildSlimefunItem<InfinityArmor>(
        arrayOf(
            buildHiddenPotionEffect("night_vision", 600, 0),
            buildHiddenPotionEffect("conduit_power", 600, 0),
        ),
        arrayOf(ProtectionType.BEES),
    ) {
        id = "INFINITY_CHESTPLATE"
        material = Material.NETHERITE_CHESTPLATE.convert()
        itemGroup = IEItemGroups.GEAR
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, INFINITY_INGOT, null, null, INFINITY_INGOT, null,
            INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT,
            VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, INFINITY_INGOT, VOID_INGOT, VOID_INGOT, INFINITY_INGOT, VOID_INGOT,
            null, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, null,
            null, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, null,
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINITY_LEGGINGS = buildSlimefunItem<InfinityArmor>(
        arrayOf(
            buildHiddenPotionEffect("haste", 600, 2),
            buildHiddenPotionEffect("regeneration", 600, 0),
            buildHiddenPotionEffect("saturation", 600, 0),
        ),
        arrayOf(ProtectionType.RADIATION),
    ) {
        id = "INFINITY_LEGGINGS"
        material = Material.NETHERITE_LEGGINGS.convert()
        itemGroup = IEItemGroups.GEAR
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, null,
            INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT,
            VOID_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, VOID_INGOT,
            null, INFINITY_INGOT, null, null, INFINITY_INGOT, null,
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINITY_BOOTS = buildSlimefunItem<InfinityArmor>(
        arrayOf(
            buildHiddenPotionEffect("speed", 600, 2),
            buildHiddenPotionEffect("dolphins_grace", 600, 0),
        ),
        arrayOf<ProtectionType>()
    ) {
        id = "INFINITY_BOOTS"
        material = Material.NETHERITE_BOOTS.convert()
        itemGroup = IEItemGroups.GEAR
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, null, null, null, null, null,
            INFINITY_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, INFINITY_INGOT,
            INFINITY_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, INFINITY_INGOT,
            VOID_INGOT, VOID_INGOT, null, null, VOID_INGOT, VOID_INGOT,
            INFINITY_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, INFINITY_INGOT,
            INFINITY_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, INFINITY_INGOT,
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINITY_SHIELD = buildSlimefunItem<InfinityTool> {
        id = "INFINITY_SHIELD"
        material = Material.SHIELD.convert()
        itemGroup = IEItemGroups.GEAR
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            INFINITY_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, INFINITY_INGOT,
            INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT,
            INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT,
            INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT,
            null, INFINITY_INGOT, VOID_INGOT, VOID_INGOT, INFINITY_INGOT, null,
            null, INFINITY_INGOT, VOID_INGOT, VOID_INGOT, INFINITY_INGOT, null,
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINITY_SWORD = buildSlimefunItem<InfinityTool> {
        id = "INFINITY_SWORD"
        material = Material.NETHERITE_SWORD.convert()
        itemGroup = IEItemGroups.GEAR
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, null, null, null, INFINITY_INGOT, INFINITY_INGOT,
            null, null, null, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT,
            null, null, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, null,
            INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, null, null,
            null, VOID_INGOT, INFINITY_INGOT, null, null, null,
            VOID_INGOT, null, INFINITY_INGOT, null, null, null
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINITY_BOW = buildSlimefunItem<InfinityBow> {
        id = "INFINITY_BOW"
        material = Material.BOW.convert()
        itemGroup = IEItemGroups.GEAR
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, null, null,
            INFINITY_INGOT, null, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, null,
            VOID_INGOT, null, null, ENDER_FLAME, INFINITY_INGOT, VOID_INGOT,
            null, VOID_INGOT, null, null, INFINITY_INGOT, INFINITY_INGOT,
            null, null, VOID_INGOT, null, null, INFINITY_INGOT,
            null, null, null, VOID_INGOT, INFINITY_INGOT, null
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }

    val INFINITY_CROSSBOW = buildSlimefunItem<InfinityBow> {
        id = "INFINITY_CROSSBOW"
        material = Material.CROSSBOW.convert()
        itemGroup = IEItemGroups.GEAR
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, INFINITY_INGOT, null,
            VOID_INGOT, INFINITY_INGOT, VOID_INGOT, null, null, INFINITY_INGOT,
            INFINITY_INGOT, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT, null, VOID_INGOT,
            INFINITY_INGOT, null, INFINITY_INGOT, INFINITY_INGOT, VOID_INGOT, null,
            INFINITY_INGOT, null, null, VOID_INGOT, INFINITY_INGOT, INFINITY_INGOT,
            null, INFINITY_INGOT, VOID_INGOT, null, INFINITY_INGOT, INFINITY_INGOT,
            // @formatter:on
        )
        postCreate = {
            applyInfinityGearEnchantment(it)
        }
    }
    // </editor-fold>

    // <editor-fold desc="Machines" collapsed="true">
    val COBBLESTONE_GENERATOR = buildSlimefunItem<MaterialGenerator>(Material.COBBLESTONE, 1, 24) {
        id = "COBBLESTONE_GENERATOR"
        material = Material.SMOOTH_STONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL, DIAMOND_PICKAXE, MAGSTEEL,
            WATER_BUCKET, COMPRESSED_COBBLESTONE_2, LAVA_BUCKET,
            MAGSTEEL, MACHINE_CIRCUIT, MAGSTEEL,
        )
    }

    val COBBLESTONE_GENERATOR_2 = buildSlimefunItem<MaterialGenerator>(Material.COBBLESTONE, 4, 120) {
        id = "COBBLESTONE_GENERATOR_2"
        material = Material.SMOOTH_STONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL, COBBLESTONE_GENERATOR, MAGSTEEL,
            WATER_BUCKET, COMPRESSED_COBBLESTONE_3, LAVA_BUCKET,
            MACHINE_CIRCUIT, COBBLESTONE_GENERATOR, MACHINE_CIRCUIT,
        )
    }

    val COBBLESTONE_GENERATOR_3 = buildSlimefunItem<MaterialGenerator>(Material.COBBLESTONE, 16, 360) {
        id = "COBBLESTONE_GENERATOR_3"
        material = Material.SMOOTH_STONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            VOID_BLOCK, COBBLESTONE_GENERATOR_2, MACHINE_PLATE,
            WATER_BUCKET, COMPRESSED_COBBLESTONE_4, LAVA_BUCKET,
            MACHINE_CIRCUIT, COBBLESTONE_GENERATOR_2, VOID_BLOCK,
        )
    }

    val COBBLESTONE_GENERATOR_4 = buildSlimefunItem<MaterialGenerator>(Material.COBBLESTONE, 64, 800) {
        id = "COBBLESTONE_GENERATOR_4"
        material = Material.SMOOTH_STONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            INFINITY_INGOT, VOID_INGOT, null, null, VOID_INGOT, INFINITY_INGOT,
            null, VOID_INGOT, COBBLESTONE_GENERATOR_3, COBBLESTONE_GENERATOR_3, VOID_INGOT, null,
            null, VOID_INGOT, COBBLESTONE_GENERATOR_3, COBBLESTONE_GENERATOR_3, VOID_INGOT, null,
            null, VOID_INGOT, COBBLESTONE_GENERATOR_3, COBBLESTONE_GENERATOR_3, VOID_INGOT, null,
            null, VOID_INGOT, COBBLESTONE_GENERATOR_3, COBBLESTONE_GENERATOR_3, VOID_INGOT, null,
            INFINITY_INGOT, VOID_INGOT, null, null, VOID_INGOT, INFINITY_INGOT,
        )
    }

    val VIRTUAL_FARM = buildSlimefunItem<VirtualFarm>(18, 300) {
        id = "VIRTUAL_FARM"
        material = Material.GRASS_BLOCK.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            GLASS, GLASS, GLASS,
            MAGSTEEL, ItemStack(Material.DIAMOND_HOE), MAGSTEEL,
            MACHINE_CIRCUIT, GRASS_BLOCK, MACHINE_CIRCUIT,
        )
    }

    val VIRTUAL_FARM_2 = buildSlimefunItem<VirtualFarm>(90, 60) {
        id = "VIRTUAL_FARM_2"
        material = Material.CRIMSON_NYLIUM.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS,
            MAGNONIUM, VIRTUAL_FARM, MAGNONIUM,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    val VIRTUAL_FARM_3 = buildSlimefunItem<VirtualFarm>(270, 30) {
        id = "VIRTUAL_FARM_3"
        material = Material.WARPED_NYLIUM.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            VOID_BLOCK, VIRTUAL_FARM_2, VOID_BLOCK,
            MACHINE_CORE, VIRTUAL_FARM_2, MACHINE_CORE,
            VOID_BLOCK, VIRTUAL_FARM_2, VOID_BLOCK,
        )
    }

    val VIRTUAL_FARM_4 = buildSlimefunItem<VirtualFarm>(1000, 10) {
        id = "VIRTUAL_FARM_4"
        material = Material.END_STONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            GLASS, GLASS, GLASS, GLASS, GLASS, GLASS,
            GLASS, null, null, null, null, GLASS,
            GLASS, null, null, null, null, GLASS,
            GLASS, GRASS_BLOCK, GRASS_BLOCK, GRASS_BLOCK, GRASS_BLOCK, GLASS,
            MACHINE_PLATE, SlimefunItems.CROP_GROWTH_ACCELERATOR_2, VIRTUAL_FARM_3, VIRTUAL_FARM_3, SlimefunItems.CROP_GROWTH_ACCELERATOR_2, MACHINE_PLATE,
            MACHINE_PLATE, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CORE, INFINITY_MACHINE_CORE, INFINITY_MACHINE_CIRCUIT, MACHINE_PLATE,
            // @formatter:on
        )
    }

    val TREE_GROWER = buildSlimefunItem<TreeGrower>(36, 600) {
        id = "TREE_GROWER"
        material = Material.STRIPPED_OAK_WOOD.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            GLASS, GLASS, GLASS,
            MAGSTEEL, PODZOL, MAGSTEEL,
            MACHINE_CIRCUIT, VIRTUAL_FARM, MACHINE_CIRCUIT,
        )
    }

    val TREE_GROWER_2 = buildSlimefunItem<TreeGrower>(180, 120) {
        id = "TREE_GROWER_2"
        material = Material.STRIPPED_ACACIA_WOOD.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS,
            MAGNONIUM, TREE_GROWER, MAGNONIUM,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    val TREE_GROWER_3 = buildSlimefunItem<TreeGrower>(540, 60) {
        id = "TREE_GROWER_3"
        material = Material.STRIPPED_CRIMSON_HYPHAE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            VOID_BLOCK, TREE_GROWER_2, VOID_BLOCK,
            MACHINE_CORE, TREE_GROWER_2, MACHINE_CORE,
            VOID_BLOCK, TREE_GROWER_2, VOID_BLOCK,
        )
    }

    val TREE_GROWER_4 = buildSlimefunItem<TreeGrower>(2000, 12) {
        id = "TREE_GROWER_4"
        material = Material.STRIPPED_WARPED_HYPHAE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            GLASS, GLASS, GLASS, GLASS, GLASS, GLASS,
            GLASS, SlimefunItems.TREE_GROWTH_ACCELERATOR, null, null, SlimefunItems.TREE_GROWTH_ACCELERATOR, GLASS,
            GLASS, TREE_GROWER_3, null, null, TREE_GROWER_3, GLASS,
            GLASS, SlimefunItems.TREE_GROWTH_ACCELERATOR, null, null, SlimefunItems.TREE_GROWTH_ACCELERATOR, GLASS,
            MACHINE_PLATE, PODZOL, PODZOL, PODZOL, PODZOL, MACHINE_PLATE,
            MACHINE_PLATE, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CORE, INFINITY_MACHINE_CORE, INFINITY_MACHINE_CIRCUIT, MACHINE_PLATE,
            // @formatter:on
        )
    }

    val VOID_HARVESTER = buildSlimefunItem<VoidHarvester>(1, 120) {
        id = "VOID_HARVESTER"
        material = Material.OBSIDIAN.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            TITANIUM, TITANIUM, TITANIUM,
            MACHINE_PLATE, SlimefunItems.GEO_MINER, MACHINE_PLATE,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    val VOID_HARVESTER_2 = buildSlimefunItem<VoidHarvester>(8, 1200) {
        id = "VOID_HARVESTER_2"
        material = Material.OBSIDIAN.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE,
            MAGSTEEL_PLATE, VOID_HARVESTER, MAGSTEEL_PLATE,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    val VOID_HARVESTER_3 = buildSlimefunItem<VoidHarvester>(64, 12000) {
        id = "VOID_HARVESTER_3"
        material = Material.CRYING_OBSIDIAN.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE,
            MAGNONIUM, VOID_INGOT, VOID_INGOT, VOID_INGOT, VOID_INGOT, MAGNONIUM,
            MAGNONIUM, VOID_INGOT, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CIRCUIT, VOID_INGOT, MAGNONIUM,
            MAGNONIUM, VOID_INGOT, VOID_HARVESTER_2, VOID_HARVESTER_2, VOID_INGOT, MAGNONIUM,
            MAGNONIUM, VOID_INGOT, VOID_INGOT, VOID_INGOT, VOID_INGOT, MAGNONIUM,
            MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE,
            // @formatter:on
        )
    }

    val STONEWORKS_FACTORY = buildSlimefunItem<StoneworksFactory>(1, 200) {
        id = "STONEWORKS_FACTORY"
        material = Material.BLAST_FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL_PLATE, COBBLESTONE_GENERATOR, MAGSTEEL_PLATE,
            SlimefunItems.ELECTRIC_FURNACE, MACHINE_CIRCUIT, SlimefunItems.ELECTRIC_ORE_GRINDER,
            MAGSTEEL_PLATE, SlimefunItems.ELECTRIC_PRESS, MAGSTEEL_PLATE,
        )
    }

    val STONEWORKS_FACTORY_2 = buildSlimefunItem<StoneworksFactory>(4, 600) {
        id = "STONEWORKS_FACTORY_2"
        material = Material.BLAST_FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL_PLATE, COBBLESTONE_GENERATOR_2, MAGSTEEL_PLATE,
            SlimefunItems.ELECTRIC_FURNACE_2, STONEWORKS_FACTORY, SlimefunItems.ELECTRIC_ORE_GRINDER_2,
            MACHINE_CIRCUIT, SlimefunItems.ELECTRIC_PRESS_2, MACHINE_CIRCUIT,
        )
    }

    val STONEWORKS_FACTORY_3 = buildSlimefunItem<StoneworksFactory>(16, 1800) {
        id = "STONEWORKS_FACTORY_3"
        material = Material.BLAST_FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MACHINE_PLATE, COBBLESTONE_GENERATOR_3, VOID_BLOCK,
            SlimefunItems.ELECTRIC_FURNACE_3, STONEWORKS_FACTORY_2, SlimefunItems.ELECTRIC_ORE_GRINDER_3,
            VOID_BLOCK, SlimefunItems.ELECTRIC_PRESS_2, MACHINE_CIRCUIT,
        )
    }

    val STONEWORKS_FACTORY_4 = buildSlimefunItem<StoneworksFactory>(64, 5400) {
        id = "STONEWORKS_FACTORY_4"
        material = Material.BLAST_FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            INFINITY_INGOT, VOID_INGOT, null, null, VOID_INGOT, INFINITY_INGOT,
            null, SlimefunItems.ELECTRIC_FURNACE_3, STONEWORKS_FACTORY_3, STONEWORKS_FACTORY_3, SlimefunItems.ELECTRIC_FURNACE_3, null,
            SlimefunItems.ELECTRIC_ORE_GRINDER_3, VOID_INGOT, COBBLESTONE_GENERATOR_4, COBBLESTONE_GENERATOR_4, VOID_INGOT, SlimefunItems.ELECTRIC_ORE_GRINDER_3,
            SlimefunItems.ELECTRIC_PRESS_2, VOID_INGOT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, VOID_INGOT, SlimefunItems.ELECTRIC_PRESS_2,
            MACHINE_PLATE, MACHINE_CIRCUIT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, MACHINE_CIRCUIT, MACHINE_PLATE,
            INFINITY_INGOT, VOID_INGOT, null, null, VOID_INGOT, INFINITY_INGOT,
            // @formatter:on
        )
    }

    val SINGULARITY_CONSTRUCTOR = buildSlimefunItem<SingularityConstructor>(1, 120) {
        id = "SINGULARITY_CONSTRUCTOR"
        material = Material.QUARTZ_BRICKS.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL, MAGSTEEL, MAGSTEEL,
            MACHINE_PLATE, SlimefunItems.CARBON_PRESS_3, MACHINE_PLATE,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    // TODO: more tiers of singularity constructor

    val RESOURCE_SYNTHESIZER = buildSlimefunItem<ResourceSynthesizer>(1_000_000) {
        id = "RESOURCE_SYNTHESIZER"
        material = Material.LODESTONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            // @formatter:off
            ADAMANTITE, ADAMANTITE, ADAMANTITE,
            MACHINE_PLATE, SlimefunItems.REINFORCED_FURNACE, MACHINE_PLATE,
            MACHINE_PLATE, MACHINE_CORE, MACHINE_PLATE,
            // @formatter:on
        )
    }

    val OBSIDIAN_GENERATOR = buildSlimefunItem<MaterialGenerator>(Material.OBSIDIAN, 1, 240) {
        id = "OBSIDIAN_GENERATOR"
        material = Material.SMOOTH_STONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            SlimefunItems.FLUID_PUMP, SlimefunItems.PROGRAMMABLE_ANDROID_MINER, SlimefunItems.FLUID_PUMP,
            ItemStack(Material.DISPENSER), VOID_INGOT, ItemStack(Material.DISPENSER),
            MACHINE_CIRCUIT, COBBLESTONE_GENERATOR_2, MACHINE_CIRCUIT,
        )
    }

    // TODO: more tiers of obsidian generator?

    val EXTREME_FREEZER = buildSlimefunItem<ExtremeFreezer>(90) {
        id = "EXTREME_FREEZER"
        material = Material.LIGHT_BLUE_CONCRETE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            SlimefunItems.FREEZER_2, SlimefunItems.FREEZER_2, SlimefunItems.FREEZER_2,
            WATER_BUCKET, SlimefunItems.FLUID_PUMP, WATER_BUCKET,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    val DUST_EXTRACTOR = buildSlimefunItem<DustExtractor>(200, 4, 2) {
        id = "DUST_EXTRACTOR"
        material = Material.FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            // @formatter:off
            SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_GOLD_PAN_3, SlimefunItems.ELECTRIC_DUST_WASHER_3,
            SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_GOLD_PAN_3, SlimefunItems.ELECTRIC_DUST_WASHER_3,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
            // @formatter:on
        )
    }

    val DUST_EXTRACTOR_2 = buildSlimefunItem<DustExtractor>(800, 8, 4) {
        id = "DUST_EXTRACTOR_2"
        material = Material.FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            // @formatter:off
            MAGSTEEL_PLATE, DUST_EXTRACTOR, MAGSTEEL_PLATE,
            MAGSTEEL_PLATE, DUST_EXTRACTOR, MAGSTEEL_PLATE,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
            // @formatter:on
        )
    }

    val DUST_EXTRACTOR_3 = buildSlimefunItem<DustExtractor>(2400, 32, 32) {
        id = "DUST_EXTRACTOR_3"
        material = Material.FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            // @formatter:off
            VOID_BLOCK, DUST_EXTRACTOR_2, VOID_BLOCK,
            MACHINE_PLATE, DUST_EXTRACTOR_2, MACHINE_PLATE,
            MACHINE_PLATE, MACHINE_CORE, MACHINE_PLATE,
            // @formatter:on
        )
    }

    val DUST_EXTRACTOR_4 = buildSlimefunItem<DustExtractor>(7200, 64, 64) {
        id = "DUST_EXTRACTOR_4"
        material = Material.FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            VOID_BLOCK, null, null, null, null, VOID_BLOCK,
            VOID_INGOT, INFINITY_INGOT, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CIRCUIT, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, INFINITY_INGOT, DUST_EXTRACTOR_3, DUST_EXTRACTOR_3, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, VOID_INGOT,
            VOID_BLOCK, null, null, null, null, VOID_BLOCK,
            // @formatter:on
        )
    }

    val INGOT_FORMER = buildSlimefunItem<IngotFormer>(200, 8, 4) {
        id = "INGOT_FORMER"
        material = Material.BLAST_FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            // @formatter:off
            SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2,
            SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
            // @formatter:on
        )
    }

    val INGOT_FORMER_2 = buildSlimefunItem<IngotFormer>(800, 16, 8) {
        id = "INGOT_FORMER_2"
        material = Material.BLAST_FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            // @formatter:off
            MAGSTEEL_PLATE, INGOT_FORMER, MAGSTEEL_PLATE,
            MAGSTEEL_PLATE, INGOT_FORMER, MAGSTEEL_PLATE,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
            // @formatter:on
        )
    }

    val INGOT_FORMER_3 = buildSlimefunItem<IngotFormer>(2400, 32, 16) {
        id = "INGOT_FORMER_3"
        material = Material.BLAST_FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            // @formatter:off
            VOID_BLOCK, INGOT_FORMER_2, VOID_BLOCK,
            MACHINE_PLATE, INGOT_FORMER_2, MACHINE_PLATE,
            MACHINE_PLATE, MACHINE_CORE, MACHINE_PLATE,
            // @formatter:on
        )
    }

    val INGOT_FORMER_4 = buildSlimefunItem<IngotFormer>(7200, 64, 32) {
        id = "INGOT_FORMER_4"
        material = Material.BLAST_FURNACE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            VOID_BLOCK, null, null, null, null, VOID_BLOCK,
            VOID_INGOT, INFINITY_INGOT, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CIRCUIT, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, INFINITY_INGOT, INGOT_FORMER_3, INGOT_FORMER_3, INFINITY_INGOT, VOID_INGOT,
            VOID_INGOT, INFINITY_INGOT, null, null, INFINITY_INGOT, VOID_INGOT,
            VOID_BLOCK, null, null, null, null, VOID_BLOCK,
            // @formatter:on
        )
    }

    val URANIUM_EXTRACTOR = buildSlimefunItem<UraniumExtractor>(200, 4, 1) {
        id = "URANIUM_EXTRACTOR"
        material = Material.LIME_CONCRETE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            // @formatter:off
            SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_ORE_GRINDER_2,
            SlimefunItems.ELECTRIC_GOLD_PAN_3, SlimefunItems.ELECTRIC_DUST_WASHER_3, SlimefunItems.ENHANCED_AUTO_CRAFTER,
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
            // @formatter:on
        )
    }

    val COBBLE_PRESS = buildSlimefunItem<CobblePress>(200) {
        id = "COBBLE_PRESS"
        material = Material.SMOOTH_STONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MACHINE_PLATE,
            COMPRESSED_COBBLESTONE_3,
            MACHINE_PLATE,
            SlimefunItems.ELECTRIC_PRESS_2,
            SlimefunItems.ELECTRIC_PRESS_2,
            SlimefunItems.ELECTRIC_PRESS_2,
            MACHINE_PLATE,
            COMPRESSED_COBBLESTONE_3,
            MACHINE_PLATE
        )
    }

    val DECOMPRESSOR = buildSlimefunItem<Decompressor>(60) {
        id = "DECOMPRESSOR"
        material = Material.TARGET.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL_PLATE, MAGSTEEL_PLATE, MAGSTEEL_PLATE,
            ItemStack(Material.STICKY_PISTON), SlimefunItems.ELECTRIC_PRESS_2, ItemStack(Material.STICKY_PISTON),
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    val QUARRY = buildSlimefunItem<Quarry>(300, 1, 0.15) {
        id = "QUARRY"
        material = Material.CHISELED_SANDSTONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MAGSTEEL_PLATE, SlimefunItems.CARBONADO_EDGED_CAPACITOR, MAGSTEEL_PLATE,
            ItemStack(Material.IRON_PICKAXE), SlimefunItems.GEO_MINER, ItemStack(Material.IRON_PICKAXE),
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    val QUARRY_2 = buildSlimefunItem<Quarry>(900, 2, 0.25) {
        id = "QUARRY_2"
        material = Material.CHISELED_RED_SANDSTONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MACHINE_PLATE, SlimefunItems.ENERGIZED_CAPACITOR, MACHINE_PLATE,
            ItemStack(Material.DIAMOND_PICKAXE), QUARRY, ItemStack(Material.DIAMOND_PICKAXE),
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    val QUARRY_3 = buildSlimefunItem<Quarry>(3600, 4, 0.5) {
        id = "QUARRY_3"
        material = Material.CHISELED_NETHER_BRICKS.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            VOID_INGOT, VOID_CAPACITOR, VOID_INGOT,
            ItemStack(Material.NETHERITE_PICKAXE), QUARRY_2, ItemStack(Material.NETHERITE_PICKAXE),
            MACHINE_CIRCUIT, MACHINE_CORE, MACHINE_CIRCUIT,
        )
    }

    val QUARRY_4 = buildSlimefunItem<Quarry>(36000, 64, 1.0) {
        id = "QUARRY_4"
        material = Material.CHISELED_POLISHED_BLACKSTONE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            null, MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE, MACHINE_PLATE, null,
            MACHINE_PLATE, INFINITY_PICKAXE, INFINITY_MACHINE_CIRCUIT, INFINITY_MACHINE_CIRCUIT, INFINITY_PICKAXE, MACHINE_PLATE,
            MACHINE_PLATE, QUARRY_3, INFINITY_MACHINE_CORE, INFINITY_MACHINE_CORE, QUARRY_3, MACHINE_PLATE,
            VOID_INGOT, null, INFINITY_INGOT, INFINITY_INGOT, null, VOID_INGOT,
            VOID_INGOT, null, INFINITY_INGOT, INFINITY_INGOT, null, VOID_INGOT,
            VOID_INGOT, null, INFINITY_INGOT, INFINITY_INGOT, null, VOID_INGOT,
            // @formatter:on
        )
    }

    val GEO_QUARRY = buildSlimefunItem<GeoQuarry>(450, 400, 1) {
        id = "GEO_QUARRY"
        material = Material.QUARTZ_BRICKS.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            MACHINE_PLATE, VOID_INGOT, MACHINE_PLATE,
            VOID_INGOT, ADVANCED_GEO_MINER, VOID_INGOT,
            MACHINE_PLATE, VOID_INGOT, MACHINE_PLATE,
        )
    }

    val GEO_QUARRY_2 = buildSlimefunItem<GeoQuarry>(90000, 120, 4) {
        id = "GEO_QUARRY_2"
        material = Material.QUARTZ_BRICKS.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = IERecipeTypes.INFINITY_WORKBENCH
        recipe = arrayOf(
            // @formatter:off
            INFINITY_INGOT, null, null, null, null, INFINITY_INGOT,
            null, VOID_INGOT, VOID_INGOT, VOID_INGOT, VOID_INGOT, null,
            INFINITY_MACHINE_CIRCUIT, VOID_INGOT, GEO_QUARRY, GEO_QUARRY, VOID_INGOT, INFINITY_MACHINE_CIRCUIT,
            INFINITY_MACHINE_CIRCUIT, VOID_INGOT, GEO_QUARRY, GEO_QUARRY, VOID_INGOT, INFINITY_MACHINE_CIRCUIT,
            null, VOID_INGOT, VOID_INGOT, VOID_INGOT, VOID_INGOT, null,
            INFINITY_INGOT, null, null, null, null, INFINITY_INGOT,
            // @formatter:on
        )
    }

    val INFINITY_WORKBENCH = buildSlimefunItem<InfinityWorkbench>(10_000_000) {
        id = "INFINITY_WORKBENCH"
        material = Material.SMITHING_TABLE.convert()
        itemGroup = IEItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = arrayOf(
            // @formatter:off
            VOID_BLOCK, MACHINE_PLATE, VOID_BLOCK,
            SlimefunItems.ENERGIZED_CAPACITOR, ItemStack(Material.CRAFTING_TABLE), SlimefunItems.ENERGIZED_CAPACITOR,
            VOID_BLOCK, MACHINE_PLATE, VOID_BLOCK,
            // @formatter:on
        )
    }
    // </editor-fold>

    // <editor-fold desc="Generators" collapsed="true">
    // </editor-fold>

    // <editor-fold desc="Hidden" collapsed="true">
    val OSCILLATOR = buildSlimefunItem<Oscillator> {
        id = "OSCILLATOR"
        material = Material.REDSTONE_TORCH.convert()
        itemGroup = IEItemGroups.HIDDEN
        recipeType = RecipeType.NULL
        recipe = emptyRecipe()
    }
    // </editor-fold>
}
