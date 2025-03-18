package com.github.ringoame196_s_mcPlugin.tools

import com.github.ringoame196_s_mcPlugin.events.Interface.BreakBlock
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.FurnaceRecipe
import org.bukkit.inventory.ItemStack

class BurningPickaxe() : InterestingTool(), BreakBlock {
    override val interToolId: String = "burningPickaxe"
    override val itemMaterial: Material = Material.IRON_PICKAXE
    override val itemName: String = "${ChatColor.BLUE}かまどピッケル"

    override val breakBlockDescription: String = "焼けた状態でアイテムをドロップ"
    override fun breakBlock(e: BlockBreakEvent) {
        val block = e.block
        val location = block.location
        val dropItems = block.drops
        e.isDropItems = false

        for (item in dropItems) {
            val furnaceItem = acquisitionFurnaceItem(item)
            location.world?.dropItem(location, furnaceItem)
        }
    }

    private fun acquisitionFurnaceItem(inputItem: ItemStack): ItemStack {
        val recipes = Bukkit.getServer().recipeIterator()
        while (recipes.hasNext()) {
            val recipe = recipes.next()
            if (recipe is FurnaceRecipe) {
                if (recipe.input.type == inputItem.type) return recipe.result
            }
        }
        return inputItem
    }
}
