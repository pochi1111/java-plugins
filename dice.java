package jp.test.hello_paper_plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Random;

import static java.lang.Thread.sleep;
//import static jp.test.hello_paper_plugin.Commands.dice.*;

//class Output_message extends Thread{
//
//    @Override
//    public void run(){
//        try {
//            sleep(3000);
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
//        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
//        Bukkit.broadcastMessage(out_message);
//        now_dice = false;
//    }
//}


public class dice implements CommandExecutor{

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String out_message;
        Player p = (Player) sender;
        Random rand = new Random();
        if(args.length == 0){
            //因数していなし
            sender.sendMessage("[Dice]"+"/dice 面の数 回す数");
        }else if(args.length == 1){
            if(args[0].length() > 8){
                sender.sendMessage("[Dice]入力は１億以下でお願いします");
                return true;
            }
            sender.sendMessage("[Dice]"+args[0]+"面のdiceを回しています...");
            int dice = Integer.parseInt(args[0]);
            int random_dice = rand.nextInt(dice)+1;
            out_message = "[Dice]"+p.getPlayer().getName() + "が、" + dice + "面ダイスで、" + random_dice + "が当たりました！！";
            new Thread( () -> {
                try {
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                Bukkit.broadcastMessage(out_message);
            } ).start();
        }else{
            //引数の個数2
            if(args[0].length() > 8 || args[1].length() > 8){
                sender.sendMessage("[Dice]入力は１億以下でお願いします");
                return true;
            }
            sender.sendMessage("[Dice]"+args[0]+"面のdiceを"+args[1]+"個回しています...");
            int dice = Integer.parseInt(args[0]);
            int dice_kosuu = Integer.parseInt(args[1]);
            int random_dice;
            String output = "";
            for (int i = 0; i < dice_kosuu; i++) {
                random_dice = rand.nextInt(dice)+1;
                if (i != dice_kosuu-1){
                    output += Integer.toString(random_dice)+" ";
                }else{
                    output += Integer.toString(random_dice);
                }
            }
            out_message = "[dice]"+p.getPlayer().getName() + "が、" + dice + "面ダイス"+args[1]+"個で、" + output + "が当たりました！！";
            new Thread( () -> {
                try {
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                Bukkit.broadcastMessage(out_message);
            } ).start();
        }
        return true;
    }
}
