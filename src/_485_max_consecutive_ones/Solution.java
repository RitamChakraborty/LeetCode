package _485_max_consecutive_ones;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i : nums) {
            if (i != 1) {
                max = Integer.max(max, count);
                count = 0;
            } else {
                ++count;
            }
        }

        return Integer.max(max, count);
    }
}
