package com.github.ringoame196_s_mcPlugin.tools.systems

import org.bukkit.Sound
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.Inventory

class PutSystem {
    fun breakBlock(e: BlockBreakEvent, inventory: Inventory) {
        e.isDropItems = false
        val player = e.player
        val block = e.block
        val dropItems = block.drops
        val sound = Sound.ENTITY_ITEM_PICKUP

        player.playSound(player, sound, 1f, 1f)
        for (item in dropItems) { // ドロップしたアイテムを渡す
            inventory.addItem(item)
        }
    }
}
