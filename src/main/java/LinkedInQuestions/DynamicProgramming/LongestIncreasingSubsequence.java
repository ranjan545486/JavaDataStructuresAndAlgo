package LinkedInQuestions.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by rmukherj on 8/14/16.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int result = 1;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    max[i]= Math.max(max[i], max[j]+1);

                }
            }
            result = Math.max(max[i], result);
        }

        return result;
    }

    public static int getLongestIncreasingSubSequenceLength(int[] a) {
        int len = a.length, maxLisLength = 0;
        int[] lis = new int[len];

        for (int i = 0; i < len; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            if (lis[i] > maxLisLength) {
                maxLisLength = lis[i];
            }
        }

        return maxLisLength;
    }

    public static void main(String a[]) {
        System.out.print(getLongestIncreasingSubSequenceLength(new int[]{2, 3, 7, 8, 15}));
        //System.out.println(getLongestIncreasingSubSequenceLength(new int[]{2, 20, 7, 8, 1}));
        //System.out.println(getLongestIncreasingSubSequenceLength(new int[]{20, 10, 5}));
        LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();
        System.out.print(ls.lengthOfLIS(new int[]{2, 3, 7, 8, 15}));

    }
}
