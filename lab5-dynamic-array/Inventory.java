import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory contains:");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        }
    }

    public void combineItems(String name1, String name2) {
        Item first = null;
        Item second = null;

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item current = iterator.next();
            if (first == null && current.getName().equalsIgnoreCase(name1)) {
                first = current;
                iterator.remove();
            } else if (second == null && current.getName().equalsIgnoreCase(name2)) {
                second = current;
                iterator.remove();
            }
            if (first != null && second != null) {
                break;
            }
        }

        if (first != null && second != null) {
            String combinedName = first.getName() + " + " + second.getName();
            Item combined = new Item("Combined: " + combinedName);
            items.add(combined);
            System.out.println("Successfully combined " + name1 + " and " + name2 + " into " + combined.getName() + "!");
        } else {
            System.out.println("Combination failed: one or both items not found.");
            if (first != null && second == null) items.add(first);
            if (second != null && first == null) items.add(second);
        }
    }
}

