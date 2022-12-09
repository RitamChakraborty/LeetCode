package _51_n_queen;

import java.util.ArrayList;
import java.util.List;

/**
 * Check every position if at the queen is safe or not
 * For safety check look for already existing queen on left, upper diagonal and lower diagonal positions
 */
class Solution1 {
    private boolean isSafe(int row, int col, int n, char[][] board) {
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) if (board[i--][j--] == 'Q') return false;  // Upper diagonal
        i = row;
        j = col;
        while (j >= 0) if (board[i][j--] == 'Q') return false; // Left diagonal
        j = col;
        while (i < n && j >= 0) if (board[i++][j--] == 'Q') return false;   // Lower diagonal
        return true;
    }

    private void solve(int col, int n, char[][] board, List<List<String>> result) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (char[] i : board) list.add(new String(i));
            result.add(list);
            return;
        }

        for (int row = 0; row < n; ++row) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                solve(col + 1, n, board, result);
            }
            board[row][col] = '.';
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j) board[i][j] = '.';
        List<List<String>> result = new ArrayList<>();
        solve(0, n, board, result);
        return result;
    }
}

/**
 * In order to optimize it again we can keep an array which should point out the existing positions in
 * left, upper diagonal and lower diagonal positions
 * where the size of the array will be
 * left = n - 1
 * lower_diagonal = 2n - 1
 * upper_diagonal = 2n - 1
 * and the hashing formulas would be
 * left[row]
 * lower_diagonal[row + col]
 * upper_diagonal[n + col - row - 1]
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }

    private void solve(
            int col,
            int n,
            char[][] board,
            boolean[] left,
            boolean[] lowerDiagonal,
            boolean[] upperDiagonal,
            List<List<String>> result
    ) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (char[] i : board) list.add(new String(i));
            result.add(list);
            return;
        }

        for (int row = 0; row < n; ++row) {
            if (!left[row] && !lowerDiagonal[row + col] && !upperDiagonal[n + col - row - 1]) {
                left[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[n + col - row - 1] = true;
                board[row][col] = 'Q';
                solve(col + 1, n, board, left, lowerDiagonal, upperDiagonal, result);
                left[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n + col - row - 1] = false;
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j) board[i][j] = '.';
        List<List<String>> result = new ArrayList<>();
        boolean[] left = new boolean[n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        solve(0, n, board, left, lowerDiagonal, upperDiagonal, result);
        return result;
    }
}