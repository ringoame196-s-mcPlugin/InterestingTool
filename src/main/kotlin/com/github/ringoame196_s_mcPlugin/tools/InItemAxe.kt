package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent

class InItemAxe() : InterestingTool(), BreakBlock {
    private val inItem = InItem()

    override val interToolId: String = "inItemAxe"
    override val itemMaterial: Material = Material.IRON_AXE
    override val itemName: String = "${ChatColor.GOLD}Inアイテム斧"

    override val breakBlockDescription: String = "掘ったアイテムをインベントリに"

    override fun breakBlock(e: BlockBreakEvent) {
        inItem.breakBlock(e)
    }
}
