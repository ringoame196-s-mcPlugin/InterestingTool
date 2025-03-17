package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent

class InItemShovel() : InterestingTool(), BreakBlock {
    private val inItem = InItem()

    override val interToolId: String = "inItemShovel"
    override val itemMaterial: Material = Material.IRON_SHOVEL
    override val itemName: String = "${ChatColor.GOLD}Inアイテムシャベル"

    override val breakBlockDescription: String = inItem.breakBlockDescription

    override fun breakBlock(e: BlockBreakEvent) {
        inItem.breakBlock(e)
    }
}
