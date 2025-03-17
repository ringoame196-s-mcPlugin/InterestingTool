package com.github.ringoame196_s_mcPlugin.events.Interface

import org.bukkit.event.player.PlayerInteractEvent

interface LeftClick {
    val leftDescription: String
    fun leftClick(e: PlayerInteractEvent)
}
