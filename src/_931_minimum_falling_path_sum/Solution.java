package _931_minimum_falling_path_sum;

import java.util.Arrays;

class Solution {
    private int minFallingPathSumMemoization(int i, int j, int[][] matrix, int[][] mem) {
        int n = matrix.length;
        if (j < 0 || j == n) return Integer.MAX_VALUE;
        if (i == n - 1) return matrix[i][j];
        if (mem[i][j] != -1) return mem[i][j];
        mem[i][j] = matrix[i][j] + Integer.min(
            minFallingPathSumMemoization(i + 1, j - 1, matrix, mem),
            Integer.min(
                minFallingPathSumMemoization(i + 1, j, matrix, mem),
                minFallingPathSumMemoization(i + 1, j + 1, matrix, mem)
            )
        );
        return mem[i][j];
    }

    public int minFallingPathSumMemoization(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        int[][] mem = new int[n][n];
        for (int[] i : mem) Arrays.fill(i, -1);

        for (int i = 0; i < n; ++i) {
            int sum = minFallingPathSumMemoization(0, i, matrix, mem);
            min = Integer.min(min, sum);
        }

        return min;
    }

    public int minFallingPathSumTabulation(int[][] matrix) {
        int n = matrix.length;
        int[][] mem = new int[n][n];
        System.arraycopy(matrix[0], 0, mem[0], 0, n);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int u = matrix[i][j] + mem[i - 1][j];
                int ld = matrix[i][j];

                if (j - 1 < 0) {
                    ld = Integer.MAX_VALUE;
                } else {
                    ld += mem[i - 1][j - 1];
                }

                int rd = matrix[i][j];

                if (j + 1 == n) {
                    rd = Integer.MAX_VALUE;
                } else {
                    rd += mem[i - 1][j + 1];
                }

                mem[i][j] = Integer.min(u, Integer.min(ld, rd));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) min = Integer.min(min, mem[n - 1][i]);

        return min;
    }
}