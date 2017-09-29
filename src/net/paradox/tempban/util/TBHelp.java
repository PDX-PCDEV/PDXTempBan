package net.paradox.tempban.util;

import org.bukkit.ChatColor;

import java.util.ArrayList;

/**
 * Created by Minimal on 12/09/2017.
 */
public class TBHelp
{
    public static ArrayList<String> lore = new ArrayList();
    public static ArrayList<String> permaLore = new ArrayList();
    public static long month;
    public static long permaBan;

    public String getReason(Reasons r)
    {
        String reason = null;
        switch(r)
        {
            case IP_TEMP:
                reason = "You are temporarily banned by IP.";
                break;
            case IP_PERM:
                reason = "You are permanently banned by IP.";
                break;
            case HACK_AIM:
                reason = "You have been banned for using Aimbot. Your ban lasts 3 months.";
                break;
            case HACK_AKB:
                reason = "You have been banned for using AntiKnockBack. Your ban lasts 3 months";
                break;
            case HACK_AURA:
                reason = "You have been banned for using KillAura. Your ban lasts 3 months.";
                break;
            case HACK_FLY_SPEED:
                reason = "You have been banned for flying/speedhacking. Your ban lasts 3 months.";
                break;
            case HACK_LAG:
                reason = "You have been banned for using a lag switch. Your ban lasts 3 months.";
                break;
            case HACK_NOFALL:
                reason = "You have been banned for using NoFall. Your ban lasts 3 months";
                break;
            case HACK_REACH:
                reason = "You have been banned for using Reach. Your ban lasts 3 months.";
                break;
            case HACK_REGEN:
                reason = "You have been banned for using regen cheats or health modification. Your ban lasts 3 months.";
                break;
            case HACK_TP:
                reason = "You have been banned for teleporting. Your ban lasts 3 months.";
                break;
            case HACK_XRAY:
                reason = "You have been banned for X-Ray. Your ban lasts 3 months.";
                break;
            case OTHER_COMPROMISED_ACC:
                reason = "You have been banned for using a possibly compromised account. Your ban lasts 6 months.";
                break;
            case OTHER_GRIEFING:
                reason = "You have been banned for griefing. Your ban last 3 months.";
                break;
            case OTHER_INAPPROPIATE_NAME_SKIN:
                reason = "You have been banned for your name/skin being considered inappropriate. Your ban lasts a month.";
                break;
            case OTHER_PERM:
                reason = "You are permanently banned.";
                break;
        }

        return reason;
    }

    public TBHelp() {
        month = (long)(2.592D * Math.pow(10.0D, 9.0D));
        permaBan = (long)(1.657532D * Math.pow(10.0D, 16.0D));
    }

    public static ArrayList<String> setBanTime(int months) {
        lore.clear();
        lore.add("" + ChatColor.BOLD + ChatColor.DARK_PURPLE + "Ban Time: " + ChatColor.BOLD + ChatColor.GRAY + months + " MONTHS");
        return lore;
    }

    public static ArrayList<String> getPermaLore() {
        permaLore.clear();
        permaLore.add("" + ChatColor.BOLD + ChatColor.DARK_PURPLE + "Ban Time: " + ChatColor.BOLD + ChatColor.GRAY + "PERMANENT");
        permaLore.add("" + ChatColor.BOLD + ChatColor.RED + "ONLY IN VERY EXTREME SITUATIONS!");
        return permaLore;
    }
}
