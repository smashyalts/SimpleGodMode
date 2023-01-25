package SGM.SGM.COMMAND;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class GodCommand implements @Nullable CommandExecutor {

    public static Set<UUID> godMode = new HashSet<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equals("god"))
            if (sender instanceof Player player) {
                UUID uuid = player.getUniqueId();
                if(sender.hasPermission("SGM.godmode")) {
                    if (godMode.contains(uuid)) {
                        sender.sendMessage(ChatColor.DARK_RED + "U have Now Disabled GodMode");
                        godMode.remove(uuid);
                    }
                    else {
                        sender.sendMessage(ChatColor.GREEN + "U have Now Enabled GodMode");
                        godMode.add(uuid); }}
            }
        return true;
    }
}


