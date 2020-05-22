package src;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Entity{
    private String name;
    private int x;
    private int y;
    private int health;
    private int mana;
    private int maxHealth;
    private int maxMana;
    private int damage;
    private int type;
    private int id;
    private Inventory inventory;

    public Entity() {
        this.type = 0;
        this.id = 0;
        this.name = "";
        this.x = 0;
        this.y = 0;
        this.mana = 0;
        this.health = 0;
        this.maxMana = 0;
        this.maxHealth = 0;
        this.damage = 0;
        this.inventory = new Inventory();
    }

    public Entity(int type, int id, String name, int x, int y, int mana, int health, int maxMana, int maxHealth, int damage) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.mana = mana;
        this.health = health;
        this.maxMana = maxMana;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.inventory = new Inventory();
    }

    public Entity(String file, int id, int x, int y) {
        JSONObject o = this.readJSON(file);

        this.type = o.getInt("type");
        this.id = 0;
        this.name = o.getString("name");
        this.x = 0;
        this.y = 0;
        this.mana = o.getInt("mana");
        this.health = o.getInt("health");
        this.maxMana = o.getInt("maxMana");
        this.maxHealth = o.getInt("maxHealth");
        this.damage = o.getInt("damage");
        this.inventory = new Inventory();

        // this(o.getInt("type"), id, o.getString("name"), x, y, o.getInt("mana"), o.getInt("health"), o.getInt("maxMana"), o.getInt("maxHealth"), o.getInt("damage"));
    }

    public JSONObject readJSON(String file) {
        String path = "./Entity/" + file + ".json";
        String content = this.charge(path);
        
        return new JSONObject(content);
    }

    public String charge(String file) {
        String line, content = "";
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(file));

            while ((line = br.readLine()) != null)
                content += line + "\n";
 
            br.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        return content;
    }

    public int getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getMana() {
        return this.mana;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getDamage() {
        return this.damage;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public String toString() {
        return "Type : " + this.type + ",\n"
        + "ID : " + this.id + ",\n"
        + "Name : " + this.name + ",\n"
        + "x : " + this.x + ",\n"
        + "y : " + this.y + ",\n"
        + "mana : " + this.mana + ",\n"
        + "health : " + this.health + ",\n"
        + "maxMana : " + this.maxMana + ",\n"
        + "maxHealth : " + this.maxHealth + ",\n"
        + "damage : " + this.damage;
    }
}
