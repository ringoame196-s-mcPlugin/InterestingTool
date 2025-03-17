package com.github.ringoame196_s_mcPlugin.events.Interface

import org.bukkit.event.block.BlockBreakEvent

interface BreakBlock {
    val breakBlockDescription: String
    fun breakBlock(e: BlockBreakEvent)
}
