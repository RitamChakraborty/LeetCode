package _448_find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) result.add(i + 1);
        }

        return result;
    }
}
