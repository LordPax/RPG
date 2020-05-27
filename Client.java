import src.*;
import src.views.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private Map map;
    private RPGWindow win;

    public Client(String title) {
        this.map = new Map(10, 10);
        this.win = new RPGWindow(title, map);
    }

    public Client(String title, String addr, int port) {}

    public void connect(String addr, int port) {}

    public void test() {
        System.out.println("\n================ test map =================\n");
        this.map.afficheMap();
        System.out.println(this.map.getCase(0,0).getTest());
        System.out.println(this.map.getCase(1,0).getTest());
        System.out.println(this.map.getCase(0,1).getTest());
        System.out.println(this.map.getCase(1,1).getTest());

        System.out.println("\n================ test entity =================\n");
        Entity entity = new Entity("Skeleton", 0, 0, 0);
        System.out.println(entity.toString());

        System.out.println("\n================ test item =================\n");
        Item item = new Item("Sword");
        System.out.println(item.toString());
    }

    public Map getMap() {
        return this.map;
    }

    public RPGWindow getWindow() {
        return this.win;
    }

    public static void main(String[] args){
        Client c = new Client("RPG Client Alpha");
        // c.getWindow().addView(new Menu(c.getWindow(), c.getMap()));
        // c.getWindow().addView(new Game(c.getWindow(), c.getMap()));
        c.test();
    }
}
