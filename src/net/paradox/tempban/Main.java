package net.paradox.tempban;

import net.paradox.tempban.inv.MainMenu;
import net.paradox.tempban.listeners.TBListener;
import net.paradox.tempban.util.Reasons;
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
    public static Player target;
    BanManagement bm = new BanManagement();

    public void onEnable() {
        new TBListener(this);
        this.getLogger().info("TempBan has been enabled.");
    }

    public void onDisable() {
        this.getLogger().info("TempBan has been disabled.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("tempban") && sender instanceof Player) {
            Player player = (Player)sender;
            if(player.isOp()) {
                if(args[0] == null) {
                    player.sendMessage("Not enough arguments.");
                    return false;
                }

                target = Bukkit.getPlayer(args[0]);
                player.openInventory(MainMenu.mainMenu);
                return true;
            }

            player.sendMessage("You\'re not an staff member.");
        }

        return false;
    }
}
