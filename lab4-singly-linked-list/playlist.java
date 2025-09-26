public class playlist {
    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public playlist() {
        head = null;
        tail = null;
        currentNode = null;
        size = 0;
    }

    public void addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            tail = newNode;
            currentNode = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println(song + " added to playlist.");
    }

    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (head.song.getTitle().equalsIgnoreCase(title)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            System.out.println("Removed \"" + title + "\" from playlist.");
            return;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.song.getTitle().equalsIgnoreCase(title)) {
                prev.next = current.next;
                if (current == tail) tail = prev;
                size--;
                System.out.println("Removed \"" + title + "\" from playlist.");
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Song \"" + title + "\" not found.");
    }

    public void playNext() {
        if (currentNode == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("Now playing: " + currentNode.song);
        currentNode = (currentNode.next != null) ? currentNode.next : head;
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("Playlist:");
        Node temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". " + temp.song);
            temp = temp.next;
            index++;
        }
    }
}

