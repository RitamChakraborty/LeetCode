package _73_set_matrix_zeros;

public class Solution {
    /**
     * <h1>Brute Force</h1>
     *
     * @param matrix
     */
    public void setZeroes1(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] backup = new int[m][n];

        for (int i = 0; i < m; ++i) {
            System.arraycopy(arr[i], 0, backup[i], 0, n);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int num = backup[i][j];

                if (num == 0) {
                    for (int k = 0; k < n; ++k) {
                        arr[i][k] = 0;
                    }

                    for (int k = 0; k < m; ++k) {
                        arr[k][j] = 0;
                    }
                }
            }
        }
    }

    /**
     * # Optimal Solution
     * <p>
     * When encounter an zero mark first row and column as zero
     * <p>
     * Keep first row and first column as memory. Point (0, 0) is the intersection point.
     * So keep the value separated for the first row in a variable.
     * Update the non first row and column value first. Then update the first row and column
     *
     * @param arr the
     */
    public void setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int intersection = 1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;

                    if (j == 0) {
                        intersection = 0;
                    } else {
                        arr[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (arr[i][0] == 0 || arr[0][j] == 0) arr[i][j] = 0;
            }
        }

        if (arr[0][0] == 0) {
            for (int i = 0; i < n; ++i) {
                arr[0][i] = 0;
            }
        }

        if (intersection == 0) {
            for (int i = 0; i < m; ++i) {
                arr[i][0] = 0;
            }
        }
    }
}
