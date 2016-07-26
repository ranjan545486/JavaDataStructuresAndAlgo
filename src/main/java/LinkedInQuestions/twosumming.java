package LinkedInQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmukherj on 7/23/16.
 */
public class twosumming {
    public int[] twosum(int[] numbers, int target){
        Map<Integer, Integer> map =  new HashMap<>();
        for(int i =0 ;i<numbers.length;i++){
            int x = numbers[i];
            if(map.containsKey(target - x)){
                return new int[] { map.get(target - x)+1, i+1};
            }

            map.put(x,i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args){
        twosumming ts = new twosumming();
        int[] num = {2,5,1,7};
        int[] p = ts.twosum(num,7);
    }

}
