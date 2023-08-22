package _287_find_the_duplicate_number;

import java.util.Arrays;

class Solution {
    public int findDuplicateBruteForce1(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }

        return -1;
    }

    public int findDuplicateBruteForce2(int[] nums) {
        int[] hash = new int[nums.length + 1];

        for (int i : nums) {
            if (hash[i] == 0) hash[i]++;
            else return i;
        }

        return -1;
    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = 0;

        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) return slow;
        }
    }
}
