package com.github.ringoame196_s_mcPlugin.events

import com.github.ringoame196_s_mcPlugin.managers.InterestingToolListGUIManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class ToolListGUIEvents : Listener {
    private val interestingToolListGUIManager = InterestingToolListGUIManager()

    @EventHandler
    fun onClick(e: InventoryClickEvent) {
        val gui = e.view
        val guiName = gui.title
        if (guiName != interestingToolListGUIManager.guiName) return
        interestingToolListGUIManager.click(e)
    }
}
