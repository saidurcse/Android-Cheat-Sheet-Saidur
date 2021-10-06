import java.io.*;
import java.util.*;
import javafx.util.Pair;

public class NQueenProblem {
    
	/*
     * Given a chess board of size N x N, determine how many ways N queens can be placed on this board
     * so that no two queens attack each other.
     *
     * A queen can move horizontally, vertically and diagonally on a chess board.
     * One queen can be attacked by another queen if it is present in the same row, column, or diagonal
     * of that queen.
     *
     * Step 1: Place a queen in the first column of the first row
     * Step 2: Now place a queen in first such column of 2nd row where placement is permissible i.e.
     * current queen is not being attacked by any queen already on board. If no such column is found,
     * backtrack to the previous row and try to place the queen in next column of that row.
     * Step 3: Continue this until we reach the last row of the board.
     * Step 4: When a queen is placed in the last row, that is a solution.
     * After finding a solution, backtrack to the previous row to find the next solution.
     * Try to find another column in the previous row where placement is permissible.
     *
     * Runtime Complexity:
     * Factorial, O(n!).
     *
     * Memory Complexity:
     * Exponential
     * */

    private static boolean isValidMove(int proposed_row,
                                       int proposed_col,
                                       List<Integer> solution) {

        for (int i = 0; i < proposed_row; ++i) {
            int old_row = i;
            int old_col = solution.get(i);

            int diagonal_offset = proposed_row - old_row;
            if (old_col == proposed_col ||
                    old_col == proposed_col - diagonal_offset ||
                    old_col == proposed_col + diagonal_offset) {
                return false;
            }
        }

        return true;
    }

    protected static void solveNQueensRec(int n,
                                          List<Integer> solution,
                                          int row,
                                          List<List<Integer>> results) {

        if (row == n) {
            results.add(new ArrayList<>(solution));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (isValidMove(row, i, solution)) {
                solution.set(row, i);
                solveNQueensRec(n, solution, row + 1, results);
            }
        }
    }

    private static void solveNQueens(int n,
                                     List<List<Integer>> results) {

        List<Integer> solution = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            solution.add(-1);
        }
        solveNQueensRec(n, solution, 0, results);
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();

        solveNQueens(8, results);
        System.out.println("Total Solutions Count: " + results.size());
        for (List<Integer> result : results) {
            for (Integer r : result) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
        System.out.println("Total Solutions Count = " + results.size());
    }

}


/* Output: 
 * 
 * Total Solutions Count: 92
0 4 7 5 2 6 1 3 
0 5 7 2 6 3 1 4 
0 6 3 5 7 1 4 2 
0 6 4 7 1 3 5 2 
1 3 5 7 2 0 6 4 
1 4 6 0 2 7 5 3 
1 4 6 3 0 7 5 2 
1 5 0 6 3 7 2 4 
1 5 7 2 0 3 6 4 
1 6 2 5 7 4 0 3 
1 6 4 7 0 3 5 2 
1 7 5 0 2 4 6 3 
2 0 6 4 7 1 3 5 
2 4 1 7 0 6 3 5 
2 4 1 7 5 3 6 0 
2 4 6 0 3 1 7 5 
2 4 7 3 0 6 1 5 
2 5 1 4 7 0 6 3 
2 5 1 6 0 3 7 4 
2 5 1 6 4 0 7 3 
2 5 3 0 7 4 6 1 
2 5 3 1 7 4 6 0 
2 5 7 0 3 6 4 1 
2 5 7 0 4 6 1 3 
2 5 7 1 3 0 6 4 
2 6 1 7 4 0 3 5 
2 6 1 7 5 3 0 4 
2 7 3 6 0 5 1 4 
3 0 4 7 1 6 2 5 
3 0 4 7 5 2 6 1 
3 1 4 7 5 0 2 6 
3 1 6 2 5 7 0 4 
3 1 6 2 5 7 4 0 
3 1 6 4 0 7 5 2 
3 1 7 4 6 0 2 5 
3 1 7 5 0 2 4 6 
3 5 0 4 1 7 2 6 
3 5 7 1 6 0 2 4 
3 5 7 2 0 6 4 1 
3 6 0 7 4 1 5 2 
3 6 2 7 1 4 0 5 
3 6 4 1 5 0 2 7 
3 6 4 2 0 5 7 1 
3 7 0 2 5 1 6 4 
3 7 0 4 6 1 5 2 
3 7 4 2 0 6 1 5 
4 0 3 5 7 1 6 2 
4 0 7 3 1 6 2 5 
4 0 7 5 2 6 1 3 
4 1 3 5 7 2 0 6 
4 1 3 6 2 7 5 0 
4 1 5 0 6 3 7 2 
4 1 7 0 3 6 2 5 
4 2 0 5 7 1 3 6 
4 2 0 6 1 7 5 3 
4 2 7 3 6 0 5 1 
4 6 0 2 7 5 3 1 
4 6 0 3 1 7 5 2 
4 6 1 3 7 0 2 5 
4 6 1 5 2 0 3 7 
4 6 1 5 2 0 7 3 
4 6 3 0 2 7 5 1 
4 7 3 0 2 5 1 6 
4 7 3 0 6 1 5 2 
5 0 4 1 7 2 6 3 
5 1 6 0 2 4 7 3 
5 1 6 0 3 7 4 2 
5 2 0 6 4 7 1 3 
5 2 0 7 3 1 6 4 
5 2 0 7 4 1 3 6 
5 2 4 6 0 3 1 7 
5 2 4 7 0 3 1 6 
5 2 6 1 3 7 0 4 
5 2 6 1 7 4 0 3 
5 2 6 3 0 7 1 4 
5 3 0 4 7 1 6 2 
5 3 1 7 4 6 0 2 
5 3 6 0 2 4 1 7 
5 3 6 0 7 1 4 2 
5 7 1 3 0 6 4 2 
6 0 2 7 5 3 1 4 
6 1 3 0 7 4 2 5 
6 1 5 2 0 3 7 4 
6 2 0 5 7 4 1 3 
6 2 7 1 4 0 5 3 
6 3 1 4 7 0 2 5 
6 3 1 7 5 0 2 4 
6 4 2 0 5 7 1 3 
7 1 3 0 6 4 2 5 
7 1 4 2 0 6 3 5 
7 2 0 5 1 4 6 3 
7 3 0 2 5 1 6 4 
 * Total Solutions Count = 92
 *
 */
