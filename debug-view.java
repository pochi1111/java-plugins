package test.official_book.official_book;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.entity.Player;

import java.util.Set;

import static test.official_book.official_book.Official_book.plugin;

public class Listeners implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getView().getTitle().equals("公式本")){
            String item_name;
            event.setCancelled(true);
            item_name = event.getCurrentItem().getItemMeta().getDisplayName();
            if(plugin.getConfig().getStringList("books.names").contains(item_name)){
                Player e = (Player) event.getWhoClicked();
                e.sendMessage("本を開きます");
                e.closeInventory();
                e.performCommand("official_b "+item_name);
            }
        }
    }
}
