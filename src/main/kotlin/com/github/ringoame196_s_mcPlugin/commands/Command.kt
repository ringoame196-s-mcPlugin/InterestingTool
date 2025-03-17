package com.github.ringoame196_s_mcPlugin.commands

import com.github.ringoame196_s_mcPlugin.managers.InterestingToolListGUIManager
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class Command : CommandExecutor, TabCompleter {
    private val interestingToolListGUIManager = InterestingToolListGUIManager()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            val message = "${ChatColor.RED}このコマンドはプレイヤーのみ実行可能です"
            sender.sendMessage(message)
            return true
        }

        val gui = interestingToolListGUIManager.makeGUI()
        val sound = Sound.BLOCK_CHEST_OPEN
        sender.openInventory(gui)
        sender.playSound(sender, sound, 1f, 1f)

        return true
    }

    override fun onTabComplete(commandSender: CommandSender, command: Command, label: String, args: Array<out String>): MutableList<String>? {
        return null
    }
}
