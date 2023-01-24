package tesada.tesada;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static org.bukkit.Bukkit.getPlayer;

public final class Tesada extends JavaPlugin implements Listener {
    Set<UUID> godMode = new HashSet<>();
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player p) {
            if (godMode.contains(p.getUniqueId())){
                e.setCancelled(true);
            }
        }
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.equals("god"))
            if (sender instanceof Player player) {
                UUID uuid = player.getUniqueId();
                if(sender.hasPermission("tesada.godmode")) {
                    if (godMode.contains(uuid)) {
                        sender.sendMessage(ChatColor.DARK_RED + "U have Now Disabled GodMode");
                        godMode.remove(uuid);
                    }
                    else {
                        Bukkit.getLogger().warning(ChatColor.RED + "U have Now Enabled GodMode");
                        sender.sendMessage(ChatColor.GREEN + "U have Now Enabled GodMode");
                        godMode.add(uuid); }}
                else sender.sendMessage(ChatColor.DARK_RED + "U Do Not Have Permission For This Command");
            }
    return true;
}

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getLogger().info(ChatColor.YELLOW + "I Have Arisen");
        this.getCommand("onCommand").setExecutor(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.AQUA + "You Are Now Mortal!");
    }
}