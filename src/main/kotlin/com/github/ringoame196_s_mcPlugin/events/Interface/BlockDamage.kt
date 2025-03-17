package com.github.ringoame196_s_mcPlugin.events.Interface

import org.bukkit.event.block.BlockDamageEvent

interface BlockDamage {
    val breakDamageDescription: String
    fun blockDamage(e: BlockDamageEvent)
}
