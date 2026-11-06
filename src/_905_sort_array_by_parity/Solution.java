package _905_sort_array_by_parity;

/**
 * Swap values as you move ahead
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        return nums;
    }
}