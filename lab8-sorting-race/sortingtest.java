import java.util.Arrays;
import java.util.Random;

public class sortingtest {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            int[] avgCase = generateRandomArray(n);
            int[] bestCase = generateSortedArray(n);
            int[] worstCase = generateReverseSortedArray(n);

            System.out.println("Average Case:");
            runAndTimeAllSorts(avgCase);

            System.out.println("Best Case:");
            runAndTimeAllSorts(bestCase);

            System.out.println("Worst Case:");
            runAndTimeAllSorts(worstCase);
        }
    }

    public static void runAndTimeAllSorts(int[] original) {
        int[] arr;

        arr = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        sortingalg.selectionSort(arr);
        long end = System.nanoTime();
        System.out.println("Selection Sort: " + (end - start) / 1_000_000.0 + " ms");

        arr = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        sortingalg.insertionSort(arr);
        end = System.nanoTime();
        System.out.println("Insertion Sort: " + (end - start) / 1_000_000.0 + " ms");

        arr = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        sortingalg.mergeSort(arr);
        end = System.nanoTime();
        System.out.println("Merge Sort: " + (end - start) / 1_000_000.0 + " ms");

        System.out.println();
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }
}
