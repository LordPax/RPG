import java.util.ArrayList;
import java.util.List;

public class Server {
    private Map map;
    private ArrayList<Entity> player = new ArrayList<Entity> ();
    private ArrayList<Entity> mob = new ArrayList<Entity> ();
    private ArrayList<Entity> pnj = new ArrayList<Entity> ();

    public Server() {
    }

    public Server(String addr, int port) {
    }

    public void createServer(String addr, int port) {
    }

    public void test() {
        this.map = new Map(5, 5);
        this.map.afficheMap();
        System.out.println(this.map.getCase(0,0).getTest());
        System.out.println(this.map.getCase(1,0).getTest());
        System.out.println(this.map.getCase(0,1).getTest());
        System.out.println(this.map.getCase(1,1).getTest());
    }

    public static void main(String[] args){
        Server s = new Server();
        s.test();
    }

}
