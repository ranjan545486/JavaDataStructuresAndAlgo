package tryingsomething.Arrays;

import java.util.Arrays;

/**
 * Created by rmukherj on 9/12/16.
 * msft:
 * Given an array: 1,2,3 ,5,8,7,6,9,5,7,3,0,5
 subarry:5,7

 Find the subarray in the large array and return the minimum length and index where you can find the subarray.
 Note: that the subarray may be present in the large array non-contiguous.

 In the above case : the answer is length = 2 and
 index = 8
 */
public class SubArrayPosition {

    public static void main(String[] args) {
        int[] o = findSubArrayPos(new int[] {1,2,3,5,8,7,6,9,5,7,3,0,5}, new int[] {5,7});
        Arrays.stream(o).forEach(x-> System.out.println("The matched location is "+x));

    }

    private static int[] findSubArrayPos(int[] a1, int[] a2){
        int[] out = new int[a2.length];
        out[0] = -1;
        out[1] = -1;

        //error case: either of the arrays are null,
        // subarray length is more than main array
        if(null == a1 || null == a2 || a2.length >a1.length){
            return out;
        }

        int startIndex = 0;
        int j = startIndex;
        for(int i=0;i<a1.length && startIndex==0;i++){
            if(a1[i] != a2[startIndex]){
                continue;
            } else {
                //first element of subarray is matched;
                // iterate over the rest and check.
                startIndex = i;
                while(j<a2.length && i<a1.length){
                   if(a2[j] != a1[i]){
                       startIndex = 0;
                       j = startIndex ;
                       break;
                   }
                   j++;
                   i++;
                }
            }
        }

        //entire subArray is matched
        if(j== a2.length){
            out[0] = startIndex;
            out[1] = j;
        }

        return out;

    }
}
