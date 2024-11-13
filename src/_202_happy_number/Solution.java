package _202_happy_number;

import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * Brute Force
     */
    public boolean isHappy1(int value) {
        Set<Long> set = new HashSet<>();
        set.add((long) value);
        long sum = (long) value;

        while (true) {
            long n = sum;
            sum = 0;

            while (n != 0) {
                long num = n % 10;
                sum += num * num;
                n /= 10;
            }

            if (sum == 1) return true;
            if (set.contains(sum)) return false;
            set.add(sum);
        }
    }

    private int squareSum(int num) {
        int sum = 0;

        while (num != 0) {
            int n = num % 10;
            sum += n * n;
            num /= 10;
        }

        return sum;
    }

    /**
     * Optimized
     */
    public boolean isHappy2(int value) {
        int slow = value;
        int fast = squareSum(value);

        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }

        return slow == 1;
    }
}
