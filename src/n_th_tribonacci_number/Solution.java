package n_th_tribonacci_number;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(25));
    }

    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        } else if (n == 2) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 3; i < n + 1; ++i) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }

        return c;
    }
}