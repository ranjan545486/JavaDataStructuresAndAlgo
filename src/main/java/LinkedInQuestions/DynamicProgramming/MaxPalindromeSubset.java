package LinkedInQuestions.DynamicProgramming;

/**
 * Created by rmukherj on 8/20/16.
 */
public class MaxPalindromeSubset {

    static int maxPalindromeSubseq(int[] nums) {
        int maxSub[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++ ) {
            maxSub[i][i] = 1;
        }

        for (int len = 2; len <= nums.length; len++) {
            for (int i = 0; i <=nums.length - len; i++ ) {
                int j = i + len - 1;
                // other code
                if (nums[i] == nums[j] && len == 2)
                {
                    maxSub[i][j]  = 2;
                }
                else if (nums[i] == nums[j]) {
                    maxSub[i][j] = Math.max(maxSub[i + 1][j - 1] + 2, maxSub[i][j]);
                } else {
                    maxSub[i][j] = Math.max(maxSub[i][j - 1] , maxSub[i][j]);
                    maxSub[i][j] = Math.max(maxSub[i+1][j], maxSub[i][j]);
                }
            }
        }
        return maxSub[0][nums.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = new int[] {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4};
        System.out.println(maxPalindromeSubseq(arr));
    }


}
