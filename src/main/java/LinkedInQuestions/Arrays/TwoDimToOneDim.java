package LinkedInQuestions.Arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by rmukherj on 8/21/16.
 *
 for eg:
 1 2 3
 4 5 6
 7 8 9

 should return 1 2 3 6 5 4 7 8 9
 */
public class TwoDimToOneDim {

    public int[] modify(int[][] m)
    {
        if(m==null||m.length==0||m[0].length==0)
        {
            return null;
        }

        int[] result=new int[m.length*m[0].length];
        int idx=0;
        for(int i=0;i<m.length;i++)
        {
            if(i%2==0)
            {
                for(int c=0;c<m[0].length;c++)
                {
                    result[idx++]=m[i][c];
                }

            }else
            {
                for(int c=m[0].length-1;c>=0;c--)
                {
                    result[idx++]=m[i][c];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][]={
                {1,2,3,4,5},

                {6,7,8,9,10},

                {11,12,13,15,16}
        };
      TwoDimToOneDim t = new TwoDimToOneDim();
        int[] result = t.modify(matrix);
        IntStream stream = Arrays.stream(result);
        stream.forEach(x-> System.out.print(x));

    }
}
