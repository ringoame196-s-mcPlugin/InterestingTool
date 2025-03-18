package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import com.github.ringoame196_s_mcPlugin.tools.systems.PutItem
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent

class PutItemShovel() : InterestingTool(), BreakBlock {
    private val putItem = PutItem()

    override val interToolId: String = "putItemShovel"
    override val itemMaterial: Material = Material.IRON_SHOVEL
    override val itemName: String = "${ChatColor.GOLD}Putアイテムシャベル"

    override val breakBlockDescription: String = putItem.breakBlockDescription

    override fun breakBlock(e: BlockBreakEvent) {
        putItem.breakBlock(e)
    }
}
