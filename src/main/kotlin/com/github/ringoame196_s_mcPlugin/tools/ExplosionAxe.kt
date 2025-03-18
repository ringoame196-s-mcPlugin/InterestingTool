package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.Data
import com.github.ringoame196_s_mcPlugin.events.Interface.Attack
import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import com.github.ringoame196_s_mcPlugin.managers.InterestingToolManager
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEvent

class ExplosionAxe() : InterestingTool(), Attack, RightClick {
    override val interToolId: String = "explosionAxe"
    override val itemMaterial: Material = Material.IRON_AXE
    override val itemName: String = "${ChatColor.RED}爆発斧"

    override val attackDescription: String = "ロックオン"
    override val rightDescription: String = "爆発"

    override fun attack(e: EntityDamageByEntityEvent) {
        e.isCancelled = true
        val entity = e.entity
        val player = e.damager as? Player ?: return
        val message = "${ChatColor.GOLD}ロックオン"
        val sound = Sound.UI_BUTTON_CLICK

        Data.playerSelectEntity[player] = entity
        player.sendMessage(message)
        player.playSound(player, sound, 1f, 1f)
    }

    override fun rightClick(e: PlayerInteractEvent) {
        val player = e.player
        val item = player.inventory.itemInMainHand
        val interestingToolManager = InterestingToolManager()
        val message = "${ChatColor.RED}爆発！"
        val entity = Data.playerSelectEntity[player] ?: return
        val location = entity.location
        player.sendMessage(message)
        location.world?.createExplosion(location, 4.0f)
        Data.playerSelectEntity.remove(player)
        interestingToolManager.reduceEnduranceValue(item, item.type.maxDurability.toInt())
    }
}
