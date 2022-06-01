package ru.rub1kib;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import ru.rub1kib.commands.reload;
import ru.rub1kib.commands.setTimezone;
import ru.rub1kib.listeners.listener;
import ru.rub1kib.utils.messages;

public final class core extends JavaPlugin {

    private static core instance;
    public static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    String version = getDescription().getVersion();
    String name = getDescription().getName();

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        this.console.sendMessage(this.getMessageColor("\n \n&8[]=====[&aEnabling " + this.getPluginName() + "&8]=====[]\n&8| &cInformation:\n&8|   &cName: &7" + this.getPluginName() + "\n&8|   &cDeveloper: &7rubikub\n&8|   &cVersion: &7" + this.getVersion() + "\n&8[]======================================[]&r\n "));
        listener.interval();
        getCommand("liveTimeReload").setExecutor(new reload(this));
        getCommand("setTimeZone").setExecutor(new setTimezone(this));
        for(String w : core.getInstance().getConfig().getStringList("worlds")){
            if(Bukkit.getWorld(w) == null){
                core.console.sendMessage(messages.format("&cUnknown timezone!&8/&cНеизвестный временной пояск!\n&7Check timezones.yml!&8/&7Посмотрите в timezones.yml"));
                continue;
            }
            World world = Bukkit.getWorld(w);
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        }
    }

    @Override
    public void onDisable() {
        this.console.sendMessage(this.getMessageColor("\n \n&8[]=====[&aDisabling " + this.getPluginName() + "&8]=====[]\n&8| &cInformation:\n&8|   &cName: &7 " + this.getPluginName() + "\n&8|   &cDeveloper: &7R_u_B_i_K\n&8|   &cVersion: &7" + this.getVersion() + "\n&8[]======================================[]&r\n "));

    }

    public static core getInstance() {
        return instance;
    }

    public String getPluginName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public String getMessageColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
