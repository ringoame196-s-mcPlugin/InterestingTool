package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.tools.AutoChangePickaxe
import com.github.ringoame196_s_mcPlugin.tools.BoldAxe
import com.github.ringoame196_s_mcPlugin.tools.BurningPickaxe
import com.github.ringoame196_s_mcPlugin.tools.FireBallAxe
import com.github.ringoame196_s_mcPlugin.tools.InterestingTool
import com.github.ringoame196_s_mcPlugin.tools.PachinkoPickaxe
import com.github.ringoame196_s_mcPlugin.tools.PutChestAxe
import com.github.ringoame196_s_mcPlugin.tools.PutChestPickaxe
import com.github.ringoame196_s_mcPlugin.tools.PutChestShovel
import com.github.ringoame196_s_mcPlugin.tools.PutEnderChestAxe
import com.github.ringoame196_s_mcPlugin.tools.PutEnderChestPickaxe
import com.github.ringoame196_s_mcPlugin.tools.PutEnderChestShovel
import com.github.ringoame196_s_mcPlugin.tools.PutItemAxe
import com.github.ringoame196_s_mcPlugin.tools.PutItemPickaxe
import com.github.ringoame196_s_mcPlugin.tools.PutItemShovel
import com.github.ringoame196_s_mcPlugin.tools.SnowBallShovel
import org.bukkit.block.Chest
import org.bukkit.entity.Entity
import org.bukkit.entity.Player

object Data {
    val interestingToolList = listOf(
        SnowBallShovel(),
        PutItemPickaxe(),
        PutItemAxe(),
        PutItemShovel(),
        FireBallAxe(),
        BoldAxe(),
        PutEnderChestPickaxe(),
        PutEnderChestAxe(),
        PutEnderChestShovel(),
        PachinkoPickaxe(),
        AutoChangePickaxe(),
        BurningPickaxe(),
        PutChestAxe(),
        PutChestPickaxe(),
        PutChestShovel()
    )
    val InterestingToolMap = mutableMapOf<String, InterestingTool>()

    val playerSelectEntity = mutableMapOf<Player, Entity>()
    val playerSelectChest = mutableMapOf<Player, Chest>()
}
