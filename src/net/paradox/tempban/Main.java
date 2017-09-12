package net.paradox.tempban;

import net.paradox.tempban.listeners.TBListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Minimal on 12/09/2017.
 */
public class Main extends JavaPlugin
{
    BanManagement bm = new BanManagement();

    @Override
    public void onEnable()
    {
        new TBListener(this);
    }

    @Override
    public void onDisable()
    {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(command.getName().equalsIgnoreCase("addban") && sender instanceof Player)
        {
            Player source = (Player) sender;
            Player target = Bukkit.getPlayer(args[0]);
            bm.addBan(source, target, 100000L);
        }

        return false;
    }
}
