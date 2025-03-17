package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.tools.BoldAxe
import com.github.ringoame196_s_mcPlugin.tools.FireBallAxe
import com.github.ringoame196_s_mcPlugin.tools.InEnderChestAxe
import com.github.ringoame196_s_mcPlugin.tools.InEnderChestPickaxe
import com.github.ringoame196_s_mcPlugin.tools.InEnderChestShovel
import com.github.ringoame196_s_mcPlugin.tools.InItemAxe
import com.github.ringoame196_s_mcPlugin.tools.InItemPickaxe
import com.github.ringoame196_s_mcPlugin.tools.InItemShovel
import com.github.ringoame196_s_mcPlugin.tools.InterestingTool
import com.github.ringoame196_s_mcPlugin.tools.SnowBallShovel

object Data {
    val interestingToolList = listOf(
        SnowBallShovel(),
        InItemPickaxe(),
        InItemAxe(),
        InItemShovel(),
        FireBallAxe(),
        BoldAxe(),
        InEnderChestPickaxe(),
        InEnderChestAxe(),
        InEnderChestShovel(),
    )
    val InterestingToolMap = mutableMapOf<String, InterestingTool>()
}
