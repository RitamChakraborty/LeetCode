package _977_squares_of_sorted_array;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

/**
 * Two Pointers: Start filling up the result form the end by comparing the left and the right pointer
 * Time: O(N)
 * Space: O(N)
 */
class SolutionOptimized {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; left <= right && i >= 0; i--) {
            int a = Math.abs(nums[left]);
            int b = Math.abs(nums[right]);

            if (a > b) {
                result[i] = a * a;
                left++;
            } else {
                result[i] = b * b;
                right--;
            }
        }

        return result;
    }
}
