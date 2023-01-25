package SGM.SGM;

import SGM.SGM.COMMAND.GodCommand;
import SGM.SGM.Events.Godevents;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static java.util.Objects.requireNonNull;


public final class SGM extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new Godevents(), this);
        Bukkit.getLogger().finest(Bukkit.getName() + "Plugin Enabling");
        requireNonNull(getCommand("god")).setExecutor(new GodCommand());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().severe(Bukkit.getName() + "Plugin Disabling");
    }
}