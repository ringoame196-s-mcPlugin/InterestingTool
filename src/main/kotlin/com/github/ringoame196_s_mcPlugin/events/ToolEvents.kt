package com.github.ringoame196_s_mcPlugin.events

import com.github.ringoame196_s_mcPlugin.Data
import com.github.ringoame196_s_mcPlugin.events.Interface.LeftClick
import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import com.github.ringoame196_s_mcPlugin.managers.InterestingToolManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

class ToolEvents : Listener {
    private val interestingToolManager = InterestingToolManager()

    private fun acquisitionInterToolId(item: ItemStack): String? {
        return interestingToolManager.acquisitionInterToolId(item)
    }

    @EventHandler
    fun onRightClick(e: PlayerInteractEvent) {
        if (e.action != Action.RIGHT_CLICK_AIR && e.action != Action.RIGHT_CLICK_BLOCK) return
        val interToolId = acquisitionInterToolId(e.item ?: return) ?: return
        val interestingTool = Data.InterestingToolMap[interToolId] ?: return
        if (interestingTool !is RightClick) return
        interestingTool.rightClick(e)
    }

    @EventHandler
    fun onLeftClick(e: PlayerInteractEvent) {
        if (e.action != Action.RIGHT_CLICK_AIR && e.action != Action.RIGHT_CLICK_BLOCK) return
        val interToolId = acquisitionInterToolId(e.item ?: return)
        val interestingTool = Data.InterestingToolMap[interToolId] ?: return
        if (interestingTool !is LeftClick) return
        interestingTool.leftClick(e)
    }
}
