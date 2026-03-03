package ru.sscorpionn.tutorial;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.util.Vector;

public class PluginEventListeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("Добро пожаловать на сервер!"));
    }

    @EventHandler
    public void onSheepShear(PlayerShearEntityEvent event) {
        if(event.getEntity() instanceof Sheep sheep) {
            sheep.setVelocity(new Vector(0, 2, 0));
            sheep.getWorld().playSound(sheep, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, 1);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.BEDROCK) {
            event.setCancelled(true);
        }
    }
}
