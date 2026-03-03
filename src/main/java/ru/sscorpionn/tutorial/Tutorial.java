package ru.sscorpionn.tutorial;

import com.destroystokyo.paper.utils.PaperPluginLogger;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Tutorial extends JavaPlugin implements Listener {

    Logger logger = PaperPluginLogger.getLogger(this.getPluginMeta());

    @Override
    public void onEnable() {
        logger.info("Hello World!");

        // Регистрация команд
        CommandExecutor executor = new PluginCommands();
        this.getCommand("гдея").setExecutor(executor);
        this.getCommand("heal").setExecutor(executor);
        this.getCommand("day").setExecutor(executor);

        // Регистрация слушателей ивентов
        getServer().getPluginManager().registerEvents(new PluginEventListeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}