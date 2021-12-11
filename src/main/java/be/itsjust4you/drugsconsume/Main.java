package be.itsjust4you.drugsconsume;

import be.itsjust4you.drugsconsume.Commands.Consume;
import be.itsjust4you.drugsconsume.Config.Config;
import be.itsjust4you.drugsconsume.Listeners.OnUse;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Console
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        //Configs
        Config.createCustomConfig1();
        Config.createCustomConfig2();

        //Commands
        new Consume(this);

        //Listener
        Bukkit.getServer().getPluginManager().registerEvents(new OnUse(), this);

        //Metrics
        Metrics metrics = new Metrics(this, 12291);

        console.sendMessage(Logger.color("&f----------------------------------------"));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&cPlugin wordt aangezettt..."));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&cCoded by&f: ItsJust4You"));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&f----------------------------------------"));
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        console.sendMessage(Logger.color("&f----------------------------------------"));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&cPlugin wordt uitgezet..."));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&cCoded by&4: ItsJust4You"));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&f----------------------------------------"));
    }
}

