public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Stick"));
        inventory.addItem(new Item("Stone"));
        inventory.addItem(new Item("Herb"));

        System.out.println("Initial Inventory:");
        inventory.display();

        System.out.println("\nAttempting to combine Stick and Stone...");
        inventory.combineItems("Stick", "Stone");

        System.out.println("\nInventory after combination:");
        inventory.display();

        System.out.println("\nAttempting to combine Stone and Herb...");
        inventory.combineItems("Stone", "Herb");

        System.out.println("\nFinal Inventory:");
        inventory.display();
    }
}
