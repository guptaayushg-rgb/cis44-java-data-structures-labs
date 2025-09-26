import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Print current text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter text to add: ");
                    String text = scanner.nextLine();
                    editor.add(text);
                }
                case 2 -> editor.undo();
                case 3 -> editor.redo();
                case 4 -> editor.printCurrent();
                case 5 -> running = false;
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
