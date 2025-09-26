import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playlist playlist = new playlist();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Playlist Manager ---");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next Song");
            System.out.println("4. Display Playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;
                case 2:
                    System.out.print("Enter title of song to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    break;
                case 3:
                    playlist.playNext();
                    break;
                case 4:
                    playlist.displayPlaylist();
                    break;
                case 0:
                    System.out.println("Exiting Playlist Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
