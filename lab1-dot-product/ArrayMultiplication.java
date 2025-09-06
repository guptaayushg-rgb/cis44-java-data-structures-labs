import java.util.Random;

public class ArrayMultiplication {
    public static void main(String[] args) {
        int n = 5;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(10);
            b[i] = rand.nextInt(10);
            c[i] = a[i] * b[i];
        }

        System.out.print("Array a: ");
        printArray(a);

        System.out.print("Array b: ");
        printArray(b);

        System.out.print("Array c: ");
        printArray(c);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
