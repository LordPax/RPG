import src.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Client extends JPanel{
    private Map map;
    private TextWindow win;

    public Client() {
        super();
        this.map = new Map(20, 20);
        this.win = new TextWindow(this.map);
        this.addKeyListener(new ListenerKeyBoard());
    }

    public Client(String addr, int port) {}

    public void connect(String addr, int port) {}

    public void showWindow() {
        this.win.titre();
        this.win.showMap();
        this.win.choice();
    }

    public void test() {
        System.out.println("\n================ test map =================\n");
        // this.map.afficheMap();
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

        System.out.println("\n================ test TextWindow =================\n");

        // this.map.setCase(0, 0, "Skeleton");
        // this.map.setCase(0, 5, "Skeleton");
        // this.map.setCase(3, 0, "Skeleton");
        // this.map.setCase(2, 3, "Skeleton");

        // this.map.setCase(10, 10, "Player");

        System.out.println(this.map.getPlayer(0));
        System.out.println("\n--------------------------\n");
        System.out.println(this.map.getMob(0));
        // System.out.println("\n--------------------------\n");
        // System.out.println(this.map.getMob(1));
        // System.out.println("\n--------------------------\n");
        // System.out.println(this.map.getMob(2));
        // System.out.println("\n--------------------------\n");
        // System.out.println(this.map.getMob(3));
    }

    public void test1() {
        this.map.setCase(0, 0, "Skeleton");
        this.map.setCase(0, 5, "Skeleton");
        this.map.setCase(3, 0, "Skeleton");
        this.map.setCase(2, 3, "Skeleton");

        this.map.setCase(10, 10, "Player");
    }

    public static void main(String[] args){
        Client c = new Client();
        c.test1();
        c.showWindow();
    }
}
