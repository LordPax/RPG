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
    // private int playerId;
    // private ArrayList<Entity> player;
    private Entity player;
    private ArrayList<Entity> mob;
    // private ArrayList<Entity> pnj;

    public Map() {}

    public Map(int w, int h) {
        // this.player = new ArrayList<Entity>();
        this.player = new Entity();
        this.mob = new ArrayList<Entity>();
        // this.pnj = new ArrayList<Entity>();
        this.w = w;
        this.h = h;
        this.lastId = 0;
        // this.playerId = 0;
        this.initMap();
    }

    public Map(String file) {
        this.player = new Entity();
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

    public Entity getPlayer() {
        return this.player;
    }

    public Entity getMob(int i) {
        return this.mob.get(i);
    }

    public void moveEntity(int type, int id, int dx, int dy) {
        Entity entity = new Entity();

        if (type == 1)
            entity = this.getPlayer();
        else if (type == 2)
            entity = this.getMob(id);
        else
            System.out.println("RPG : Pas d'entité correspondant au type, id");

        int x = entity.getX(), y = entity.getY();
        entity.move(dx, dy);

        this.getCase(x, y).setTypeEntity(0);
        this.getCase(x, y).setIdEntity(0);

        this.getCase(x + dx, y + dy).setTypeEntity(entity.getType());
        this.getCase(x + dx, y + dy).setIdEntity(entity.getId());

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
        Entity entity = new Entity(name, this.lastId, x, y);

        this.getCase(x, y).setTypeEntity(entity.getType());
        this.getCase(x, y).setIdEntity(entity.getId());

        if(entity.getType() == 1)
            this.player = entity;
        else {
            this.mob.add(entity);
            this.lastId++;
        }
    }

    public void setCase(int x, int y, int ground, int build) {
        this.getCase(x, y).setGround(ground);
        this.getCase(x, y).setBuild(build);        
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
