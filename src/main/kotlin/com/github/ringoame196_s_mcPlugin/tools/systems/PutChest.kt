package com.github.ringoame196_s_mcPlugin.tools.systems

import com.github.ringoame196_s_mcPlugin.Data
import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import com.github.ringoame196_s_mcPlugin.events.Interface.LeftClick
import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.block.Chest
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent

class PutChest : BreakBlock, RightClick, LeftClick {
    override val breakBlockDescription: String = "掘ったアイテムをチェストに"
    override val rightDescription: String = "チェストを開く"
    override val leftDescription: String = "チェストを登録"

    override fun breakBlock(e: BlockBreakEvent) {
        val putSystem = PutSystem()
        val player = e.player
        val chest = Data.playerSelectChest[player] ?: return

        if (chest.location.block.type == Material.CHEST) {
            putSystem.breakBlock(e, chest.inventory)
        } else {
            deleteChest(player)
        }
    }

    override fun rightClick(e: PlayerInteractEvent) {
        val player = e.player
        val chest = Data.playerSelectChest[player] ?: return
        if (chest.location.block.type == Material.CHEST) {
            val sound = Sound.BLOCK_ENDER_CHEST_OPEN
            player.openInventory(chest.inventory)
            player.playSound(player, sound, 1f, 1f)
        } else {
            deleteChest(player)
        }
    }

    override fun leftClick(e: PlayerInteractEvent) {
        if (e.action != Action.LEFT_CLICK_BLOCK) return
        val player = e.player
        if (!player.isSneaking) return
        val chest = (e.clickedBlock?.state as? Chest)

        if (chest != null) {
            val message = "${ChatColor.YELLOW}チェストを登録しました"
            val sound = Sound.UI_BUTTON_CLICK
            player.sendMessage(message)
            player.playSound(player, sound, 1f, 1f)
            Data.playerSelectChest[player] = chest
        } else {
            val message = "${ChatColor.RED}指定したブロックはチェストではありません"
            player.sendMessage(message)
        }
    }

    private fun deleteChest(player: Player) {
        val message = "${ChatColor.RED}チェストが確認できなかったため登録解除します"
        player.sendMessage(message)
        Data.playerSelectChest.remove(player)
    }
}
