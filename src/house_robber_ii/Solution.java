package house_robber_ii;

class Solution {
    public int rob(int[] nums, int start, int end) {
        int[] arr = new int[end - start + 1];
        arr[start] = nums[start];
        arr[start + 1] = nums[start + 1];

        for (int i = start + 2; i <= end; ++i) {
            arr[i] = Integer.max(nums[i] + arr[i - 2], arr[i - 1]);
        }

        return arr[arr.length - 1];
    }

    public int rob(int[] nums) {
        return Integer.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}