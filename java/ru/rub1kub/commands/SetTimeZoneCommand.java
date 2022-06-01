package ru.rub1kub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.rub1kub.LiveTimeMain;
import ru.rub1kub.utils.MessagesUtils;

public class SetTimeZoneCommand implements CommandExecutor {
    private LiveTimeMain plugin;

    public SetTimeZoneCommand(LiveTimeMain plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player p = (Player) sender;

        if(!p.hasPermission("lt.admin")){
            p.sendMessage(MessagesUtils.format(plugin.getConfig().getString("messages.haventPerm")));
            return true;
        }

        if(args.length == 0){
            p.sendMessage(MessagesUtils.format(plugin.getConfig().getString("messages.argIsNull")));
            return true;
        }

        plugin.getConfig().set("timezone", args[0]);
        plugin.saveConfig();
        plugin.reloadConfig();
        p.sendMessage(MessagesUtils.format(plugin.getConfig().getString("messages.installed")));
        return true;
    }
}
