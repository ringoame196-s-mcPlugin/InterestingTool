package com.github.ringoame196_s_mcPlugin.managers

import com.github.ringoame196_s_mcPlugin.Data
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory

class InterestingToolListGUIManager() {
    val guiName = "${ChatColor.BLUE}ツール一覧"

    fun makeGUI(): Inventory {
        val interestingToolList = Data.interestingToolList
        val guiSize = (interestingToolList.size / 9 + 1) * 9
        val gui = Bukkit.createInventory(null, guiSize, guiName)

        for (tool in interestingToolList) {
            gui.addItem(tool.item())
        }

        return gui
    }

    fun click(e: InventoryClickEvent) {
        val gui = e.clickedInventory
        val player = e.whoClicked as? Player ?: return
        if (gui == player.inventory) return
        val item = e.currentItem
        val sound = Sound.UI_BUTTON_CLICK
        e.isCancelled = true
        player.inventory.addItem(item)
        player.playSound(player, sound, 1f, 1f)
    }
}
