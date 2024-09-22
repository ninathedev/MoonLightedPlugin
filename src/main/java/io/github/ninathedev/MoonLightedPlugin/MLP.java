package io.github.ninathedev.MoonLightedPlugin;

import java.security.SecureRandom;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MLP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        sender.sendMessage("[MLP] hiya there! developer of this plugin (MoonLightedPlugin) is @ninathedev in discord or realguystuff ingame (i own a minecraft copy of it yay)");
        sender.sendMessage("[MLP] please follow the rules of MoonLighted and stuff. also i made \"thing\" which collects anonymous data (doesn't leak anything) for performance purposes.");
        sender.sendMessage("[MLP] why u still reading this? this plugin is only for making the server much more seamless and high performance and stuff. seeya! uwu~");
        return true;
    }
}