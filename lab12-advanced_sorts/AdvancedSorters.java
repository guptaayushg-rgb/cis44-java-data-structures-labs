import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // --- MergeSort ---
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) return; // Base case

        int mid = n / 2;

        // Divide
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        // Conquer
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // Combine
        merge(S, S1, S2, comp);
    }

    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator<K> comp) {
        int i = 0, j = 0, k = 0;

        // Merge elements while both arrays have elements
        while (i < S1.length && j < S2.length) {
            if (comp.compare(S1[i], S2[j]) <= 0) {
                S[k++] = S1[i++];
            } else {
                S[k++] = S2[j++];
            }
        }

        // Copy any remaining from S1
        while (i < S1.length) {
            S[k++] = S1[i++];
        }

        // Copy any remaining from S2
        while (j < S2.length) {
            S[k++] = S2[j++];
        }
    }

    // --- QuickSort ---
    public static <K> void quickSort(K[] S, Comparator<K> comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static <K> void quickSort(K[] S, Comparator<K> comp, int a, int b) {
        if (a >= b) return; // Base case

        int pivotIndex = partition(S, comp, a, b);

        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    private static <K> int partition(K[] S, Comparator<K> comp, int a, int b) {
        K pivot = S[a];  // Choose first element
        int left = a + 1;
        int right = b;

        while (true) {
            while (left <= right && comp.compare(S[left], pivot) <= 0) {
                left++;
            }
            while (left <= right && comp.compare(S[right], pivot) > 0) {
                right--;
            }

            if (left > right) break;

            // Swap left and right
            K temp = S[left];
            S[left] = S[right];
            S[right] = temp;

            left++;
            right--;
        }

        // Put pivot in correct spot
        K temp = S[a];
        S[a] = S[right];
        S[right] = temp;

        return right; // Pivot index
    }
}
