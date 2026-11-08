package de.tridan.heldenherzen;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class HeldenHerzenPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("HeldenHerzen v1.0.0 für Paper 1.20.1 wurde gestartet.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String resourcePackUrl = getConfig().getString("resource-pack-url", "").trim();
        if (resourcePackUrl.isEmpty()) {
            return;
        }

        Player player = event.getPlayer();
        getServer().getScheduler().runTaskLater(this, () -> {
            if (player.isOnline()) {
                // Minecraft fragt den Spieler, ob er das Server-Resourcepack laden möchte.
                player.setResourcePack(resourcePackUrl);
            }
        }, 20L);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("helden")) {
            return false;
        }

        if (args.length != 2 || !args[0].equalsIgnoreCase("herz")) {
            sender.sendMessage(ChatColor.RED + "Benutzung: /helden herz <1|2>");
            return true;
        }

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Dieser Befehl kann nur ein Spieler ausführen.");
            return true;
        }

        String variant = args[1];
        if (!variant.equals("1") && !variant.equals("2")) {
            sender.sendMessage(ChatColor.RED + "Benutzung: /helden herz <1|2>");
            return true;
        }

        ItemStack item = createHeart(variant);
        player.getInventory().addItem(item).values().forEach(leftover ->
                player.getWorld().dropItemNaturally(player.getLocation(), leftover));
        player.sendMessage(ChatColor.AQUA + "Du hast Helden Herz " + variant + " erhalten!");
        return true;
    }

    private ItemStack createHeart(String variant) {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.AQUA + "Helden Herz " + variant);
            meta.setLore(List.of(
                    ChatColor.WHITE + "Ein Herz für echte Helden.",
                    ChatColor.AQUA + "❖ ❖ ❖",
                    ChatColor.BLACK + "?"
            ));
            meta.setCustomModelData(Integer.parseInt(variant));
            item.setItemMeta(meta);
        }

        return item;
    }
}
