package _509_fibonacci_number;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(30));
    }

    public int fibonacci(int[] arr, int n) {
        if (n < 2) {
            return n;
        }

        if (arr[n] == -1) {
            arr[n] = fibonacci(arr, n - 1) + fibonacci(arr, n - 2);
        }

        return arr[n];
    }

    public int fib(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        return fibonacci(arr, n);
    }
}