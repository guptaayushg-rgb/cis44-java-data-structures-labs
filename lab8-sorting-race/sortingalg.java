public class sortingalg {

    // Selection Sort: O(n^2) in all cases
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // Outer loop runs n-1 times
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Inner loop searches the minimum in remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) { // Comparison primitive operation
                    minIndex = j;            // Assignment primitive operation
                }
            }
            // Swap elements
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            // Swap is O(1)
        }
        // Overall primitive operations ~ n(n-1)/2 → O(n^2)
    }

    // Insertion Sort: O(n^2) worst/average, O(n) best case
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];   // Assignment O(1)
            int j = i - 1;
            // Shift elements to the right until correct position for key
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; // Assignment
                j--;
            }
            arr[j + 1] = key;   // Place key in correct position
        }
        // Best case: already sorted → inner loop never executes → O(n)
        // Worst case: reverse sorted → inner loop executes i times for each i → O(n^2)
    }

    // Merge Sort: Divide-and-conquer O(n log n)
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return; // Base case: one element
        int mid = left + (right - left) / 2;
        // Divide array into two halves recursively
        mergeSortRecursive(arr, temp, left, mid);
        mergeSortRecursive(arr, temp, mid + 1, right);
        // Merge sorted halves
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        // Merge elements in sorted order
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // Copy remaining elements
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        // Copy temp array back to original
        for (int idx = left; idx <= right; idx++) arr[idx] = temp[idx];
        // Each level of recursion does O(n), depth = log n → O(n log n)
    }
}

