package ru.rub1kub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.rub1kub.LiveTimeMain;
import ru.rub1kub.utils.MessagesUtils;

public class ReloadCommand implements CommandExecutor {
    private LiveTimeMain plugin;

    public ReloadCommand(LiveTimeMain plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        try {
            Player p = (Player) sender;

            if(!p.hasPermission("lt.admin")){
                p.sendMessage(MessagesUtils.format(plugin.getConfig().getString("messages.haventPerm")));
                return true;
            }

            plugin.reloadConfig();
            p.sendMessage(MessagesUtils.format(plugin.getConfig().getString("messages.reloaded")));
            return true;
        } catch (Exception exc){
            sender.sendMessage(MessagesUtils.format("&cЭта команда только для игроков!"));
            return true;
        }
    }
}
