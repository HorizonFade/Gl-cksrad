package de.horizon.rad;

import java.security.MessageDigestSpi;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.mysql.jdbc.Messages;

public class Main extends JavaPlugin implements Listener{
	public FileConfiguration cfg = this.getConfig();
	
	Random r = new Random();
	public Inventory glücksrad = null;
	  public void loadConfig()
	  {
	    FileConfiguration cfg = getConfig();
	    cfg.addDefault("Messages.Spins", "&6Du hast %spins% Spins!");
	    cfg.addDefault("Messages.Join", "&6Du hast gerade %spins% Spins!");
	    cfg.addDefault("Messages.Usage", "&6Mache bitte %befehl%");
	    cfg.addDefault("Messages.ZuWenigSpins", "&6Du hast zu wenig Spins!");
	    cfg.addDefault("Messages.NoPerms", "&cKeine Rechte!");
	    cfg.options().copyDefaults(true);
	    saveConfig();
	  }
	@Override
	public void onEnable(){
		loadConfig();
		System.out.println("Nein");
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("rad")){
			if(args.length == 0){
				if(p.hasPermission("rad.*")) {
				p.sendMessage("");
				p.sendMessage("§c- /rad spins                      §7#Um deine Spins zu sehen!");
				p.sendMessage("§c- /rad spin                       §7#Um am Glücksrad zu drehen!");
				p.sendMessage("§c- /rad add <Spieler> <Anzahl>     §7#Um einem Spieler Spins hinzuzufügen!");
				p.sendMessage("");	
				}else{
				p.sendMessage("");
				p.sendMessage("§c- /rad spins                      §7#Um deine Spins zu sehen!");
				p.sendMessage("§c- /rad spin                       §7#Um am Glücksrad zu drehen!");
				p.sendMessage("");
			}
			}else
		if(args.length == 3){
		if(args[0].equalsIgnoreCase("add")){
			if(p.hasPermission("rad.add")) {
			Player playerisonline = Bukkit.getPlayerExact(args[1]);
			if(args[1].equals(playerisonline.getName())) {
			int number = Integer.parseInt(args[2]);
			cfg.set("Players."+args[1], cfg.getInt("Players."+args[1]) + number);
			saveConfig();
			p.sendMessage("§c"+args[1]+"§6 hat jetzt §c"+cfg.getInt("Players."+args[1])+"§6 Spins");
		}else{
		p.sendMessage("§cDer Spieler muss Online sein!");	
		}
			}else{ 
				p.sendMessage(cfg.getString("Messages.NoPerms").replaceAll("&", "§").replaceAll("%spins%", ""+cfg.getInt("Players."+p.getName())));
			}
		}
		}else if(args[0].equalsIgnoreCase("add") && args.length < 3){
		p.sendMessage(cfg.getString("Messages.Usage").replace("%befehl%", "/rad add <Spieler> <Anzahl>").replace("&", "§"));	
		}else
		if(args.length == 1){
		if(args[0].equalsIgnoreCase("spins")){	
			p.sendMessage(cfg.getString("Messages.Spins").replaceAll("&", "§").replaceAll("%spins%", cfg.getString("Players."+p.getName())));
		}else
			if(args[0].equalsIgnoreCase("spin")) {
				glücksrad = p.getServer().createInventory(null, 9, "§aGLÜCKSRAD OF THE DOOM");
				if(cfg.getInt("Players."+p.getName()) >= 1) {
					p.openInventory(glücksrad);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 3 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(0, glass);
						}
						},0);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 3 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(1, glass);
						}
						},2);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 3 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(2, glass);
						}
						},4);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 3 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(3, glass);
						}
						},6);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 3 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(4, glass);
						}
						},8);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 3 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(5, glass);
						}
						},10);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 3 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(6, glass);
						}
						},12);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 3 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(7, glass);
						}
						},14);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 3 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(8, glass);
						}
						},16);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 2 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(0, glass);
						}
						},20);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 2 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(1, glass);
						}
						},22);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 2 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(2, glass);
						}
						},24);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 2 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(3, glass);
						}
						},26);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 2 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(4, glass);
						}
						},28);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 2 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(5, glass);
						}
						},30);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 2 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(6, glass);
						}
						},32);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 2 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(7, glass);
						}
						},34);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 2 Sekunden");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(8, glass);
						}
						},36);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 1 Sekunde");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(0, glass);	
						}
						},40);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 1 Sekunde");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(1, glass);
						}
						},42);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 1 Sekunde");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(2, glass);
						}
						},44);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 1 Sekunde");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(3, glass);
						}
						},46);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 1 Sekunde");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(4, glass);
						}
						},48);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 1 Sekunde");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(5, glass);
						}
						},50);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 1 Sekunde");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(6, glass);
						}
						},52);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 1 Sekunde");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(7, glass);
						}
						},54);
					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							ItemStack glass = null;
							glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
						 	ItemMeta met0 = glass.getItemMeta();
						 	met0.addItemFlags();
							met0.setDisplayName("§aWarte 1 Sekunde");
					        glass.setItemMeta(met0);	
							glücksrad.setItem(8, glass);
						}
						},56);
		Bukkit.getScheduler().runTaskLater(this, new Runnable() {
		public void run() {
			ItemStack random = null;
		int zufall = r.nextInt(3);
		switch(zufall){
		case 0:
		
	    random = new ItemStack(Material.COOKED_CHICKEN, 1);
	 	ItemMeta meta0 = random.getItemMeta();
		meta0.setDisplayName("§aKFC-CHICKEN WINGS");
	    meta0.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
	    meta0.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        random.setItemMeta(meta0);	
	    break;
		case 1:
		    random = new ItemStack(Material.COOKED_BEEF, 1);
		 	ItemMeta meta1 = random.getItemMeta();
			meta1.setDisplayName("§aGABE NEWELL");
		    meta1.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		    meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        random.setItemMeta(meta1);	
		    break;
		case 2:
		    random = new ItemStack(Material.BARRIER, 1);
		 	ItemMeta meta2 = random.getItemMeta();
			meta2.setDisplayName("§4Garnichts :(");
			meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		    meta2.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
	        random.setItemMeta(meta2);	
		    break;
		case 3:
		    random = new ItemStack(Material.BED, 1);
		 	ItemMeta meta3 = random.getItemMeta();
			meta3.setDisplayName("§aEndlich Schlafenszeit!");
			meta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		    meta3.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
	        random.setItemMeta(meta3);	
		    break;
		}
		glücksrad.setItem(4, random);
		ItemStack glass = null;
		glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
	 	ItemMeta met0 = glass.getItemMeta();
	 	met0.addItemFlags();
		met0.setDisplayName("§a");
        glass.setItemMeta(met0);	
        glücksrad.setItem(0, glass);
        glücksrad.setItem(1, glass);
        glücksrad.setItem(2, glass);
        glücksrad.setItem(3, glass);
        glücksrad.setItem(5, glass);
        glücksrad.setItem(6, glass);
        glücksrad.setItem(7, glass);
        glücksrad.setItem(8, glass);
		cfg.set("Players."+p.getName(), cfg.getInt("Players."+p.getName()) - 1);
		saveConfig();
		}
		},60);
		}else{
			p.sendMessage(cfg.getString("Messages.ZuWenigSpins").replaceAll("&", "§").replaceAll("%spins%", ""+cfg.getInt("Players."+p.getName())));
		}
			}
		}
		
		}
		return true;
	
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
	if(e.getInventory().getName().equalsIgnoreCase("§aGLÜCKSRAD OF THE DOOM")) {
	if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEndlich Schlafenszeit!")){
	e.setCancelled(true);
	e.getWhoClicked().closeInventory();
	e.getWhoClicked().getInventory().addItem(new ItemStack(Material.BED, 1));
	}if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKFC-CHICKEN WINGS")){
		e.setCancelled(true);
		e.getWhoClicked().getInventory().addItem(new ItemStack(Material.COOKED_CHICKEN, 64));
		e.getWhoClicked().closeInventory();
		}
	if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGABE NEWELL")){
			e.setCancelled(true);
			e.getWhoClicked().getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 64));
			e.getWhoClicked().closeInventory();
		}
	e.setCancelled(true);	
	}else{
		e.setCancelled(false);
	}
	}
	@EventHandler
	public void onJ(PlayerJoinEvent e){
		Player p = e.getPlayer();
	if(cfg.getString("Players."+p.getName()) != null){
	p.sendMessage(cfg.getString("Messages.Join").replaceAll("&", "§").replaceAll("%spins%", cfg.getString("Players."+p.getName())));
	}else{
	cfg.addDefault("Players."+p.getName(), 0);
	saveConfig();
	p.sendMessage(cfg.getString("Messages.Join").replaceAll("&", "§").replaceAll("%spins%", cfg.getString("Players."+p.getName())));
	}
	}
}
