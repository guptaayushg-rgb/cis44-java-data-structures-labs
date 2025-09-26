public class TextEditor {
    private static class Node {
        String textState;
        Node prev;
        Node next;

        public Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    public void add(String newText) {
        currentNode.next = null;
        Node newNode = new Node(currentNode.textState + newText, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
    }

    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
            return currentNode.textState;
        } else {
            System.out.println("Cannot undo. Already at oldest state.");
            return currentNode.textState;
        }
    }

    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
            return currentNode.textState;
        } else {
            System.out.println("Cannot redo. Already at newest state.");
            return currentNode.textState;
        }
    }

    public void printCurrent() {
        System.out.println("Current Text: \"" + currentNode.textState + "\"");
    }
}
