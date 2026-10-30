package _283_move_zeroes;

/**
 * Shift to left
 */
class SolutionBruteForce {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int k = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            if (num == 0) {
                for (int j = i; j < k; j++) {
                    nums[j] = nums[j + 1];
                }

                nums[k--] = 0;
            }
        }
    }
}

/**
 * Look ahead pointer: Keep a slow pointer and the firstPointer. The fast pointer is look ahead.
 * If fast pointer find a nonzero swap with the slow pointer
 */
class SolutionBest {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int slowPointer = 0;
        int fastPointer = 0;

        while (fastPointer < n) {
            if (nums[fastPointer] != 0) {
                int temp = nums[slowPointer];
                nums[slowPointer] = nums[fastPointer];
                nums[fastPointer] = temp;
                slowPointer++;
            }

            fastPointer++;
        }


    }
}