package io.github.ninathedev.MoonLightedPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SelfKill implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if(args.length == 0) {
                player.setHealth(0);
            } else {
                return true;
            }
        } else {
            sender.sendMessage("[MLP] nuh uh");
        }
        return true;
    }
}