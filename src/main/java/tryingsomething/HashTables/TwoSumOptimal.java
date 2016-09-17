package tryingsomething.HashTables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmukherj on 9/17/16.
 */
public class TwoSumOptimal {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args){
        TwoSumOptimal ts = new TwoSumOptimal();
        int[] num = {2,5,1,7};
        int[] p = ts.twoSum(num,7);
        Arrays.stream(p).forEach(x-> System.out.println("The matched location is "+x));
    }

}
