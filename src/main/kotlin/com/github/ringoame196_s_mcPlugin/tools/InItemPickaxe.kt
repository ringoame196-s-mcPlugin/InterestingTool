package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent

class InItemPickaxe() : InterestingTool(), BreakBlock {
    private val inItem = InItem()

    override val interToolId: String = "inItemPickaxe"
    override val itemMaterial: Material = Material.IRON_PICKAXE
    override val itemName: String = "${ChatColor.GOLD}Inアイテムピッケル"

    override val breakBlockDescription: String = "掘ったアイテムをインベントリに"

    override fun breakBlock(e: BlockBreakEvent) {
        inItem.breakBlock(e)
    }
}
