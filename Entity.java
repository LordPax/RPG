import java.util.ArrayList;
import java.util.List;

public class Entity{
    private String name;
    private int x;
    private int y;
    private int health;
    private int mana;
    private int maxHealth;
    private int maxMana;
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
        this.inventory = new Inventory();
    }

    public Entity(int type, int id, String name, int x, int y, int mana, int health, int maxMana, int maxHealth) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.mana = mana;
        this.health = health;
        this.maxMana = maxMana;
        this.maxHealth = maxHealth;
        this.inventory = new Inventory();
    }

}
