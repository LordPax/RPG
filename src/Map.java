package src;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
// import java.util.*;

public class Map {
    private Case[] matrice;
    private int w;
    private int h;
    private int lastId;
    private int playerId;
    private ArrayList<Entity> player;
    private ArrayList<Entity> mob;
    // private ArrayList<Entity> pnj;

    public Map() {}

    public Map(int w, int h) {
        this.player = new ArrayList<Entity>();
        this.mob = new ArrayList<Entity>();
        // this.pnj = new ArrayList<Entity>();
        this.w = w;
        this.h = h;
        this.lastId = 0;
        this.playerId = 0;
        this.initMap();
    }

    public Map(String file) {
        this.player = new ArrayList<Entity>();
        this.mob = new ArrayList<Entity>();
        // this.pnj = new ArrayList<Entity>();
        this.w = w;
        this.h = h;
        this.initMap();
    }

    public int getWidth() {
        return this.w;
    }
    public int getHeight() {
        return this.h;
    }

    public Entity getPlayer(int i) {
        return this.player.get(i);
    }

    public Entity getMob(int i) {
        return this.mob.get(i);
    }

    public void initMap() {
        int size = this.w * this.h;
        this.matrice = new Case[size];

        for (int i = 0; i < size; i++)
            this.matrice[i] = new Case();
    }

    public Case getCase(int x, int y) {
        int indice = y * this.w + x;
        return this.matrice[indice];
    }

    public void setCase(int x, int y, String name) {
        int indice = y * this.w + x;

        Entity entity = new Entity(name, this.lastId, x, y);
        this.lastId++;

        this.matrice[indice].setTypeEntity(entity.getType());
        this.matrice[indice].setIdEntity(entity.getId());

        if(entity.getType() == 1)
            this.player.add(entity);
        else
            this.mob.add(entity);
    }

    public void setCase(int x, int y, int ground, int build) {
        int indice = y * this.w + x;

        this.matrice[indice].setGround(ground);
        this.matrice[indice].setBuild(build);        
    }

    public Case[] getMatrice() {
        return this.matrice;
    }

    public JSONObject readJSON(String file) {
        String path = "./Save/" + file + ".json";
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

    public void save(String nameFile, String content) {
        try {
            BufferedWriter bw = Files.newBufferedWriter(Paths.get(nameFile));

            bw.write(content);
            bw.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
