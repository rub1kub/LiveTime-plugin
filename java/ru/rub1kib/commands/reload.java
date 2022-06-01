package ru.rub1kib.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.rub1kib.core;
import ru.rub1kib.utils.messages;

public class reload implements CommandExecutor {
    private core plugin;

    public reload(core plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        try {
            Player p = (Player) sender;

            if(!p.hasPermission("lt.admin")){
                p.sendMessage(messages.format(plugin.getConfig().getString("messages.haventPerm")));
                return true;
            }

            plugin.reloadConfig();
            p.sendMessage(messages.format(plugin.getConfig().getString("messages.reloaded")));
            return true;
        } catch (Exception exc){
            sender.sendMessage(messages.format("&cЭта команда только для игроков!"));
            return true;
        }
    }
}
