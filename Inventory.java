import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ArrayList<Item> item;

    public Inventory() {
        this.item = new ArrayList<Item>();
    }

    public Item getItem(int i) {
        return this.item.get(i);
    }

    public void addItem(Item item) {
        this.item.add(item);
    }

    public String toString() {
        return "test";
    }
}
