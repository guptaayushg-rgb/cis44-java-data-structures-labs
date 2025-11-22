import java.util.Comparator;

public class SimpleSorters {

   // array sorted using Bubble sort
    public static <K> void bubbleSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // inner loop

            for (int j = 0; j < n - 1 - i; j++) {

                if (comp.compare(S[j], S[j + 1]) > 0) {

                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;

                    swapped = true;
                }
            }

            // exit or end if no swaps have ccured
            if (!swapped) {
                break;
            }
        }
    }

   // array sorted using insertion
    public static <K> void insertionSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 1; i < n; i++) {
            K cur = S[i];
            int j = i - 1;
            // elements moved to right

            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            // insert in the correct place
            S[j + 1] = cur;
        }
    }
}
