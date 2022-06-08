package jump_game_ii;

class Solution {
    private int jump(int[] nums, int j, int count, int[] mem) {
        int n = nums.length;

        if (j == n - 1) {
            return count;
        } else if (j >= n) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        for (int i = nums[j]; i >= 1; --i) {
            min = Integer.min(min, jump(nums, i + j, count + 1, mem));
        }

        mem[j] = min;

        return min;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] mem = new int[n];

        for (int i = n - 2; i >= 0; --i) {
            int min = 9999999;

            for (int j = nums[i]; j >= 1; --j) {
                if (i + j < n) {
                    min = Integer.min(min, mem[i + j]);
                }
            }

            mem[i] = min + 1;
        }

        return mem[0];
    }
}