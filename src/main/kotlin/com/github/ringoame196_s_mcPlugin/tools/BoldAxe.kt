package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.Attack
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.entity.EntityDamageByEntityEvent

class BoldAxe() : InterestingTool(), Attack {
    override val interToolId: String = "boldAxe"
    override val itemMaterial: Material = Material.IRON_AXE
    override val itemName: String = "${ChatColor.YELLOW}雷斧"

    override val attackDescription: String = "雷を落とす"

    override fun attack(e: EntityDamageByEntityEvent) {
        val entity = e.entity
        val world = entity.world
        world.strikeLightning(entity.location)
    }
}
