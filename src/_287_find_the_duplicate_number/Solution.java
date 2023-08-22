package _287_find_the_duplicate_number;

class Solution {
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
