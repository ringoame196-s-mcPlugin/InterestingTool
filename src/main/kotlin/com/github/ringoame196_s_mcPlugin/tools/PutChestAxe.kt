package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import com.github.ringoame196_s_mcPlugin.events.Interface.LeftClick
import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import com.github.ringoame196_s_mcPlugin.tools.systems.PutChest
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent

class PutChestAxe() : InterestingTool(), BreakBlock, RightClick, LeftClick {
    private val putChest = PutChest()

    override val interToolId: String = "putChestAxe"
    override val itemMaterial: Material = Material.IRON_AXE
    override val itemName: String = "${ChatColor.GOLD}Putチェスト斧"
    override val rightDescription: String = putChest.rightDescription
    override val leftDescription: String = putChest.leftDescription

    override val breakBlockDescription: String = putChest.breakBlockDescription

    override fun breakBlock(e: BlockBreakEvent) {
        putChest.breakBlock(e)
    }

    override fun rightClick(e: PlayerInteractEvent) {
        putChest.rightClick(e)
    }

    override fun leftClick(e: PlayerInteractEvent) {
        putChest.leftClick(e)
    }
}
