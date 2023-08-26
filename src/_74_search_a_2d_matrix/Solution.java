package _74_search_a_2d_matrix;

public class Solution {
    public boolean searchMatrixBruteForce(int[][] matrix, int target) {
        int n = matrix[0].length;

        for (int[] ints : matrix) {
            for (int j = 0; j < n; ++j) {
                if (ints[j] == target) return true;
            }
        }

        return false;
    }

    public boolean searchMatrixOptimal1(int[][] matrix, int target) {
        for (int[] i : matrix) {
            int m = i.length - 1;
            if (i[m] >= target) {
                int low = 0;
                int high = m;

                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (i[mid] < target) low = mid + 1;
                    else if (i[mid] > target) high = mid - 1;
                    else return true;
                }
                break;
            }
        }

        return false;
    }

    public boolean searchMatrixOptimal2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int r = mid / n;
            int c = mid % n;

            if (matrix[r][c] < target) low = mid + 1;
            else if (matrix[r][c] > target) high = mid - 1;
            else return true;
        }

        return false;
    }
}
