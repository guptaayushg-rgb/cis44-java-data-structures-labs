public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> numbers = new DynamicArray<>();
        for (int i = 1; i <= 15; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        int removed = numbers.remove(5);
        System.out.println(removed);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        DynamicArray<String> words = new DynamicArray<>();
        words.add("Hello");
        words.add("World");
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i) + " ");
        }
    }
}
