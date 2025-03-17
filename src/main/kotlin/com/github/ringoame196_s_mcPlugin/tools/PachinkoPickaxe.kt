package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent

class PachinkoPickaxe() : InterestingTool(), BreakBlock {
    override val interToolId: String = "pachinkoPickaxe"
    override val itemMaterial: Material = Material.IRON_PICKAXE
    override val itemName: String = "${ChatColor.AQUA}パチンコピッケル"

    override val breakBlockDescription: String = "鉱石が0~8まで出てくる"

    private val drawingList = listOf(
        0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8
    )

    override fun breakBlock(e: BlockBreakEvent) {
        val block = e.block
        val blockType = block.type

        if (!blockType.toString().contains("ORE")) return
        e.isDropItems = false
        val location = block.location
        val dropItems = block.drops
        val count = drawingList.random()

        for (item in dropItems) {
            item.amount = count
            location.world?.dropItem(location, item)
        }
    }
}
