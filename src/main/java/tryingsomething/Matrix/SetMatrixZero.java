package tryingsomething.Matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by rmukherj on 9/26/16.
 * Given a m * n matrix, if an element is 0, set its entire row and column to 0.
 Do it in place.
 */
public class SetMatrixZero {

    public static void main(String[] args) {
        SetMatrixZero sm = new SetMatrixZero();
        int[][] x = sm.setZeroes(new int[][]{
                {1,1,1,0},
                {1,1,1,0},
                {1,1,0,0},
                {1,1,1,1}

        });

        IntStream stream = Arrays.stream(x).flatMapToInt(o->Arrays.stream(o));
        stream.forEach(p-> System.out.print(p));

    }

    public int[][] setZeroes(int[][] matrix){
        boolean firstRowZero = false;
        boolean firstColZero = false;

        //set first row and column zero or not
        for (int i = 0; i <matrix.length ; i++) {
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }

        for (int j = 0; j < matrix[0].length ; j++) {
            if(matrix[0][j] == 0){
                firstRowZero = true ;
            }

        }

        //mark zeros on first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //use mark to set elements
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //set first column and row
        if(firstColZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }

        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }

        return matrix;


    }
}
