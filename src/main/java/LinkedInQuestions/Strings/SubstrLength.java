package LinkedInQuestions.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmukherj on 8/15/16.
 */
public class SubstrLength {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String input = "ABCGRETCABCG";

        Map<String, Integer> substrMap = new HashMap<String, Integer>();

        for (int i = 0; i + 3 <= input.length(); i++) {

            String substr = input.substring(i, i + 3);

            int frequency = 1;

            if (substrMap.containsKey(substr)) {

                frequency = substrMap.get(substr);
                frequency++;
            }

            substrMap.put(substr, frequency);


        }


        System.out.println(substrMap.toString());
    }
}
