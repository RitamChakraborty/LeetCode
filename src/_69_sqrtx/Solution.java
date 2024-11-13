package _69_sqrtx;

class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        long start = 1;
        long end = x;

        while (start < end) {
            long mid = (start + end) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) return (int) mid;
            if (mid * mid < x) start = mid + 1;
            else end = mid - 1;
        }

        return (int) (start);
    }
}