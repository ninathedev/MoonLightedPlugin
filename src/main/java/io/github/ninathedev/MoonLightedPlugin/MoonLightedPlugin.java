package io.github.ninathedev.MoonLightedPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MoonLightedPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("yoo, tysm for installing this plugin!");
        getLogger().info("note: this plugin does NOT have any configuration!");
        getLogger().info("if u wanna change anything, please ask me!");
        getLogger().info("- ninathedev");
        // Checks if server is running paper or spigot
        try {
            Class.forName("com.destroystokyo.paper.ParticleBuilder");
        } catch (ClassNotFoundException e) {
            getLogger().warning("[WARNING] You are running a Spigot server!");
            getLogger().warning("[WARNING] Although this plugin will most likely work on Spigot,");
            getLogger().warning("[WARNING] not only this plugin uses Paper API,");
            getLogger().warning("[WARNING] but Paper has better support for many players.");
            getLogger().warning("[WARNING] WE WILL NOT PROVIDE SUPPORT FOR USING A SPIGOT SERVER!");
        }
        Objects.requireNonNull(this.getCommand("randomfact")).setExecutor(new RandomFact());
        Objects.requireNonNull(this.getCommand("thingenable")).setExecutor(new ThingEnable());
        Objects.requireNonNull(this.getCommand("thingdisable")).setExecutor(new ThingDisable());
        Objects.requireNonNull(this.getCommand("mlp")).setExecutor(new MLP());
        Objects.requireNonNull(this.getCommand("selfkill")).setExecutor(new SelfKill());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        String player = event.getPlayer().getName();
        Block block = event.getBlock();

        if (block.getType() == Material.DIAMOND_ORE) {
            getLogger().info(player + " has mined diamond ore!");
        } else if (block.getType() == Material.DEEPSLATE_DIAMOND_ORE) {
            getLogger().info(player + " has mined deepslate diamond ore!");
        } else if (block.getType() == Material.ANCIENT_DEBRIS) {
            getLogger().info(player + " has mined ancient debris!");
        } else if (block.getType() == Material.IRON_ORE) {
            getLogger().info(player + " has mined iron ore!");
        } else if (block.getType() == Material.DEEPSLATE_IRON_ORE) {
            getLogger().info(player + " has mined deepslate iron ore!");
        }

        if (block.getType() == Material.BEDROCK) {
            // Get the original location of the bedrock
            Location originalLocation = block.getLocation();
            World world = block.getWorld();

            // Restore bedrock after a 1 tick delay
            Bukkit.getScheduler().runTaskLater(MoonLightedPlugin.this, () -> {
                // Check if the bedrock block is still broken
                if (block.getType() != Material.BEDROCK) {
                    // Restore the bedrock block at its original location
                    world.getBlockAt(originalLocation).setType(Material.BEDROCK);

                    // Log the event in the console
                    getLogger().info("Bedrock at " + originalLocation + " was restored.");
                }
            }, 1);
        }
    }
}
