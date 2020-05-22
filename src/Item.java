package src;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Item {
    private String name;
    private int damage;
    private int durability;

    public Item() {
        this.name = "";
        this.damage = 0;
        this.durability = -1;
    }

    public Item(String name, int damage, int durability) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }

    public Item(String file) {
        JSONObject o = this.readJSON(file);

        this.name = o.getString("name");
        this.damage = o.getInt("damage");
        this.durability = o.getInt("durability");
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

    public JSONObject readJSON(String file) {
        String path = "./Item/" + file + ".json";
        String content = this.charge(path);
        
        return new JSONObject(content);
    }

    public String toString() {
        return "name : " + this.name + ",\n"
        + "damage : " + this.damage + ",\n"
        + "durability : " + this.durability;
    }
}
