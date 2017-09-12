package net.paradox.tempban.listeners;

import net.paradox.tempban.Main;
import org.bukkit.event.Listener;

/**
 * Created by Minimal on 12/09/2017.
 */
public class TBListener implements Listener
{
    public TBListener(Main plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
}
