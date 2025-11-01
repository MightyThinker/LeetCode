/*
 * Question 36: Valid Sudoku
 *
 ? Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated
 ? according to the following rules:
 ? 1. Each row must contain the digits 1-9 without repetition.
 ? 2. Each column must contain the digits 1-9 without repetition.
 ? 3. Each of the nine 3x3 sub-boxes must contain the digits 1-9 without repetition.
 */

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char value = board[i][j];

                if(value == '.') continue;

                String rowValue = value + " in row " + i;
                String colValue = value + " in column " + j;
                String boxValue = value + " in box " + (i / 3) + "-" + (j / 3);

                if(!seen.add(rowValue) || !seen.add(colValue) || !seen.add(boxValue)) return false;
            }
        }
        return true;
    }

    // Complexity:
    // Time Complexity: O(1), since the board size is fixed (9x9).
    // Space Complexity: O(1), since the maximum number of elements in the set is limited by the fixed size of the board.

    public static void main(String[] args) {
        ValidSudoku_36 solution = new ValidSudoku_36();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        boolean isValid = solution.isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + isValid);
    }
}