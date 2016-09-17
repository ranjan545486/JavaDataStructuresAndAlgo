package LinkedInQuestions.DynamicProgramming;

/**
 * Created by rmukherj on 8/22/16.
 */
public class MaxProductSubarray {
    public int maxProductN(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];
        int result = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                max[i]=Math.max(nums[i], max[i-1]*nums[i]);
                min[i]=Math.min(nums[i], min[i-1]*nums[i]);
            }else{
                max[i]=Math.max(nums[i], min[i-1]*nums[i]);
                min[i]=Math.min(nums[i], max[i-1]*nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }



    public static void main(String[] args) {
        MaxProductSubarray msp = new MaxProductSubarray();
        int[] array = new int[]{3,2,65,7,29,};
        //int[] a = new int[] {-3,-1,-9,-34,-6,-4};
        int[] a = new int[] {2,3,-2,4};
        System.out.println(msp.maxProductN(a));


    }
}
