package LinkedInQuestions.Arrays;

/**
 * Created by rmukherj on 8/22/16.
 * Horizontal Scanning
 */

public class LongestCommonPrefix {
    //Horizontal Scanning
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    //divide and conquer way.

    public String longestCommonPrefixdandq(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }




    public static void main(String[] args) {
        String[] input = {"geeksforgeeks","geeks","geek", "geezer"};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
       // Stream<String>  streamer = Stream.of(input);
       // streamer.forEach(x-> System.out.println(x));
        String result = lcp.longestCommonPrefix(input);
        System.out.println(result);
    }
}
