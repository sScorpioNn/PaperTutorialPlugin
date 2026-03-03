package ru.sscorpionn.tutorial;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            return false;
        }

        switch (command.getName().toLowerCase()) {
            case "гдея":
                sendCoords(player);
                break;
            case "heal":
                healPlayer(player);
                break;
            case "day":
                setDay(player);
                break;
        }

        return true;
    }

    private void sendCoords(Player player) {
        Location loc = player.getLocation();

        player.sendMessage(Component.text("Вы находитесь на ")
                .append(Component.text(String.format("X:%d Y:%d Z:%d",
                                loc.getBlockX(),
                                loc.getBlockY(),
                                loc.getBlockZ()),
                        NamedTextColor.GREEN)));
    }

    private void healPlayer(Player player) {
        player.setHealth(20);
        player.sendMessage(Component.text("Вы были исцелены", TextColor.color(5, 200, 30)));
    }

    private void setDay(Player player) {
        player.getWorld().setTime(1000);
    }
}
