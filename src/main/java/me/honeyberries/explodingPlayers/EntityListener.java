package me.honeyberries.explodingPlayers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class EntityListener implements Listener {



    @EventHandler
    //when an entity gets right-clicked
    public void onEntityRightClick(PlayerInteractAtEntityEvent event) {

        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();

        if (entity instanceof Player) {
            Player hostage = (Player) entity;

            //check if the hostage is in the death row
            if (ExplodingPlayersSettings.getInstance().getListOfExplodingPlayers().contains(hostage.getUniqueId().toString())) {

                if (player.hasPermission("explodingPlayers.explode.use")) {

                    //torture the hostage
                    hostage.getWorld().createExplosion(hostage.getLocation(), 5F);

                }

                else {

                    player.sendMessage("You don't have the permission to torture people!");
                }

            }

        }

    }

}