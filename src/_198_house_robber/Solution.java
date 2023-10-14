package _198_house_robber;

import java.util.Arrays;

class Solution {
    private int robRecursion(int index, int n, int[] nums) {
        if (index >= n) return 0;
        return Integer.max(
                nums[index] + robRecursion(index + 2, n, nums),
                robRecursion(index + 1, n, nums)
        );
    }

    public int robRecursion(int[] nums) {
        return robRecursion(0, nums.length, nums);
    }

    private int robMemoization(int index, int n, int[] nums, int[] mem) {
        if (index >= n) return 0;
        if (mem[index] != -1) return mem[index];
        mem[index] = Integer.max(
                nums[index] + robMemoization(index + 2, n, nums, mem),
                robMemoization(index + 1, n, nums, mem)
        );
        return mem[index];
    }

    public int robMemoization(int[] nums) {
        int n = nums.length;
        int[] mem = new int[n];
        Arrays.fill(mem, -1);
        return robMemoization(0, n, nums, mem);
    }

    public int robTabulation(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] mem = new int[n];
        mem[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; --i) {
            int fast = nums[i];
            if (i != n - 2) fast += mem[i + 2];
            int second = mem[i + 1];
            mem[i] = Integer.max(fast, second);
        }

        return mem[0];
    }

    public int robSpaceOptimized(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int prev = nums[0];
        int prev1 = 0;

        for (int i = 1; i < n; ++i) {
            int take = nums[i];
            if (i != 1) take += prev1;
            int notTake = prev;
            int current = Integer.max(take, notTake);
            prev1 = prev;
            prev = current;
        }

        return prev;
    }
}