package jump_game;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 0, 0}));
    }

//    public boolean canJump(int[] nums) {
//        return canJump(nums, 0, new int[nums.length - 1]);
//    }

    private boolean canJump(int[] arr, int i, int[] mem) {
        int n = arr.length;

        if (i >= n) {
            return false;
        } else if (i == n - 1) {
            return true;
        } else if (mem[i] != 0) {
            return mem[i] == 2;
        }

        boolean result = false;

        for (int j = arr[i]; j >= 1; --j) {
            if (i + j < n) {
                result = result || canJump(arr, i + j, mem);
            }
        }

        mem[i] = result ? 2 : 1;

        return result;
    }

    public boolean canJump(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return true;
        }

        int max = 1;

        for (int i = 0; i < n; ++i) {
            int num = arr[i];
            --max;

            if (num == 0) {
                if (i == n - 1 && max < 0) {
                    return false;
                } else if (i != n - 1 && max < 1) {
                    return false;
                }
            }

            max = Integer.max(max, arr[i]);
        }

        return true;
    }
}