package _52_n_queens_ii;

class Solution {
    private int solve(
            int col,
            int n,
            boolean[][] board,
            boolean[] left,
            boolean[] lowerDiagonal,
            boolean[] upperDiagonal
    ) {
        if (col == n) return 1;

        int count = 0;

        for (int row = 0; row < n; ++row) {
            if (!left[row] && !lowerDiagonal[row + col] && !upperDiagonal[n + col - row - 1]) {
                left[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[n + col - row - 1] = true;
                board[row][col] = true;
                count += solve(col + 1, n, board, left, lowerDiagonal, upperDiagonal);
                left[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n + col - row - 1] = false;
                board[row][col] = false;
            }
        }

        return count;
    }

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] left = new boolean[n + 1];
        boolean[] lowerDiagonal = new boolean[2 * n + 1];
        boolean[] upperDiagonal = new boolean[2 * n + 1];
        return solve(0, n, board, left, lowerDiagonal, upperDiagonal);
    }
}