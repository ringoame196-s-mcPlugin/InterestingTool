package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent

class InEnderChestShovel() : InterestingTool(), BreakBlock, RightClick {
    private val inEnderChest = InEnderChest()

    override val interToolId: String = "inEnderChestShovel"
    override val itemMaterial: Material = Material.IRON_SHOVEL
    override val itemName: String = "${ChatColor.GOLD}Inエンダーチェストシャベル"

    override val breakBlockDescription: String = inEnderChest.breakBlockDescription
    override val rightDescription: String = inEnderChest.rightDescription

    override fun breakBlock(e: BlockBreakEvent) {
        inEnderChest.breakBlock(e)
    }

    override fun rightClick(e: PlayerInteractEvent) {
        inEnderChest.rightClick(e)
    }
}
