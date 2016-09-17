package tryingsomething.Arrays;

import java.util.HashMap;

/**
 * Created by rmukherj on 9/13/16.
 */
public class CountPairs {
    static int countPairs(int a[], int x)

    { int count = 0;

        for(int i=0; i<a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {
                //if (i+j==x) {
                if (a[i] - a[j] == x || a[j] - a[i] == x) {
                    count++;

                }

            }
        }

        return count;

    }

    public static int countWithHashPairs(int[] a, int n, int k){
        int count = 0;

        HashMap<Integer, Boolean> hashmap = new HashMap<>();
        for (int i=0;i<n ;i++) {
            hashmap.put (a[i], true);
        }

        for (int i=0;i<n ;i++ ) {
            int x = a[i];
            if(x-k>0 && hashmap.get(x-k)){
                count++;
            }
            if(x+k<n && hashmap.get(x+k)){
                count++;
            }

            hashmap.put(x, false);
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(countPairs(new int[]{8,12,16,4,0,20},4));
        System.out.println(countWithHashPairs(new int[]{1,4,2,3,2,4},6,3));

    }

}
