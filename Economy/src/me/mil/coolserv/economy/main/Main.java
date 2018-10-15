package me.mil.coolserv.economy.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin implements Listener {

    public static Main i;




    public void onEnable(){
            i = this;
            registerCommands();

        SLAPI.loadBalances();

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public void onDisable(){
        SLAPI.saveBalances();
    }


    void registerCommands(){
        this.getCommand("economy").setExecutor((CommandExecutor) new EcoCommand());
        this.getCommand("balance").setExecutor((CommandExecutor) new BalanceCommand());
    }




    //"EcoMain"



    public static HashMap<UUID, Float> bal = new HashMap<>();
            public static char currency = '$';

            long l = 0L;

            public static void setBalance(UUID p, float amount){

                if(hasAccount(p)){
                    bal.replace(p, amount);
                }
                else{
                    bal.put(p, amount);
        }
        //  EconomyYML.saveEconomy();
        // SLAPI.loadBalances();
        //  EconomyYML.saveEconomy();
        SLAPI.saveBalances();



    }

    public static void addBalance(UUID p, float amount){
        setBalance(p, bal.get(p) + amount);
    }

    public static float getBalance(UUID p){



        return Float.parseFloat(String.format("%.2f", bal.get(p)));

    }

    public static void removeBalance(UUID p, float amount){
        setBalance(p, bal.get(p) - amount);
    }

    public static void doPurchase(UUID p, float amount){
        float newbal = bal.get(p) - amount;
        if(newbal < 0){
            Main.c(p, "&cYou do not have enough money to do that!");
            return;
        }else{
            Main.c(p, "&aYour new balance is &" + EcoCommand.ch + currency + getBalanceString(p) + "&a!");
            setBalance(p, bal.get(p) - amount);
        }
    }

    public static String getBalanceString(UUID p){



        //return String.format("%.2f", bal.get(p));
     //   Bukkit.getServer().getConsoleSender().sendMessage("" + bal.get(p));

        return String.format("%.2f", bal.get(p));



    }



    public static boolean hasAccount(UUID p){
        return bal.containsKey(p);
    }

    public static HashMap<UUID, Float> getBalanceMap(){
        return bal;
    }




































    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(!bal.containsKey(e.getPlayer().getUniqueId())){
            setBalance(e.getPlayer().getUniqueId(), 100);
        }

    }




    //Misc Methods
    public static void c(UUID ss, String txt){
        CommandSender s = Bukkit.getPlayer(ss);
        s.sendMessage(rc(txt));
    }
    public static void c(CommandSender s, String txt){
        s.sendMessage(rc(txt));
    }

    public static String rc(String txt){
        return ChatColor.translateAlternateColorCodes('&', txt);
    }

    public static void msgToConsole(String msg){
        Bukkit.getServer().getConsoleSender().sendMessage(rc(msg));
    }

    public static String error(String msg){
        return rc("Error: " + msg);
    }

}
