package LinkedInQuestions.DynamicProgramming;

/**
 *
 * Find the maximum sum subset in an array with negative integers
 To find maximum sum SUBSET: eliminate all negative integers, keep only positive ones.
 If all numbers are negative, choose the empty subset.

 2. To find maximum sum of continuous subsequence: keep summing up numbers and record maximum sum.
 If the sum is negative, reset it to be 0.

 */
public class MaxSubArray{
        public static int maxSubArray(int[] prices) {
            if (prices == null || prices.length < 1) {
                return 0;
            }

            int currentMax = prices[0], max = prices[0];
            for (int i=1; i < prices.length; i++) {
                currentMax = Math.max(prices[i], currentMax+prices[i]);
                max = Math.max(max, currentMax);
            }
            return max;
        }

        public static void main(String[] args) {

            int x = maxSubArray(new int[] {-3,-1,-9,-34,-6,-4});
            System.out.println(x);
        }
}
