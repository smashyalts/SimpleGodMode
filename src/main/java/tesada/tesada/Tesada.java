package tesada.tesada;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.bukkit.Bukkit.getPlayer;

public final class Tesada extends JavaPlugin implements Listener {
    List<UUID> godMode = new ArrayList<>();
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player p) {
            if (godMode.contains(e.getEntity().getUniqueId()) && p.hasPermission("tesada.godmode")) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onChat(AsyncChatEvent e) {
        if ((e.originalMessage().toString().contains("i am a god"))){
            if(e.getPlayer().hasPermission("tesada.godmode")) {
                if (godMode.contains(e.getPlayer().getUniqueId())) {
                    e.getPlayer().sendMessage(ChatColor.DARK_RED + "U have Now Disabled GodMode");
                    godMode.remove(e.getPlayer().getUniqueId());
                }
                else {
                    Bukkit.getLogger().warning(ChatColor.RED + "U have Now Enabled GodMode");
                    e.getPlayer().sendMessage(ChatColor.GREEN + "U have Now Enabled GodMode");
                    godMode.add(e.getPlayer().getUniqueId()); }}
            }
            else e.getPlayer().sendMessage(ChatColor.DARK_RED + "U Do Not Have Permission For This Command");
        }
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getLogger().info(ChatColor.YELLOW + "I Have Arisen");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.AQUA + "You Are Now Mortal!");
    }
}