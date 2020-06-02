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
        this.map = new Map(10, 10);
        this.win = new TextWindow(this.map);
        this.addKeyListener(new ListenerKeyBoard());
    }

    public Client(String addr, int port) {}

    public void connect(String addr, int port) {}

    public void showWindow() {
        System.out.println("putin de test \033[31m azeazeaze");
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
    }

    public static void main(String[] args){
        Client c = new Client();
        c.showWindow();
        // s.test();
    }
}
