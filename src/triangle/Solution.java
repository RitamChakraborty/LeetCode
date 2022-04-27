package triangle;

import java.util.List;

class Solution {
    private int minimumTotal(int i, int j, List<List<Integer>> list, int[][] mem) {
        int n = list.size();

        if (i == n || j == n) {
            return 0;
        } else if (mem[i][j] != Integer.MAX_VALUE) {
            return mem[i][j];
        } else {
            int a = minimumTotal(i + 1, j, list, mem);
            int b = minimumTotal(i + 1, j + 1, list, mem);
            int min = Integer.min(a, b) + list.get(i).get(j);
            mem[i][j] = min;
            return min;
        }
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] mem = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                mem[i][j] = Integer.MAX_VALUE;
            }
        }

        return minimumTotal(0, 0, triangle, mem);
    }
}
