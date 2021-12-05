package house_robber;

import java.util.HashMap;

class Solution {
    private final HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 1, 1, 2}));
    }

    private int rob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (map.containsKey(index)) {
            return map.get(index);
        }

        map.put(
                index,
                Integer.max((nums[index] + rob(nums, index + 2)),
                        rob(nums, index + 1))
        );

        return map.get(index);
    }

    public int rob(int[] nums) {
        return rob(nums, 0);
    }
}