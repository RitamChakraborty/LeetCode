package _64_minimum_path_sum;

import java.util.Arrays;

class Solution {
    private int minPathSum(int i, int m, int j, int n, int[][] grid, int[][] mem) {
        if (i == m - 1 && j == n - 1) return grid[i][j];
        if (i == m || j == n) return Integer.MAX_VALUE;
        if (mem[i][j] != -1) return mem[i][j];
        mem[i][j] = grid[i][j] + Integer.min(
            minPathSum(i + 1, m, j, n, grid, mem),
            minPathSum(i, m, j + 1, n, grid, mem)
        );
        return mem[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] mem = new int[m][n];
        for (int[] i : mem) Arrays.fill(i, -1);
        return minPathSum(0, m, 0, n, grid, mem);
    }
}