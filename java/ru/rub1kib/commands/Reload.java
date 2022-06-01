package ru.rub1kib.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.rub1kib.LiveTimeMain;
import ru.rub1kib.utils.Messages;

public class Reload implements CommandExecutor {
    private LiveTimeMain plugin;

    public Reload(LiveTimeMain plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        try {
            Player p = (Player) sender;

            if(!p.hasPermission("lt.admin")){
                p.sendMessage(Messages.format(plugin.getConfig().getString("messages.haventPerm")));
                return true;
            }

            plugin.reloadConfig();
            p.sendMessage(Messages.format(plugin.getConfig().getString("messages.reloaded")));
            return true;
        } catch (Exception exc){
            sender.sendMessage(Messages.format("&cЭта команда только для игроков!"));
            return true;
        }
    }
}
