package LinkedInQuestions.Strings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by rmukherj on 8/22/16.
 *
 Example:
 given "foo", "app"; returns true
 we can map 'f' -> 'a' and 'o' -> 'p'
 given "bar", "foo"; returns false
 we can't map both 'a' and 'r' to 'o'

 given "turtle", "tletur"; returns true
 we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r'

 given "ab", "ca"; returns true
 we can map 'a' -> 'c', 'b'
 */
public class IsomorphicStrings {

        private String s1;
        private String s2;

        public IsomorphicStrings(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        public boolean isIsomorphic() {
            int[] s1_arr = new int[256];
            int[] s2_arr = new int[256];
            if( s1.length() != s2.length() ) {
                return false;
            }
            for( int i = 0; i < s1.length(); i++ ) {
                s1_arr[s1.charAt(i)] = s1_arr[s1.charAt(i)] + 1;
                s2_arr[s2.charAt(i)] = s2_arr[s2.charAt(i)] + 1;
            }
            Arrays.sort(s1_arr);
            Arrays.sort(s2_arr);
            for( int i = 0; i < s1_arr.length; i++ ) {
                if( s1_arr[i] != s2_arr[i] ) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            IsomorphicStrings is = new IsomorphicStrings("turtle", "tletur");
            System.out.println(is.isIsomorphic());
        }

    public static boolean isIsomorphic(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        if(n1 != n2) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i< n1; i++) {
            char ch = str2.charAt(i);
            if(map.containsKey(ch)) {
                char c = map.get(ch);
                if (c != str1.charAt(i)){
                    return false;
                }
            } else {
                map.put(ch, str1.charAt(i));
            }
        }
        return true;

    }

}
