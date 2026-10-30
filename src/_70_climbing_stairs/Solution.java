package _70_climbing_stairs;

import java.util.Arrays;

public class Solution {
    public int climbStairs(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; ++i) {
            int temp = a;
            a = b;
            b += temp;
        }

        return b;
    }

    public int climbStairs1(int n) {
        int last = 1;
        int secondLast = 1;

        for (int i = n - 2; i >= 0; i--) {
            int current = last + secondLast;
            last = secondLast;
            secondLast = current;
        }

        return secondLast;
    }

    public int climbStairsBruteForce(int n) {
       if (n < 0) return 0;
       if (n == 0) return 1;
       return climbStairsBruteForce(n - 1) + climbStairsBruteForce(n - 2);
    }

    private int climbStairs2(int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (dp[n] != -1) return dp[n];
        int count = climbStairs2(n - 1, dp) + climbStairs2(n - 2, dp);
        dp[n] = count;
        return count;
    }

    /**
     * *1D DP*
     * There are two ways to reach top, one step or two steps
     * Memorize every step after stepping on it so that value can be used later
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairs2(n, dp);
    }
}
