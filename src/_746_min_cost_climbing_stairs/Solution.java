package _746_min_cost_climbing_stairs;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    private int climb(int[] cost, int index, int[] mem) {
        if (index >= cost.length) {
            return 0;
        }

        if (mem[index] != -1) {
            return mem[index];
        }

        int s1 = cost[index] + climb(cost, index + 2, mem);
        int s2;

        if (index == 0) {
            s2 = climb(cost, index + 1, mem);
        } else {
            s2 = cost[index] + climb(cost, index + 1, mem);
        }

        int result = Integer.min(s1, s2);
        mem[index] = result;

        return result;
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return 0;
        }

        int[] mem = new int[cost.length + 1];
        Arrays.fill(mem, -1);

        return climb(cost, 0, mem);
    }

    /**
     * start from the first and second stairs and after combining the current cost check which one is minium between
     * the n + 1 or n + 2 steps
     */
    private class SolutionBruteForce {
        private int climb(int[] cost, int i) {
            int n = cost.length;
            if (i >= n) return 0;
            return cost[i] + Integer.min(climb(cost, i + 1), climb(cost, i + 2));
        }

        public int minCostClimbingStairsBruteForce(int[] cost) {
            return Integer.min(climb(cost, 0), climb(cost, 1));
        }
    }

    /**
     * Store the current cost in memory while visiting it, if not visited calculate the cost and store in memrory
     */
    private class SolutionBetter {
        private int climb(int[] cost, int i, int[] dp) {
            int n = cost.length;
            if (i >= n) return 0;

            // contains some value
            if (dp[i] != -1) return dp[i];
            // Calculate the cost
            int minCost = cost[i] + Integer.min(climb(cost, i + 1, dp), climb
                    (cost, i + 2, dp));
            // Store the value
            dp[i] = minCost;

            return minCost;
        }

        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length];
            Arrays.fill(dp, -1);
            return Integer.min(climb(cost, 0, dp), climb(cost, 1, dp));
        }
    }

    /**
     * Keep two pointers, one step behind and two steps behind, as you move along calculate the current values of them
     * And at last return the minimum between the two
     */
    class SolutionBestNoDP {
        public int minCostClimbingStairs(int[] cost) {
            int oneStepBehind = cost[1];
            int twoStepsBehind = cost[0];

            for (int i = 2; i < cost.length; i++) {
                int current = cost[i] + Integer.min(oneStepBehind, twoStepsBehind);
                twoStepsBehind = oneStepBehind;
                oneStepBehind = current;
            }

            return Integer.min(oneStepBehind, twoStepsBehind);
        }
    }
}