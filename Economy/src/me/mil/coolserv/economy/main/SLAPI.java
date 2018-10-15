package me.mil.coolserv.economy.main;

import java.util.UUID;

public class SLAPI {


    private static Main p = Main.i;


    public static void saveBalances(){
        for(UUID u : Main.getBalanceMap().keySet()){
            //  p.getConfig().set("balance."+u.toString(), EcoMain.getBalanceMap().get(u));
            EconomyYML.getEconomyPlayers().set("balance."+u.toString(), Main.getBalanceMap().get(u));
        }
        //p.saveConfig();
        EconomyYML.saveEconomy();
    }

    public static void loadBalances(){
        //   if(!p.getConfig().contains("balance")){
        //      return;
        // }


        // for(String s : p.getConfig().getConfigurationSection("balance").getKeys(false)){
        //     Double d = p.getConfig().getDouble("balance."+s);
        //      EcoMain.setBalance(UUID.fromString(s), Float.parseFloat(d.toString()));


        //    }
        //  p.saveConfig();

        if(!EconomyYML.getEconomyPlayers().contains("balance")){
            return;
        }

        for(String s : EconomyYML.getEconomyPlayers().getConfigurationSection("balance").getKeys(false)){
            Double d = EconomyYML.getEconomyPlayers().getDouble("balance."+s);
            Main.setBalance(UUID.fromString(s), Float.parseFloat(d.toString()));
        }
        EconomyYML.saveEconomy();

    }

}
