package _167_two_sum_ii_input_array_is_sorted;

class Solution {
    public int[] twoSum(int[] arr, int target) {
        for (int i = 0, j = arr.length - 1; i < j;) {
            int sum = arr[i] + arr[j];
            if (sum == target) return new int[]{i + 1, j + 1};
            else if (sum > target) --j;
            else ++i;
        }
        return null;
    }
}
