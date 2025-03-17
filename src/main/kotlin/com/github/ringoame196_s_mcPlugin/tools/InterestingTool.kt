package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.managers.InterestingToolManager
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

abstract class InterestingTool {
    private val interestingToolManager = InterestingToolManager()

    abstract val interToolId: String
    abstract val itemMaterial: Material
    abstract val itemName: String
    abstract val lore: List<String>
    fun item(): ItemStack {
        return interestingToolManager.makeItem(
            itemMaterial,
            itemName,
            lore,
            interToolId
        )
    }
}
