package tryingsomething.Matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by rmukherj on 10/2/16.
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,0,1,2},
                {3,4,5,6}
        };

        int[][] rotated = RotateMat(array, 4);
        IntStream stream1 = Arrays.stream(array).flatMapToInt(o->Arrays.stream(o));
        stream1.forEach(p-> System.out.print(p));
        System.out.println();
        IntStream stream = Arrays.stream(rotated).flatMapToInt(o->Arrays.stream(o));
        stream.forEach(p-> System.out.print(p));

    }

    private static int[][] RotateMat(int[][] array, int n) {
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = array[n-j-1][i];
            }
        }

        return ret;
    }
}
