package _50_powx_n;

public class Solution {
    public double myPowBruteForce(double x, int n) {
        int tempN = n;
        if (tempN < 0) tempN *= -1;
        double ans = 1;

        for (int i = 0; i < tempN; ++i) {
            ans *= x;
        }

        return n < 0 ? 1 / ans : ans;
    }

    public double myPow(double x, int n) {
        long tempN = n;
        if (tempN < 0)  tempN *= -1;
        double ans = 1;

        while (tempN > 0) {
            if (tempN % 2 == 0) {
                x *= x;
                tempN /= 2;
            } else {
                ans *= x;
                tempN--;
            }
        }

        return n < 0 ? 1 / ans : ans;
    }
}
