package _26_remove_duplicates_from_sorted_array;

/**
 * Update with next values while going ahead
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}