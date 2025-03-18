package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import com.github.ringoame196_s_mcPlugin.tools.systems.PutEnderChest
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent

class PutEnderChestAxe() : InterestingTool(), BreakBlock, RightClick {
    private val putEnderChest = PutEnderChest()

    override val interToolId: String = "putEnderChestAxe"
    override val itemMaterial: Material = Material.IRON_AXE
    override val itemName: String = "${ChatColor.GOLD}Putエンダーチェスト斧"

    override val breakBlockDescription: String = putEnderChest.breakBlockDescription
    override val rightDescription: String = putEnderChest.rightDescription

    override fun breakBlock(e: BlockBreakEvent) {
        putEnderChest.breakBlock(e)
    }

    override fun rightClick(e: PlayerInteractEvent) {
        putEnderChest.rightClick(e)
    }
}
