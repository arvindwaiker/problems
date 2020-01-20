package io.awklabs.backtracking;

import java.util.stream.IntStream;

public class NQueen {

    private static boolean isSafe(int n, int board[][], int row, int col)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    /* A recursive utility function to solve N
       Queen problem */
    private static boolean solveNQueen(int n, int board[][], int col)
    {
        /* base case: If all queens are placed
           then return true */
        if (col >= n)
            return true;

        /* Consider this column and try placing
           this queen in all rows one by one */
        for (int i = 0; i < n; i++) {
            /* Check if the queen can be placed on
               board[i][col] */
            if (isSafe(n,board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;

                /* recur to place rest of the queens */
                if (solveNQueen(n, board, col + 1) == true)
                    return true;

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
            }
        }

        /* If the queen can not be placed in any row in
           this colum col, then return false */
        return false;
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] result = new int[n][n];
        if (solveNQueen(n, result, 0) == false) {
            System.out.print("Solution does not exist");
            return;
        }
        for(int[] i : result) {
            for(int j : i) {
                System.out.print(j + "-");
            }
            System.out.println();
        }
    }

}
