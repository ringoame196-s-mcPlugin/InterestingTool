package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import com.github.ringoame196_s_mcPlugin.tools.systems.PutItem
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent

class PutItemPickaxe() : InterestingTool(), BreakBlock {
    private val putItem = PutItem()

    override val interToolId: String = "putItemPickaxe"
    override val itemMaterial: Material = Material.IRON_PICKAXE
    override val itemName: String = "${ChatColor.GOLD}Putアイテムピッケル"

    override val breakBlockDescription: String = putItem.breakBlockDescription

    override fun breakBlock(e: BlockBreakEvent) {
        putItem.breakBlock(e)
    }
}
