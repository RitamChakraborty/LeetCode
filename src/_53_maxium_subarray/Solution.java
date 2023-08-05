package _53_maxium_subarray;

public class Solution {
    public int maxSubArrayBruteForce(int[] arr) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            int sum = 0;

            for (int j = i; j < n; ++j) {
                sum += arr[j];
                max = Integer.max(max, sum);
            }
        }

        return max;
    }

    public int maxSubArray(int[] arr) {
        int maxSoFar = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] + maxSoFar < arr[i]) {
                maxSoFar = arr[i];
            } else {
                maxSoFar += arr[i];
            }

            max = Integer.max(max, maxSoFar);
        }

        return max;
    }
}
