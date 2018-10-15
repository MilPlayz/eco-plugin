package me.mil.coolserv.economy.main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class EconomyYML  {




    public static YamlConfiguration economy = null;
    public static File ecoFile = null;

    public static File getEcoFile() {
        return ecoFile;
    }

    @SuppressWarnings("deprecation")
    public static void reloadEco(){
        if(ecoFile == null){
            ecoFile = new File(Bukkit.getPluginManager().getPlugin("MilConomy").getDataFolder(), "economy.yml");
        }
        economy = YamlConfiguration.loadConfiguration(ecoFile);

        InputStream defConfigStream = Bukkit.getPluginManager().getPlugin("MilConomy").getResource("economy.yml");
        if(defConfigStream != null){

            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            //Reader defConfigStream = new InputStreamReader(Bukkit.getPluginManager().getPlugin("TeamPlugin").getResource("economy.yml"));﻿
            if(!ecoFile.exists() || ecoFile.length() == 0){
                economy.setDefaults(defConfig);
            }
        }

    }

    public static FileConfiguration getEconomyPlayers(){
        if(economy == null){
            reloadEco();
        }
        return economy;
    }

    public static void saveEconomy(){
        if(economy == null || ecoFile == null){
            return;
        }
        try{
            getEconomyPlayers().save(ecoFile);
        }catch(IOException ex){
            ex.printStackTrace();
            Bukkit.getLogger().log(Level.SEVERE, "could not save config " + ecoFile, ex);
        }
    }


}
