package tryingsomething.Arrays;

/**
 * Created by rmukherj on 8/29/16.
 */
public class RemoveDuplicatesArray {
    public int removeDuplicates(int[] nums) {


        if(nums.length<2){
            return nums.length;
        }


        //   HashMap<int, int> checkDup = new HashMap();
        //   for(int i : nums){
        //       if(!checkDup.containsKey(i))
        //   }
        int i=1, j=0;
        while(i<nums.length){
            if(nums[i]== nums[j]){
                i++;
            } else {
                j++;
                nums[j] = nums[i];
                i++;
            }
        }

        return j+1;




    }
}
