package LinkedInQuestions.Strings;

/**
 * Created by rmukherj on 8/21/16.
 * Given a sorted array with duplicates and a number, find the range in the
 form of (startIndex, endIndex) of that number. For example,

 find_range({0 2 3 3 3 10 10}, 3) should return (2,4).
 find_range({0 2 3 3 3 10 10}, 6) should return (-1,-1).
 The array and the number of duplicates can be large.
 Find the given number in array using BS
 if given value not found
 return
 else
 use BS to find value at smallest index from low to (find index – 1)
 use BS to find value at highest index from (find index + 1) to high
O(logn)

 */
public class BInSdearchRangeMap {

    public void modifiedBS(int left, int right, int [] a, int [] bound, int target){

        if(left>right){
            return;
        }

        int m = (left+right)/2;

        if(a[m] == target){

            if( m==right || (m<right && a[m+1] != a[m])){
                if(right > bound[1]){
                    bound[1] = right;
                }
            }

            if(m<right && a[m+1]==target){
                modifiedBS(m+1,right,a,bound,target);
            }

            if(m==left || (m>left && a[m-1] != a[m])){
                if(left < bound[0]){
                    bound[0] = left;
                }
            }

            if(m>left && a[m-1] == a[m]){
                modifiedBS(left,m-1,a,bound,target);
            }
        }else if(a[m] < target){
            modifiedBS(m+1,right,a,bound,target);
        }else{
            modifiedBS(left,m-1,a,bound,target);
        }
    }

    public int [] findBound(int []a, int target){

        int bound[] = new int[2];

        if(a.length == 0){
            bound[0] = -1;
            bound[1] = -1;
            return bound;
        }

        bound[0] = a.length-1;
        bound[1] = 0;

        modifiedBS(0,a.length-1,a,bound, target);

        if(bound[0] == a.length-1 && bound[1] == 0 ){
            bound[0] = -1;
            bound[1] = -1;
        }

        return bound;
    }

    public static void main(String[] args) {
        BInSdearchRangeMap bi = new BInSdearchRangeMap();
        int[] i = {0,2, 3, 3, 3, 10, 10};
        int[] x = new int[]{};
              x=  bi.findBound(i,3);

    }
}
