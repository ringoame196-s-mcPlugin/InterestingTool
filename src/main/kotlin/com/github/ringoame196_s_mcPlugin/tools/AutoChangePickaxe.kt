package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BlockDamage
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.block.BlockDamageEvent
import org.bukkit.inventory.ItemStack

class AutoChangePickaxe() : InterestingTool(), BlockDamage {
    override val interToolId: String = "autoChangePickaxe"
    override val itemMaterial: Material = Material.IRON_PICKAXE
    override val itemName: String = "${ChatColor.GOLD}自動切り替えツール"

    override val breakDamageDescription: String = "適切なツールに切り替え"

    private val appropriateToolMap = mapOf(
        // 🪨 石・鉱石類
        Material.STONE to Material.IRON_PICKAXE,
        Material.COBBLESTONE to Material.IRON_PICKAXE,
        Material.IRON_ORE to Material.IRON_PICKAXE,
        Material.DEEPSLATE_IRON_ORE to Material.IRON_PICKAXE,
        Material.GOLD_ORE to Material.IRON_PICKAXE,
        Material.DEEPSLATE_GOLD_ORE to Material.IRON_PICKAXE,
        Material.DIAMOND_ORE to Material.IRON_PICKAXE,
        Material.DEEPSLATE_DIAMOND_ORE to Material.IRON_PICKAXE,
        Material.EMERALD_ORE to Material.IRON_PICKAXE,
        Material.DEEPSLATE_EMERALD_ORE to Material.IRON_PICKAXE,
        Material.REDSTONE_ORE to Material.IRON_PICKAXE,
        Material.DEEPSLATE_REDSTONE_ORE to Material.IRON_PICKAXE,
        Material.LAPIS_ORE to Material.IRON_PICKAXE,
        Material.DEEPSLATE_LAPIS_ORE to Material.IRON_PICKAXE,
        Material.NETHER_GOLD_ORE to Material.IRON_PICKAXE,
        Material.NETHER_QUARTZ_ORE to Material.IRON_PICKAXE,
        Material.ANCIENT_DEBRIS to Material.IRON_PICKAXE,
        Material.OBSIDIAN to Material.IRON_PICKAXE,
        Material.SANDSTONE to Material.IRON_PICKAXE,

        // 🪵 木材・木系
        Material.OAK_LOG to Material.IRON_AXE,
        Material.SPRUCE_LOG to Material.IRON_AXE,
        Material.BIRCH_LOG to Material.IRON_AXE,
        Material.JUNGLE_LOG to Material.IRON_AXE,
        Material.ACACIA_LOG to Material.IRON_AXE,
        Material.DARK_OAK_LOG to Material.IRON_AXE,
        Material.MANGROVE_LOG to Material.IRON_AXE,
        Material.CHERRY_LOG to Material.IRON_AXE,
        Material.CRIMSON_STEM to Material.IRON_AXE,
        Material.WARPED_STEM to Material.IRON_AXE,
        Material.STRIPPED_OAK_LOG to Material.IRON_AXE,
        Material.STRIPPED_SPRUCE_LOG to Material.IRON_AXE,
        Material.STRIPPED_BIRCH_LOG to Material.IRON_AXE,
        Material.STRIPPED_JUNGLE_LOG to Material.IRON_AXE,
        Material.STRIPPED_ACACIA_LOG to Material.IRON_AXE,
        Material.STRIPPED_DARK_OAK_LOG to Material.IRON_AXE,
        Material.STRIPPED_CRIMSON_STEM to Material.IRON_AXE,
        Material.STRIPPED_WARPED_STEM to Material.IRON_AXE,
        Material.OAK_WOOD to Material.IRON_AXE,
        Material.SPRUCE_WOOD to Material.IRON_AXE,
        Material.BIRCH_WOOD to Material.IRON_AXE,
        Material.JUNGLE_WOOD to Material.IRON_AXE,
        Material.ACACIA_WOOD to Material.IRON_AXE,
        Material.DARK_OAK_WOOD to Material.IRON_AXE,
        Material.MANGROVE_WOOD to Material.IRON_AXE,
        Material.CHERRY_WOOD to Material.IRON_AXE,

        // ⛏️ 土・砂系
        Material.DIRT to Material.IRON_SHOVEL,
        Material.GRASS_BLOCK to Material.IRON_SHOVEL,
        Material.COARSE_DIRT to Material.IRON_SHOVEL,
        Material.PODZOL to Material.IRON_SHOVEL,
        Material.ROOTED_DIRT to Material.IRON_SHOVEL,
        Material.SAND to Material.IRON_SHOVEL,
        Material.RED_SAND to Material.IRON_SHOVEL,
        Material.GRAVEL to Material.IRON_SHOVEL,
        Material.CLAY to Material.IRON_SHOVEL,
        Material.SNOW to Material.IRON_SHOVEL,
        Material.SNOW_BLOCK to Material.IRON_SHOVEL,
        Material.SOUL_SAND to Material.IRON_SHOVEL,
        Material.SOUL_SOIL to Material.IRON_SHOVEL,

        // ⚒️ その他
        Material.ICE to Material.IRON_PICKAXE,
        Material.PACKED_ICE to Material.IRON_PICKAXE,
        Material.BLUE_ICE to Material.IRON_PICKAXE,
        Material.NETHERRACK to Material.IRON_PICKAXE,
        Material.END_STONE to Material.IRON_PICKAXE,
        Material.BASALT to Material.IRON_PICKAXE,
        Material.BLACKSTONE to Material.IRON_PICKAXE,
        Material.MAGMA_BLOCK to Material.IRON_PICKAXE,
        Material.GLOWSTONE to Material.IRON_PICKAXE
    )

    override fun blockDamage(e: BlockDamageEvent) {
        val player = e.player
        val block = e.block
        val blockType = block.type
        val item = player.inventory.itemInMainHand
        val sound = Sound.ENTITY_ARROW_HIT_PLAYER

        val appropriateToolType = appropriateToolMap[blockType] ?: return
        if (item.type == appropriateToolType) return
        player.playSound(player, sound, 1f, 1f)
        val appropriateTool = changeTool(item, appropriateToolType)
        player.inventory.setItemInMainHand(appropriateTool)
    }

    private fun changeTool(item: ItemStack, appropriateToolType: Material): ItemStack {
        val itemMeta = item.itemMeta
        val appropriateTool = ItemStack(appropriateToolType)
        appropriateTool.itemMeta = itemMeta
        return appropriateTool
    }
}
