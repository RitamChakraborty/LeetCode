package _53_maxium_subarray;

public class Solution {
    public int maxSubArray(int[] arr) {
        int max = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; ++i) {
            maxSoFar = Integer.max(maxSoFar + arr[i], arr[i]);
            max = Integer.max(max, maxSoFar);
        }

        return max;
    }

    /**
     * Check for every single sub array. Trust me dude, 2 loops is enough
     */
    class SolutionBruteForce {
        public int maxSubArray(int[] nums) {
            int maxCost = Integer.MIN_VALUE;
            int n = nums.length;

            for (int j = 0; j < n; j++) {
                int cost = 0;

                for (int k = j; k < n; k++) {
                    cost += nums[k];
                    maxCost = Integer.max(maxCost, cost);
                }
            }

            return maxCost;
        }
    }

    /**
     * Kadane
     * Do not carry a negative sum, as it only reduces the overall total. But compare the max with the current value
     */
    class SolutionBest {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                int currentSum = nums[i] + sum;
                max = Integer.max(currentSum, max);
                sum = Integer.max(currentSum, 0);
            }

            return max;
        }
    }
}
