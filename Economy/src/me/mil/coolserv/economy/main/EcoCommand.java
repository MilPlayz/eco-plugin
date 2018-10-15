package me.mil.coolserv.economy.main;

import com.avaje.ebeaninternal.server.core.Message;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoCommand implements CommandExecutor {

    public static char ch = 'e';



    public boolean onCommand(CommandSender s, Command cmd, String cmdLabel, String[] args) {

    if(args.length == 0){
        s.sendMessage(Messages.ECONOMY_HELP());
    }

    if(args.length == 1){

        if(args[0].equalsIgnoreCase("balance") || args[0].equalsIgnoreCase("bal")){
                if(s instanceof Player){
                Player p = (Player) s;
                Main.c(p, "&a" + "Your balance is currently &" + ch + Main.getBalanceString(p.getUniqueId()));

            }else{
                s.sendMessage(Messages.ECONOMY_HELP());
            }

        }



    }


    if(args.length == 2){
        if(args[0].equalsIgnoreCase("balance") || args[0].equalsIgnoreCase("bal")){
            @SuppressWarnings("deprecation")
            OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);

                if(!(Main.hasAccount(target.getUniqueId()))){
                    Main.c(s, "The player " + target.getName() + " does not have a bank account!");
                }else{
                    Main.c(s, "&" + ch + target.getName() + "'s&a balance is currently &" + ch + Main.getBalanceString(target.getUniqueId()));
                }


        }
    }


        return true;
    }


    }
