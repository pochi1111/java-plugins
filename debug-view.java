package test.official_book.official_book;

import org.bukkit.plugin.java.JavaPlugin;
import test.official_book.official_book.Commands.official_book_open;
import test.official_book.official_book.Commands.pong;

public final class Official_book extends JavaPlugin {

    public static JavaPlugin plugin;
    @Override
    public void onEnable() {

        // Plugin startup logic
        getCommand("official_book_open").setExecutor(new official_book_open());
        getCommand("ping").setExecutor(new pong());
        super.onEnable();
        plugin.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
    }

    public static JavaPlugin getPlugin(){
        return plugin;
    }
}
