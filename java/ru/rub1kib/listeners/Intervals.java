package ru.rub1kib.listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import ru.rub1kib.LiveTimeMain;
import ru.rub1kib.utils.Messages;
import ru.rub1kib.utils.Times;

import java.util.*;
import java.text.*;

public class Intervals {
    public static void interval(){
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(LiveTimeMain.getInstance(), () -> {
            Date dateNow = new Date();
            DateFormat readFormat = new SimpleDateFormat( "HH:mm");
            readFormat.setTimeZone(TimeZone.getTimeZone(LiveTimeMain.getInstance().getConfig().getString("timezone")));
            String[] date = readFormat.format(dateNow).split(":");
            int h = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            for(String w : LiveTimeMain.getInstance().getConfig().getStringList("worlds")){
                if(Bukkit.getWorld(w) == null){
                    LiveTimeMain.console.sendMessage(Messages.format("&cUnknown world!&8/&cНеизвестный мир\n&7Проверьте название мира!"));
                    continue;
                }
                World world = Bukkit.getWorld(w);
                world.setFullTime(Times.getTime(h) + m*10);
            }
        }, 0, 20);
    }
}
