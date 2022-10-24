package me.hytralium.hytraliumapi.menusystem;

import me.hytralium.hytraliumapi.Debug;
import me.hytralium.hytraliumapi.HytraliumAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public abstract class PaginatedMenu extends Menu {

    int page;

    public PaginatedMenu(Player player, int page) {
        super(HytraliumAPI.getPlayerMenuUtility(player));
        this.page = page;
    }

    public abstract ArrayList<String> getList();

    public abstract Material getItemMaterial();

    public ArrayList<String> getLore(int i) {
        return null;
    }

    @Override
    public void setMenuItems() {
        setBorderGlass();

    }

    private void setBorderGlass() {
        // BorderGlass
        for (int i : getBorderGlassSlots()) {
            ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
            ItemMeta glassMeta = glass.getItemMeta();
            glassMeta.setDisplayName(" ");
            glass.setItemMeta(glassMeta);
            inventory.setItem(i, glass);
        }

        int start = getAllowedSlots().size() * (page - 1);
        int end = start + getAllowedSlots().size();
        Debug.info("start is: " + start + " end is: " + end);

        int a = 0;
        for (int i = start; i < end; i++) {
            if (i >= getList().size()) Debug.info("broke out of the loop at item " + i);
            if (i >= getList().size()) break;
            if (getList().get(i) != null) {
                ItemStack item = new ItemStack(getItemMaterial());
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.GOLD + getList().get(i) + ChatColor.GRAY + "(ID: " + i + " " + a + ")");
                if (getLore(i) != null) meta.setLore(getLore(i));
                item.setItemMeta(meta);
                inventory.setItem(getAllowedSlots().get(a), item);
            } else Debug.info("the item at " + i + " doesnt exist");
            a++;
        }
    }

    @Override
    public int getSlots() {
        return 54;
    }

    ArrayList<Integer> getBorderGlassSlots() {
        ArrayList<Integer> slots = new ArrayList<>();
        for (int i = 0; i <= 8; i++) slots.add(i);
        for (int i = 45; i <= 53; i++) slots.add(i);
        slots.add(9);
        slots.add(18);
        slots.add(27);
        slots.add(36);
        slots.add(17);
        slots.add(26);
        slots.add(35);
        slots.add(44);
        return slots;
    }
    ArrayList<Integer> getAllowedSlots() {
        ArrayList<Integer> slots = new ArrayList<>();
        slots.add(10);
        slots.add(11);
        slots.add(12);
        slots.add(13);
        slots.add(14);
        slots.add(15);
        slots.add(16);
        slots.add(19);
        slots.add(20);
        slots.add(21);
        slots.add(22);
        slots.add(23);
        slots.add(24);
        slots.add(25);
        slots.add(28);
        slots.add(29);
        slots.add(30);
        slots.add(31);
        slots.add(32);
        slots.add(33);
        slots.add(34);
        slots.add(37);
        slots.add(38);
        slots.add(39);
        slots.add(40);
        slots.add(41);
        slots.add(42);
        slots.add(43);
        return slots;
    }
}
