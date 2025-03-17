package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.commands.Command
import com.github.ringoame196_s_mcPlugin.events.ToolEvents
import com.github.ringoame196_s_mcPlugin.events.ToolListGUIEvents
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    companion object {
        lateinit var plugin: Main
            private set
    }

    override fun onEnable() {
        super.onEnable()
        plugin = this

        // map登録
        for (interestingTool in Data.interestingToolList) {
            Data.InterestingToolMap[interestingTool.interToolId] = interestingTool
        }

        server.pluginManager.registerEvents(ToolEvents(), plugin)
        server.pluginManager.registerEvents(ToolListGUIEvents(), plugin)
        val command = getCommand("intertool")
        command!!.setExecutor(Command())
    }
}
