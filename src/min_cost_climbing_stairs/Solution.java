package min_cost_climbing_stairs;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    private int climb(int[] cost, int index, int[] mem) {
        if (index >= cost.length) {
            return 0;
        }

        if (mem[index] != -1) {
            return mem[index];
        }

        int s1 = cost[index] + climb(cost, index + 2, mem);
        int s2;

        if (index == 0) {
            s2 = climb(cost, index + 1, mem);
        } else {
            s2 = cost[index] + climb(cost, index + 1, mem);
        }

        int result = Integer.min(s1, s2);
        mem[index] = result;

        return result;
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return 0;
        }

        int[] mem = new int[cost.length + 1];
        Arrays.fill(mem, -1);

        return climb(cost, 0, mem);
    }
}