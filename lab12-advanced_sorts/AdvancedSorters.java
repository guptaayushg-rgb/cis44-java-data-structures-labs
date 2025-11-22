import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // sorts will be combined together
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) return; // foundation of the case

        int mid = n / 2;

        // will divide the elements
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);


        mergeSort(S1, comp);
        mergeSort(S2, comp);

       // will merge the elements
        merge(S, S1, S2, comp);
    }

    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator<K> comp) {
        int i = 0, j = 0, k = 0;

        // merge the arrays
        while (i < S1.length && j < S2.length) {
            if (comp.compare(S1[i], S2[j]) <= 0) {
                S[k++] = S1[i++];
            } else {
                S[k++] = S2[j++];
            }
        }


        while (i < S1.length) {
            S[k++] = S1[i++];
        }


        while (j < S2.length) {
            S[k++] = S2[j++];
        }
    }

    // sort
    public static <K> void quickSort(K[] S, Comparator<K> comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static <K> void quickSort(K[] S, Comparator<K> comp, int a, int b) {
        if (a >= b) return;

        int pivotIndex = partition(S, comp, a, b);

        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    // first element choosen
    private static <K> int partition(K[] S, Comparator<K> comp, int a, int b) {
        K pivot = S[a];
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

            // swtiched around
            K temp = S[left];
            S[left] = S[right];
            S[right] = temp;

            left++;
            right--;
        }

        // correct placement
        K temp = S[a];
        S[a] = S[right];
        S[right] = temp;

        return right;  
    }
}
