package com.github.ringoame196_s_mcPlugin.events.Interface

import org.bukkit.event.player.PlayerInteractEvent

interface RightClick {
    val rightDescription: String
    fun rightClick(e: PlayerInteractEvent)
}
