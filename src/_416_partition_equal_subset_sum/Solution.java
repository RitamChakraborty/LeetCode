package _416_partition_equal_subset_sum;

import java.util.Arrays;

class Solution {
    private boolean subsetSum(int i, int target, int[] nums, int[][] mem) {
        if (target == 0) return true;
        if (target < 0) return false;
        if (i == nums.length) return false;
        if (mem[i][target] != -1) return mem[i][target] == 1;
        mem[i][target] = subsetSum(i + 1, target, nums, mem) ||
                subsetSum(i + 1, target - nums[i], nums, mem)
                ? 1 : 0;
        return mem[i][target] == 1;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        int[][] mem = new int[n][target + 1];
        for (int[] i : mem) Arrays.fill(i, -1);
        return subsetSum(0, target, nums, mem);
    }
}