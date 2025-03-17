package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.tools.InItemPickaxe
import com.github.ringoame196_s_mcPlugin.tools.InterestingTool
import com.github.ringoame196_s_mcPlugin.tools.SnowBallShovel

object Data {
    val interestingToolList = listOf(
        SnowBallShovel(),
        InItemPickaxe()
    )
    val InterestingToolMap = mutableMapOf<String, InterestingTool>()
}
