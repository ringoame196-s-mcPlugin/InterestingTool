package com.github.ringoame196_s_mcPlugin.tools.systems

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import org.bukkit.event.block.BlockBreakEvent

class PutItem : BreakBlock {
    override val breakBlockDescription: String = "掘ったアイテムをインベントリに"

    override fun breakBlock(e: BlockBreakEvent) {
        val putSystem = PutSystem()
        val player = e.player
        putSystem.breakBlock(e, player.inventory)
    }
}
