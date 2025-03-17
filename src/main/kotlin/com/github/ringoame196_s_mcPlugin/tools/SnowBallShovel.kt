package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import org.bukkit.Material
import org.bukkit.entity.Snowball
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class SnowBallShovel() : InterestingTool(), RightClick {
    override val interToolId: String = "snowBallShovel"
    override val itemMaterial: Material = Material.IRON_SHOVEL
    override val itemName: String = "雪玉シャベル"
    override val lore: List<String> = listOf("右クリックで雪玉発射")

    override fun rightClick(e: PlayerInteractEvent) {
        if (e.action != Action.RIGHT_CLICK_AIR) return
        val player = e.player
        val snowball = player.launchProjectile(Snowball::class.java)
        snowball.velocity = snowball.velocity.multiply(2) // スピードを2倍に
    }
}
