package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.LeftClick
import com.github.ringoame196_s_mcPlugin.managers.InterestingToolManager
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Fireball
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class FireBallAxe() : InterestingTool(), LeftClick {
    override val interToolId: String = "fireBallAxe"
    override val itemMaterial: Material = Material.IRON_AXE
    override val itemName: String = "${ChatColor.GOLD}ファイヤーボール斧"

    override val leftDescription: String = "ファイヤーボールを発射"

    override fun leftClick(e: PlayerInteractEvent) {
        if (e.action != Action.LEFT_CLICK_AIR) return
        val interestingToolManager = InterestingToolManager()
        val player = e.player
        val sound = Sound.ENTITY_ARROW_SHOOT
        val fireBall = player.launchProjectile(Fireball::class.java)
        val speed = 2
        val reduceValue = 3
        fireBall.velocity = fireBall.velocity.multiply(speed) // スピードを2倍に
        player.playSound(player, sound, 1f, 1f)
        interestingToolManager.reduceEnduranceValue(e.item ?: return, reduceValue)
    }
}
