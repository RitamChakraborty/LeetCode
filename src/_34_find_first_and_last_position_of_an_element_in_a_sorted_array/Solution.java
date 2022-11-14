package _34_find_first_and_last_position_of_an_element_in_a_sorted_array;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int i = Arrays.binarySearch(nums, target);

        if (i >= 0) {
            int s = i;
            while (s > 0 && nums[s - 1] == target) s = Arrays.binarySearch(nums, 0, s, target);
            int e = i;
            while (e < n - 1 && nums[e + 1] == target) e = Arrays.binarySearch(nums, e + 1, n, target);
            return new int[]{s, e};
        }

        return new int[]{-1, -1};
    }
}