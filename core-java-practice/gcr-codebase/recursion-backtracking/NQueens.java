
import java.util.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        int[] queenCol = new int[n];

        backtrack(n, 0, queenCol, result);

        return result;
    }

    private static void backtrack(int n,
            int row,
            int[] queenCol,
            List<List<String>> result) {

        if (row == n) {
            result.add(buildBoard(n, queenCol));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, queenCol)) {

                queenCol[row] = col;

                backtrack(n, row + 1, queenCol, result);
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] queenCol) {

        for (int r = 0; r < row; r++) {

            if (queenCol[r] == col) {
                return false;
            }

            if (Math.abs(queenCol[r] - col) == Math.abs(r - row)) {
                return false;
            }
        }

        return true;
    }

    private static List<String> buildBoard(int n, int[] queenCol) {

        List<String> board = new ArrayList<>();

        for (int r = 0; r < n; r++) {

            StringBuilder sb = new StringBuilder();

            for (int c = 0; c < n; c++) {

                if (queenCol[r] == c) {
                    sb.append(" Q "); 
                }else {
                    sb.append(" . ");
                }
            }

            board.add(sb.toString());
        }

        return board;
    }

    public static void main(String[] args) {

        int n = 4;

        List<List<String>> solutions = solveNQueens(n);

        System.out.println("Total Solutions = " + solutions.size());

        for (List<String> board : solutions) {

            System.out.println();

            for (String row : board) {
                System.out.println(row);
            }
        }
    }
}
