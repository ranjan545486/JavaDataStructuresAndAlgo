package LinkedInQuestions.Arrays;

/**
 * Created by rmukherj on 8/22/16.
 */

public class SpiralMatrix {

public enum Direction{
    Right,
    Down ,
    Left,
    Up
}

    public static void main(String[] args) {
        int[][]input = new int[][]{
                {1,2,3,4},
                {10,11,12,5},
                {9,8,7,6}
        };

        TraverseMatrix(input,0,2,0,3,0,0,Direction.Right);
    }

    public static void TraverseMatrix
            (int[][] input, int startRow, int endRow,
             int startColumn, int endColumn, int currentRow, int currentColumn, Direction direction) {
        if (startRow > endRow || startColumn > endColumn) {
            return;
        }

        switch (direction) {
            case Right: {
                for (int i = currentColumn; i <= endColumn; i++) {
                    System.out.println(input[currentRow][i]);
                }

                TraverseMatrix(input, startRow + 1, endRow,
                        startColumn, endColumn,
                        startRow + 1, endColumn,
                        Direction.Down);
                return;
            }
            case Left: {
                for (int i = currentColumn; i >= startColumn; i--) {
                    System.out.println(input[currentRow][i]);
                }

                TraverseMatrix(input, startRow, endRow - 1,
                        startColumn, endColumn,
                        endRow - 1, startColumn,
                        Direction.Up);
                return;
            }
            case Down: {
                for (int i = currentRow; i <= endRow; i++) {
                    System.out.println(input[i][currentColumn]);
                }

                TraverseMatrix(input, startRow, endRow,
                        startColumn, endColumn - 1,
                        endRow, endColumn - 1,
                        Direction.Left);
                return;
            }
            case Up: {
                for (int i = currentRow; i >= startRow; i--) {
                    System.out.println(input[i][currentColumn]);
                }

                TraverseMatrix(input, startRow, endRow,
                        startColumn + 1, endColumn,
                        startRow, startColumn + 1,
                        Direction.Right);
                return;
            }
        }
    }
}
