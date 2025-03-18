package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import com.github.ringoame196_s_mcPlugin.managers.InterestingToolManager
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Snowball
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class SnowBallShovel() : InterestingTool(), RightClick {
    override val interToolId: String = "snowBallShovel"
    override val itemMaterial: Material = Material.IRON_SHOVEL
    override val itemName: String = "雪玉シャベル"

    override val rightDescription: String = "雪玉発射"

    override fun rightClick(e: PlayerInteractEvent) {
        if (e.action != Action.RIGHT_CLICK_AIR) return
        val interestingToolManager = InterestingToolManager()
        val player = e.player
        val sound = Sound.ENTITY_ARROW_SHOOT
        val snowball = player.launchProjectile(Snowball::class.java)
        val speed = 2
        val reduceValue = 1
        snowball.velocity = snowball.velocity.multiply(speed) // スピードを2倍に
        player.playSound(player, sound, 1f, 1f)
        interestingToolManager.reduceEnduranceValue(e.item ?: return, reduceValue)
    }
}
