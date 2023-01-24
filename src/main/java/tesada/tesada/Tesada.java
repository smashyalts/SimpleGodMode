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
    List<Player> godMode = new ArrayList<>();
    @EventHandler
    public void OnDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player p) {
            if (godMode.contains(p) && p.hasPermission("tesada.godmode")) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void OnChat(AsyncChatEvent e) {
        if ((e.originalMessage().toString().contains("i am a god"))){
            if (!e.getPlayer().hasPermission("tesada.godmode"))
                e.getPlayer().sendMessage(ChatColor.DARK_RED + "U Do Not Have Permission For This Command");
            else if(e.getPlayer().hasPermission("tesada.godmode")) {
                if (godMode.contains(e.getPlayer())) {
                    e.getPlayer().sendMessage(ChatColor.DARK_RED + "U have Now Disabled GodMode");
                    godMode.remove(e.getPlayer());
                }
                else {
                    Bukkit.getLogger().warning(ChatColor.RED + "U have Now Enabled GodMode");
                    e.getPlayer().sendMessage(ChatColor.GREEN + "U have Now Enabled GodMode");
                    godMode.add(e.getPlayer()); }}
            }
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