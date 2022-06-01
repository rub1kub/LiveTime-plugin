package ru.rub1kib.listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import ru.rub1kib.core;
import ru.rub1kib.utils.messages;
import ru.rub1kib.utils.times;

import java.util.*;
import java.text.*;

public class listener {
    public static void interval(){
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(core.getInstance(), () -> {
            Date dateNow = new Date();
            DateFormat readFormat = new SimpleDateFormat( "HH:mm");
            readFormat.setTimeZone(TimeZone.getTimeZone(core.getInstance().getConfig().getString("timezone")));
            String[] date = readFormat.format(dateNow).split(":");
            int h = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            for(String w : core.getInstance().getConfig().getStringList("worlds")){
                if(Bukkit.getWorld(w) == null){
                    core.console.sendMessage(messages.format("&cUnknown world!&8/&cНеизвестный мир\n&7Проверьте название мира!"));
                    continue;
                }
                World world = Bukkit.getWorld(w);
                world.setFullTime(times.getTime(h) + m*10);
            }
        }, 0, 20);
    }
}
