package be.itsjust4you.drugsconsume.Listeners;

import be.itsjust4you.drugsconsume.Config.Config;
import be.itsjust4you.drugsconsume.Logger;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class OnUse implements Listener {

    @EventHandler
    public void onUse(PlayerInteractEvent e){
        Player p = e.getPlayer();
        List<String> itemlijst = Config.getCustomConfig1().getStringList("DrugsLijst");
        String[] items = (String[])itemlijst.toArray(new String[0]);
        String[] var11 = items;
        int var10 = items.length;

        if(Config.getCustomConfig1().getString("Settings.PluginEnabled") == "true"){
            if(p.getInventory().getItemInMainHand() != null){
                if(e.getAction() == Action.RIGHT_CLICK_AIR){
                    for(int var9 = 0; var9 < var10; ++var9) {
                        String item = var11[var9];
                        if(Config.getCustomConfig1().getString("DrugsInfo." + item) == null) return;
                        Material material = Material.valueOf(Config.getCustomConfig1().getString("DrugsInfo." + item + ".matterial"));
                        String perm = Config.getCustomConfig1().getString("DrugsInfo." + item + ".perm");
                        int duration = Config.getCustomConfig1().getInt("DrugsInfo." + item + ".effect_duration");

                        if(p.hasPermission(perm)){
                            if(p.getInventory().getItemInMainHand().getType() == material){
                                p.sendMessage(Logger.color(Config.getCustomConfig1().getString("DrugsInfo." + item + ".taking")));

                                List<String> effectlijst = Config.getCustomConfig1().getStringList("DrugsInfo." + item + ".effects");
                                String[] items0 = (String[])effectlijst.toArray(new String[0]);
                                String[] vareffect = items0;
                                int vareffect1 = items0.length;

                                p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);

                                for(int i = 0; i < vareffect1; ++i) {
                                    String effecttoadd = vareffect[i];

                                    p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effecttoadd), duration, 1));
                                }
                            }
                        }

                    }
                    return;
                }
            }
            else{
                p.sendMessage(Logger.color(Config.getCustomConfig2().getString("NothingInHand")));
            }
        }
        else{
            if(p.isOp()){
                p.sendMessage(Logger.color(Config.getCustomConfig2().getString("PluginiIsDisabled")));
                return;
            }
        }
    }

}
