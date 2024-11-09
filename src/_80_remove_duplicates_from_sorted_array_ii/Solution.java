package _80_remove_duplicates_from_sorted_array_ii;

class Solution {
    /**
     * Optimized
     */
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;

        while (i < n) {
            int count = 1;

            while (i + 1 < n && nums[i + 1] == nums[i]) {
                count++;
                i++;
            }

            for (int k = 0; k < Integer.min(2, count); ++k) {
                nums[j++] = nums[i];
            }

            i++;
        }

        return j;
    }

    /**
     * Best
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length < 2) return nums.length;

        int index = 2;

        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
