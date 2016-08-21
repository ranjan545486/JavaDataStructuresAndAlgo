package tryingsomething;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rmukherj on 8/17/16.
 */
public class _8Queen {
    private static final int[] columnForRow = new int[8];

    private static boolean check(int row){
        for(int i=0;i<row;i++){
            int diff = Math.abs(columnForRow[i] - columnForRow[row]);
            if(diff == 0 || diff == row -i){
                return false;
            }
        }

        return true;
    }

    private static boolean placeQueen(int row) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String");
        if(row == 8){
            printBoard();
            //br.readLine();
            return true;
        }
        for(int i=0;i<8;i++){
            columnForRow[row] = i;
            if(check(row)){
                if(placeQueen(row+1)){
                    return true;
                }
            }
        }

        return false;
    }

    private static void printBoard(){
        for(int i=0;i<columnForRow.length;i++){
            System.out.println("Row="+ i + "Column="+columnForRow[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        placeQueen(0);
    }
}
