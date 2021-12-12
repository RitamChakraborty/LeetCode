package house_robber_i;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
//        System.out.println(new Solution().rob(new int[]{200, 3, 140, 20, 10}));
        System.out.println(new Solution().rob(new int[]{1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 5, 3}));
        /*
        [1,1,3,6,7,10,7,1,8,5,9,1,4,4,3]
         */
    }

    public int rob(int[] nums, int index, boolean flag) {
        if (index >= nums.length) {
            return 0;
        }

        if (map.get(index) != null) {
            return map.get(index);
        }

        int sum1;

        if (index == 0) {
            int[] arr = new int[nums.length - 1];
            System.arraycopy(nums, 0, arr, 0, nums.length - 1);
            int s1 = nums[index] + rob(arr, index + 2, true);
            map.clear();
            int s2 = rob(nums, index + 2, false);
            sum1 = Integer.max(s1, s2);
            System.out.println(s1 + " " + s2);
        } else {
            sum1 = nums[index] + rob(nums, index + 2, false);
        }

        int sum2 = rob(nums, index + 1, false);
        map.put(index, Math.max(sum1, sum2));

        return map.get(index);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return rob(nums, 0, false);
    }
}