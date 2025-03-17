package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.block.BlockBreakEvent

class InItemPickaxe() : InterestingTool(), BreakBlock {
    override val interToolId: String = "inItemPickaxe"
    override val itemMaterial: Material = Material.IRON_PICKAXE
    override val itemName: String = "Inアイテムピッケル"

    override val breakBlockDescription: String = "掘ったアイテムをインベントリに"

    override fun breakBlock(e: BlockBreakEvent) {
        e.isDropItems = false
        val player = e.player
        val block = e.block
        val dropItems = block.drops
        val sound = Sound.ENTITY_ITEM_PICKUP

        player.playSound(player, sound, 1f, 1f)
        for (item in dropItems) { // ドロップしたアイテムを渡す
            player.inventory.addItem(item)
        }
    }
}
