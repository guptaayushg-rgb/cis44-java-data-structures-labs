public class maxsubarray {

    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        // Outer loop runs n times (i = 0 to n-1)
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            // Inner loop runs n-i times for each i
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j]; // Primitive operation: addition
                if (currentSum > maxSum) { // Primitive operation: comparison
                    maxSum = currentSum;   // Primitive operation: assignment
                }
            }
        }
        // Total primitive operations ≈ n(n+1)/2 → O(n^2)
        return maxSum;
    }

    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxEndingHere = arr[0]; // Assignment: O(1)
        int maxSoFar = arr[0];      // Assignment: O(1)
        // Single loop over array → n-1 iterations
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]); // Addition + comparison
            maxSoFar = Math.max(maxSoFar, maxEndingHere); // Comparison
        }
        // Each iteration does O(1) work → total O(n)
        return maxSoFar;
    }
}

