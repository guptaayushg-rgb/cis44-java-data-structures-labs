import java.util.Arrays;
import java.util.Random;

public class sortingtest {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            // Generate test cases for three scenarios
            int[] avgCase = generateRandomArray(n);      // Average case: random
            int[] bestCase = generateSortedArray(n);     // Best case: already sorted
            int[] worstCase = generateReverseSortedArray(n); // Worst case: reverse sorted

            System.out.println("Average Case:");
            runAndTimeAllSorts(avgCase);

            System.out.println("Best Case:");
            runAndTimeAllSorts(bestCase);

            System.out.println("Worst Case:");
            runAndTimeAllSorts(worstCase);
        }
    }

    // Runs all three sorts and measures execution time using System.nanoTime()
    public static void runAndTimeAllSorts(int[] original) {
        int[] arr;

        // Selection Sort timing
        arr = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        sortingalg.selectionSort(arr);
        long end = System.nanoTime();
        System.out.println("Selection Sort: " + (end - start) / 1_000_000.0 + " ms");

        // Insertion Sort timing
        arr = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        sortingalg.insertionSort(arr);
        end = System.nanoTime();
        System.out.println("Insertion Sort: " + (end - start) / 1_000_000.0 + " ms");

        // Merge Sort timing
        arr = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        sortingalg.mergeSort(arr);
        end = System.nanoTime();
        System.out.println("Merge Sort: " + (end - start) / 1_000_000.0 + " ms");

        System.out.println();
    }

    // Generates random array for average-case testing
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
        return arr;
    }

    // Generates sorted array for best-case testing
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    // Generates reverse sorted array for worst-case testing
    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }
}

