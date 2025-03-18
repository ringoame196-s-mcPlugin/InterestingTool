package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.Attack
import com.github.ringoame196_s_mcPlugin.events.Interface.BlockDamage
import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import com.github.ringoame196_s_mcPlugin.events.Interface.LeftClick
import com.github.ringoame196_s_mcPlugin.events.Interface.RightClick
import com.github.ringoame196_s_mcPlugin.managers.InterestingToolManager
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

abstract class InterestingTool {
    private val interestingToolManager = InterestingToolManager()

    abstract val interToolId: String
    abstract val itemMaterial: Material
    abstract val itemName: String
    fun item(): ItemStack {
        return interestingToolManager.makeItem(
            itemMaterial,
            itemName,
            makeLore(),
            interToolId
        )
    }

    private fun makeLore(): List<String> {
        val lore = mutableListOf<String>("[機能]")
        if (this is Attack) lore.add("攻撃 - ${this.attackDescription}")
        if (this is BreakBlock) lore.add("破壊 - ${this.breakBlockDescription}")
        if (this is BlockDamage) lore.add("破壊 - ${this.breakDamageDescription}")
        if (this is LeftClick) lore.add("左 - ${this.leftDescription}")
        if (this is RightClick) lore.add("右 - ${this.rightDescription}")
        return lore
    }
}
