package com.github.ringoame196_s_mcPlugin.events.Interface

import org.bukkit.event.entity.EntityDamageByEntityEvent

interface Attack {
    val attackDescription: String
    fun attack(e: EntityDamageByEntityEvent)
}
