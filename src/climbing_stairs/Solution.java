package climbing_stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(10));
    }

    private void climb(int n) {
        if (n == 0) {
            ++count;
        }

        if (n > 0) {
            climb(n - 1);
            climb(n - 2);
            System.out.println(n + ":" + count);
        }
    }

    public int climbStairs(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; ++i) {
            int temp = a;
            a = b;
            b += temp;
        }

        return b;
    }
}
