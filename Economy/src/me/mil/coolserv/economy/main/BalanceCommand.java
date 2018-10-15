package me.mil.coolserv.economy.main;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String cmdLabel, String[] args) {

        if(args.length == 0){

                if(s instanceof Player){
                    Player p = (Player) s;
                    Main.c(p, "&a" + "Your balance is currently &" + EcoCommand.ch + Main.getBalanceString(p.getUniqueId()));

            }



        }


        if(args.length == 1){

                @SuppressWarnings("deprecation")
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

                if(!(Main.hasAccount(target.getUniqueId()))){
                    Main.c(s, "The player " + target.getName() + " does not have a bank account!");
                }else{
                    Main.c(s, "&" + EcoCommand.ch + target.getName() + "'s&a balance is currently &" + EcoCommand.ch + Main.getBalanceString(target.getUniqueId()));
                }



        }

        return true;
    }

}
