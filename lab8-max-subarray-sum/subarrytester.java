import java.util.Random;

public class subarrytester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            int[] array = generateRandomArrayWithNegatives(n);

            long start = System.currentTimeMillis();
            int max1 = maxsubarray.bruteForceMaxSum(array);
            long end = System.currentTimeMillis();
            System.out.println("Brute-force max sum: " + max1 + ", Time: " + (end - start) + " ms");

            start = System.currentTimeMillis();
            int max2 = maxsubarray.kadanesAlgorithmMaxSum(array);
            end = System.currentTimeMillis();
            System.out.println("Kadane's max sum: " + max2 + ", Time: " + (end - start) + " ms");
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(201) - 100; // Random integers from -100 to 100
        }
        return arr;
    }
}

