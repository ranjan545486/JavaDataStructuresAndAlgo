package LinkedInQuestions.Arrays;

/**
 * Created by rmukherj on 8/20/16.
 */
public class SortLeftShiftArray {
    //int[] a = {4,5,6,7,8,1,2,3};
    int[] a = {4,5,6,1,2,3};
   // int rotation = 3;

    public static void main(String[] args) {
        SortLeftShiftArray rt = new SortLeftShiftArray();
        System.out.println(rt.search(1,3));


    }

    int search(int val, int rotation){
        int start = 0+rotation, end = a.length-1+rotation;
        int mid;
        int position = -1;
        while(start<=end){
            mid = getMid(start, end);
            if(getValAt(mid)==val){
                position = mid;
                break;
            }else if(getValAt(mid)>val){
                end = mid - 1;
            }else{
                start = mid +1;
            }

        }

        return position % a.length;
    }
    int getValAt(int position){
        return a[position%(a.length)];
    }
    int getMid(int start, int end){
        int mid  = (start+end)%2==0?(start+end)/2:(start+end+1)/2;;
        //mid = (mid+rotation)%(a.length-1);
        return mid;
    }


}
