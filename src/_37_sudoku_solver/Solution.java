package _37_sudoku_solver;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Character> validAnswers(char[][] board, Point point) {
        int row = point.x;
        int col = point.y;
        List<Character> validAnswers = new ArrayList<>();

        for (char i = '1'; i <= '9'; ++i) {
            boolean valid = true;

            for (int j = 0; j < 9; ++j) {
                if (board[row][j] == i) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                for (int j = 0; j < 9; ++j) {
                    if (board[j][col] == i) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                int rowM = row - (row % 3);
                int colM = col - (col % 3);

                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; ++b) {
                        if (board[rowM + a][colM + b] == i) {
                            valid = false;
                            break;
                        }
                    }
                }
            }

            if (valid) validAnswers.add(i);
        }

        return validAnswers;
    }

    private boolean solveSudoku(int index, List<Point> emptyCells, char[][] board) {
        if (index == emptyCells.size()) return true;
        Point point = emptyCells.get(index);
        List<Character> validAnswers = validAnswers(board, point);

        for (char i : validAnswers) {
            board[point.x][point.y] = i;
            if (solveSudoku(index + 1, emptyCells, board)) return true;
            board[point.x][point.y] = '.';
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        List<Point> emptyCells = new ArrayList<>();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    emptyCells.add(new Point(i, j));
                }
            }
        }

        solveSudoku(0, emptyCells, board);
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
