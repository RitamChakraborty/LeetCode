package _45_jump_game_ii;

class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            int max = 0;

            for (int i = left; i <= right; ++i) {
                max = Integer.max(max, i + nums[i]);
            }

            left = right + 1;
            right = max;
            ++count;
        }

        return count;
    }
}