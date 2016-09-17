package LinkedInQuestions.Strings;

/**
 * Created by rmukherj on 8/21/16.
 */
public class WordWrap {
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
}
