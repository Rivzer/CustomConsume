package be.itsjust4you.drugsconsume.Commands;

import be.itsjust4you.drugsconsume.Config.Config;
import be.itsjust4you.drugsconsume.Logger;
import be.itsjust4you.drugsconsume.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Consume implements CommandExecutor {

    private Main plugin;

    public Consume(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("consume").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(Logger.color("&f---------------------"));
            sender.sendMessage(Logger.color("&cDeze commands zijn niet bedoeld voor de console!"));
            sender.sendMessage(Logger.color("&f---------------------"));
            return true;
        }

        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("consume")){
            if(args.length == 0){
                if(p.hasPermission("drugsconsume.help")){
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume help &7- &aLook at the commands."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume list &7- &aGet a list from all drugs {DEP: CustomDrugs: https://bit.ly/CustomDrugs}."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume info &7- &aLook at the plugin maker."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume reload &7- &aReload all config files."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else{
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume help &7- &aLook at the commands."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume info &7- &aLook at the plugin maker."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
            }
            else if(args[0].equalsIgnoreCase("help")){
                if(p.hasPermission("drugsconsume.help")){
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume help &7- &aLook at the commands."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume list &7- &aGet a list from all drugs {DEP: CustomDrugs: https://bit.ly/CustomDrugs}."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume info &7- &aLook at the plugin maker."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume reload &7- &aReload all config files."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else{
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume help &7- &aLook at the commands."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&2/consume info &7- &aLook at the plugin maker."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
            }
            else if(args[0].equalsIgnoreCase("info")){
                p.sendMessage(Logger.color("&f---------------------"));
                p.sendMessage(Logger.color("&2This plugin was created by &a&lRivzer"));
                p.sendMessage(Logger.color("&2Version: &a&l1.2"));
                p.sendMessage(Logger.color("&2Reselling or modifying this plugin is prohibited!"));
                p.sendMessage(Logger.color("&f---------------------"));
                return true;
            }
            else if(args[0].equalsIgnoreCase("reload")){
                if(p.hasPermission("drugsconsume.reload")){
                    p.sendMessage(Logger.color("&c&lSorry we don't support plugin reload yet, please restart (or reload) the server for saving the config files!"));
                    return true;
                }
                else{
                    p.sendMessage(Logger.color(Config.getCustomConfig2().getString("NoPermisison")));
                    return true;
                }
            }
        }
        return false;

    }
}
