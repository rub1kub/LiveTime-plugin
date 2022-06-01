package ru.rub1kub.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import ru.rub1kub.LiveTimeMain;

public class MessagesUtils {
    private LiveTimeMain plugin;

    public MessagesUtils(LiveTimeMain plugin) {
        this.plugin = plugin;
    }

    public static void sendActionbar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(format(message)));
    }

    public static String format(String arg) {
        return ChatColor.translateAlternateColorCodes('&', arg);
    }
}
