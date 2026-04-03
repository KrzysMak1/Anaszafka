package pl.ziffy.STORMSZAFKA;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("STORMSZAFKA wlaczona.");
    }

    @Override
    public void onDisable() {
        getLogger().info("STORMSZAFKA wylaczona.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String name = command.getName().toLowerCase();
        if (name.equals("stormszafka") || name.equals("szafka")) {
            sender.sendMessage("§aPlugin STORMSZAFKA działa. Kod został przygotowany do dalszej rozbudowy.");
            return true;
        }
        return false;
    }
}
