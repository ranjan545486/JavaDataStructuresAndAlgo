package LinkedInQuestions.Arrays;

import java.util.ArrayList;

/**
 * Created by rmukherj on 8/21/16.
 */
public class ArrayPermutation {
    static ArrayList<String[]> permutations(String[] a) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        permutation(a, 0, ret);
        return ret;
    }

    public static void permutation(String[] arr, int pos, ArrayList<String[]> list){
        if(arr.length - pos == 1){
            list.add(arr.clone());

            System.out.println(arr[0] + arr[1] +arr[2] );

        }else{
            for(int i = pos; i < arr.length; i++){
                swap(arr, pos, i);
                permutation(arr, pos+1, list);
                swap(arr, pos, i);
            }
        }
    }

    public static void swap(String[] arr, int pos1, int pos2){
        String h = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = h;
    }

    public static void main(String[] args) {
        ArrayPermutation am = new ArrayPermutation();
        String[] strArray = {"1","2","3"};
        permutations(strArray);
    }
}
