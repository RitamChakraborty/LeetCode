package _36_valid_suduku;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                for (int k = 0; k < 9; ++k) {
                    if (j != k && board[i][k] == board[i][j]) return false;
                    if (i != k && board[k][j] == board[i][j]) return false;
                }

                for (int k = 0; k < 3; ++k) {
                    for (int l = 0; l < 3; ++l) {
                        int rowM = i - (i % 3) + k;
                        int colM = j - (j % 3) + l;
                        if (rowM != i && colM != j && board[rowM][colM] == board[i][j]) return false;
                    }
                }
            }
        }

        return true;
    }
}