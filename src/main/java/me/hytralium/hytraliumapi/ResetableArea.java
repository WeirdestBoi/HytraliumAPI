package me.hytralium.hytraliumapi;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResetableArea implements ConfigurationSerializable {
    public ResetableArea(Location loc1, Location loc2) {
        this.world = loc1.getWorld().getName();

        this.x_1 = loc1.getBlockX();
        this.y_1 = loc1.getBlockY();
        this.z_1 = loc1.getBlockZ();

        this.x_2 = loc2.getBlockX();
        this.y_2 = loc2.getBlockY();
        this.z_2 = loc2.getBlockZ();

        this.save();
    }
    public void save() {
        this.materials = new ArrayList<>();
        for (Block b : this.getRegion()) {
            this.materials.add(b.getType());
        }
    }
    public void reset() {
        int i = 0;
        for (Block b : this.getRegion()) {
            b.setType(this.materials.get(i));
            i++;
        }
    }
    List<Material> materials;
    String world;
    int x_1, y_1, z_1;
    int x_2, y_2, z_2;


    public Cuboid getRegion() {return new Cuboid(this.getFirst(), this.getSecond());}
    public Location getFirst() {
        return new Location(Bukkit.getWorld(this.world), x_1, y_1, z_1);
    }
    public Location getSecond() {
        return new Location(Bukkit.getWorld(this.world), x_2, y_2, z_2);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("world", this.world);
        map.put("mate rials", this.materials);

        map.put("x_1", this.x_1);
        map.put("y_1", this.y_1);
        map.put("z_1", this.z_1);

        map.put("x_2", this.x_2);
        map.put("y_2", this.y_2);
        map.put("z_2", this.z_2);
        return map;
    }
}
