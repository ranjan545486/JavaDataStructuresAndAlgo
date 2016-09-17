package tryingsomething.Matrix;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by rmukherj on 9/1/16.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board){
        HashMap<Character, Boolean> ht ;
        //check columns
        for(int i=0;i<9;i++){
            ht = new HashMap<>();
            for (int j=0; j<9;j++){
                Character value = board[i][j];
                if (value.equals('.'))
                {
                    continue;
                }

                if (ht.containsKey(value))
                {
                    return false;
                }

                ht.put(value, true);
            }
        }

        // check rows
        for (int i = 0; i < 9; i++)
        {
            ht = new HashMap<>();
            for (int j = 0; j < 9; j++)
            {
                Character value = board[j][i];
                if (value.equals('.'))
                {
                    continue;
                }

                if (ht.containsKey(value))
                {
                    return false;
                }

                ht.put(value, true);
            }
        }

        // check squares
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                ht = new HashMap<>();

                for (int m = 0; m < 3; m++)
                {
                    for (int n = 0; n < 3; n++)
                    {
                        Character value = board[i * 3 + m][j * 3 + n];
                        if (value.equals('.'))
                        {
                            continue;
                        }

                        if (ht.containsKey(value))
                        {
                            return false;
                        }

                        ht.put(value, true);
                    }
                }
            }
        }

        return true;

    }

    private boolean checkSudokuStatus(int[][] grid) {
        for (int i = 0; i < 9; i++) {

            int[] row = new int[9];
            int[] square = new int[9];
            int[] column = grid[i].clone();

            for (int j = 0; j < 9; j ++) {
                row[j] = grid[j][i];
                square[j] = grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if (!(validate(column) && validate(row) && validate(square)))
                return false;
        }
        return true;
    }

    private boolean validate(int[] check) {
        int i = 0;
        Arrays.sort(check);
        for (int number : check) {
            if (number != ++i)
                return false;
        }
        return true;
    }

    //-----With Arrays-----//
    public boolean validSudoku(char[][] board) {
        boolean[] visited = new boolean[9];

        // row
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[i][j]))
                    return false;
            }
        }

        //col
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[j][i]))
                    return false;
            }
        }

        // sub matrix
        for(int i = 0; i<9; i+= 3){
            for(int j = 0; j<9; j+= 3){
                Arrays.fill(visited, false);
                for(int k = 0; k<9; k++){
                    if(!process(visited, board[i + k/3][ j + k%3]))
                        return false;
                }
            }
        }
        return true;

    }

    private boolean process(boolean[] visited, char digit){
        if(digit == '.'){
            return true;
        }

        int num = digit - '0';
        if ( num < 1 || num > 9 || visited[num-1]){
            return false;
        }

        visited[num-1] = true;
        return true;
    }
    //-----end with arrays----//

}
