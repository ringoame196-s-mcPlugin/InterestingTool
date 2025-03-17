package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import org.bukkit.Sound
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent

class InEnderChest : BreakBlock, RightClick {
    override val breakBlockDescription: String = "掘ったアイテムをエンダーチェストに"
    override val rightDescription: String = "エンダーチェストを開く"

    override fun breakBlock(e: BlockBreakEvent) {
        e.isDropItems = false
        val player = e.player
        val block = e.block
        val dropItems = block.drops
        val sound = Sound.ENTITY_ITEM_PICKUP

        player.playSound(player, sound, 1f, 1f)
        for (item in dropItems) { // ドロップしたアイテムをエンダーチェストに入れる
            player.enderChest.addItem(item)
        }
    }

    override fun rightClick(e: PlayerInteractEvent) {
        val player = e.player
        val sound = Sound.BLOCK_ENDER_CHEST_OPEN
        player.openInventory(player.enderChest)
        player.playSound(player, sound, 1f, 1f)
    }
}
