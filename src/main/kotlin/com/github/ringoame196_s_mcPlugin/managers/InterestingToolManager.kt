package com.github.ringoame196_s_mcPlugin.managers

import com.github.ringoame196_s_mcPlugin.Main
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class InterestingToolManager() {
    private val plugin = Main.Companion.plugin
    private val key = NamespacedKey(plugin, "interToolId")

    fun makeItem(itemType: Material, itemName: String, lore: List<String>, interToolId: String): ItemStack {
        val item = ItemStack(itemType)
        val meta = item.itemMeta ?: return item
        meta.setDisplayName(itemName)
        meta.lore = lore
        meta.persistentDataContainer.set(key, PersistentDataType.STRING, interToolId) // NBTデータを保存
        item.itemMeta = meta
        return item
    }
}
