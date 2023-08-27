package _62_unique_paths;

import java.util.Arrays;

public class Solution {
    public int uniquePathsBruteForce(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i == m || j == n) return 0;
        return uniquePathsBruteForce(i + 1, j, m, n) + uniquePathsBruteForce(i, j + 1, m, n);
    }

    public int uniquePathsBruteForce(int m, int n) {
        return uniquePathsBruteForce(0, 0, m, n);
    }

    public int uniquePathsBetterApproach(int i, int j, int m, int n, int[][] mem) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i == m || j == n) return 0;
        if (mem[i][j] != -1) return mem[i][j];
        mem[i][j] = uniquePathsBetterApproach(i + 1, j, m, n, mem) + uniquePathsBetterApproach(i, j + 1, m, n, mem);
        return mem[i][j];
    }

    public int uniquePathsBetterApproach(int m, int n) {
        int[][] mem = new int[m][n];

        for (int[] i : mem) {
            Arrays.fill(i, -1);
        }

        return uniquePathsBetterApproach(0, 0, m, n, mem);
    }

    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        int R = m - 1;
        double res = 1;
        for (int i = 1; i <= R; i++) res = res * (N - R + i) / i;
        return (int) res;
    }
}
