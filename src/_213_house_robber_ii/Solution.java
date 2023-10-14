package _213_house_robber_ii;

class Solution {
    private int rob(int[] nums, int start, int end) {
        int prev = nums[start];
        int prev1 = 0;

        for (int i = start + 1; i < end; ++i) {
            int take = nums[i];
            if (i != start + 1) take += prev1;
            int notTake = prev;
            int current = Integer.max(take, notTake);
            prev1 = prev;
            prev = current;
        }

        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Integer.max(rob(nums, 1, n), rob(nums, 0, n - 1));
    }
}