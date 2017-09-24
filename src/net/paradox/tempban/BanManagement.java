package net.paradox.tempban;

import net.paradox.tempban.util.Reasons;
import net.paradox.tempban.util.TBHelp;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Date;

/**
 * Created by Minimal on 12/09/2017.
 */
public class BanManagement
{
    TBHelp help = new TBHelp();

    public void addBan(Player source, Player target, long time, Reasons reason)
    {
        long current = System.currentTimeMillis();
        long banTime = current + time;
        String foundReason = help.getReason(reason);
        Bukkit.getBanList(Type.NAME).addBan(target.getName(), foundReason, new Date(banTime), source.getName());
        target.kickPlayer(foundReason);
    }

    public void removeBan(Player target)
    {
        Bukkit.getBanList(Type.NAME).pardon(target.getName());
    }
}
