package _120_triangle;

import java.util.Arrays;
import java.util.List;

class Solution {
    private int minimumTotal(int i, int j, List<List<Integer>> triangle, int[][] mem) {
        if (i == triangle.size() - 1) return triangle.get(i).get(j);
        if (j >= triangle.get(i).size()) return Integer.MAX_VALUE;
        if (mem[i][j] != -1) return mem[i][j];
        mem[i][j] = triangle.get(i).get(j) + Integer.min(
                minimumTotal(i + 1, j, triangle, mem),
                minimumTotal(i + 1, j + 1, triangle, mem)
        );
        return mem[i][j];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] mem = new int[m][m];
        for (int[] i : mem) Arrays.fill(i, -1);
        return minimumTotal(0, 0, triangle, mem);
    }
}