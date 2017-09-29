package net.paradox.tempban.listeners;

import net.paradox.tempban.BanManagement;
import net.paradox.tempban.Main;
import net.paradox.tempban.inv.CombatMenu;
import net.paradox.tempban.inv.MainMenu;
import net.paradox.tempban.inv.PlayerMenu;
import net.paradox.tempban.util.Reasons;
import net.paradox.tempban.util.TBHelp;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Date;

import static net.paradox.tempban.util.TBHelp.month;
import static net.paradox.tempban.util.TBHelp.permaBan;

/**
 * Created by Minimal on 12/09/2017.
 */
public class TBListener implements Listener
{
    public BanManagement bm;

    public TBListener(Main plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void MainMenu(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        ItemStack click = e.getCurrentItem();
        Inventory inv = e.getInventory();
        if(inv.equals(MainMenu.mainMenu)) {
            if(click != null) {
                if(click.getType() == Material.BOW) {
                    e.setCancelled(true);
                    player.closeInventory();
                    player.openInventory(CombatMenu.combatMenu);
                } else if(click.getType() == Material.BOOK_AND_QUILL) {
                    e.setCancelled(true);
                    player.closeInventory();
                    player.openInventory(PlayerMenu.playerMenu);
                } else if(click.getType() == Material.STRUCTURE_VOID) {
                    e.setCancelled(true);
                    player.closeInventory();
                    bm.addBan(player, Main.target, month * 6, Reasons.OTHER_COMPROMISED_ACC);
                } else if(click.getType() == Material.NAME_TAG) {
                    e.setCancelled(true);
                    player.closeInventory();
                    bm.addBan(player, Main.target, month, Reasons.OTHER_INAPPROPIATE_NAME_SKIN);
                } else if(click.getType() == Material.BARRIER) {
                    e.setCancelled(true);
                    player.closeInventory();
                    bm.addBan(player, Main.target, permaBan, Reasons.OTHER_PERM);
                }
            } else {
                player.closeInventory();
            }
        }

    }

    @EventHandler
    public void CombatMenu(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        ItemStack click = e.getCurrentItem();
        Inventory inv = e.getInventory();
        if(inv.equals(CombatMenu.combatMenu)) {
            if(click != null) {
                if(click.getType() == Material.IRON_SWORD) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "Use your inner aura, and kill properly. Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for using KillAura. Your ban lasts 3 months.");
                } else if(click.getType() == Material.WEB) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "Think you\'ve got something stuck to the base of your shoe. Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for using AntiKnockBack. Your ban lasts 3 months.");
                } else if(click.getType() == Material.BOW) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "Only the chosen one could bend arrows like you. Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for using Aimbot. Your ban lasts 3 months.");
                } else if(click.getType() == Material.VINE) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "Try climbing back up onto that platform. Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for using NoFall. Your ban lasts 3 months.");
                } else if(click.getType() == Material.LEASH) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "We all make it sooner or later. Better get going, Six, they\'re gonna need you down there. Listen, Reach has been good to me. Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for using Reach. Your ban lasts 3 months.");
                } else if(click.getType() == Material.GOLDEN_APPLE) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "Huh, never seen a golden apple work that well. Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for using regen cheats or health modification. Your ban lasts 3 months.");
                } else if(click.getType() == Material.ARROW) {
                    e.setCancelled(true);
                    player.closeInventory();
                    player.openInventory(MainMenu.mainMenu);
                }
            } else {
                player.closeInventory();
            }
        }

    }

    @EventHandler
    public void PlayerMenu(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        ItemStack click = e.getCurrentItem();
        Inventory inv = e.getInventory();
        if(inv.equals(PlayerMenu.playerMenu)) {
            if(click != null) {
                if(click.getType() == Material.EMERALD) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "Wow, those x-ray goggles were a rip-off. Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for X-Ray. Your ban lasts 3 months.");
                } else if(click.getType() == Material.FEATHER) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "You believed you could fly and run so fast. Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for flying/speedhacking. Your ban lasts 3 months.");
                } else if(click.getType() == Material.LEVER) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "Oh no, I'm lagging!. Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for using a lag switch. Your ban lasts 3 months.");
                } else if(click.getType() == Material.ENDER_PEARL) {
                    e.setCancelled(true);
                    player.closeInventory();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(Main.target.getName(), "That teleport was so far, it\'s out of this world! Your ban lasts 3 months.", new Date(System.currentTimeMillis() + month * 3L), "Dank Memes");
                    Main.target.kickPlayer(ChatColor.BOLD + "You have been banned for teleporting. Your ban lasts 3 months.");
                } else if(click.getType() == Material.ARROW) {
                    e.setCancelled(true);
                    player.closeInventory();
                    player.openInventory(MainMenu.mainMenu);
                }
            } else {
                player.closeInventory();
            }
        }

    }
}
