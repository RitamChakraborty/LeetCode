package _70_climbing_stairs;

public class Solution {
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

    public int climbStairs1(int n) {
        int last = 1;
        int secondLast = 1;

        for (int i = n - 2; i >= 0; i--) {
            int current = last + secondLast;
            last = secondLast;
            secondLast = current;
        }

        return secondLast;
    }
}
