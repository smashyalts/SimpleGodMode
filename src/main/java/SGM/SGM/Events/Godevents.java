package SGM.SGM.Events;

import  SGM.SGM.COMMAND.GodCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.jetbrains.annotations.NotNull;

public class Godevents implements @NotNull Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player p) {
            if (GodCommand.godMode.contains(p.getUniqueId())){
                e.setCancelled(true);
            }
        }
    }
}
