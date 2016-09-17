package tryingsomething.Matrix;

/**
 * Created by rmukherj on 9/14/16.
 */
public class MatrixToOneDim {

    public int[] modifytwoDimMatrixToOneDim(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0)
            return null;

        int idx = 0;
        int[] result = new int[m.length*m[0].length];
        for(int i = 0; i<m.length;i++){
            if(i%2==0){
                for(int j = 0; j<m[0].length;j++){
                    result[idx++]= m[i][j];
                }
            } else{
                for(int j = m[0].length;j>=0;j--){
                    result[idx++] = m[i][j];
                }
            }
        }

        return result;

    }

}
