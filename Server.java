import src.*;
import src.views.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private Map map;

    public Server() {
        this.map = new Map(5, 5);
    }

    public Server(String addr, int port) {}

    public void createServer(String addr, int port) {
    }

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

    public static void main(String[] args){
        Server s = new Server();
        s.test();
    }

}
