package tryingsomething.HashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rmukherj on 9/15/16.
 */
public class MostCommonElement {
    public static void main(String[] args) {
        MostCommonElement mce = new MostCommonElement();
        Scanner in = new Scanner(System.in);
        Map<String, Integer> hashtable = new HashMap<>();

        hashtable.put("First",in.nextInt());
        hashtable.put("Second",in.nextInt());
        in.close();
        String abc = mce.findMostCommonElement(in, hashtable);
      //  String def = mce.findMostCommonElement();
        System.out.println(abc);
    }

    public String findMostCommonElement(Scanner in, Map<String, Integer> hashtable) {
//        Scanner in = new Scanner(System.in);
//        Map<String, Integer> hashtable = new HashMap<>();

        String str;
        while (in.hasNext()) {
            str = in.next();
            int previous_count = (hashtable.get(str) == null) ? 0 : hashtable.get(str);
            hashtable.put(str, previous_count + 1);
        }

        String maxStr = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : hashtable.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxStr = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return maxStr;
    }

    }

//    String find_most_common_element( Scanner in, Map < String, Integer > hash_table)
//    { String str;
//        while (in.hasNext())
//        { str = in.next();
//            int previous_count = (hash_table.get( str) == null) ? 0 : hash_table.get( str);
//            hash_table.put( str, previous_count + 1);
//        }
//        String max_str = ""; int max_count = 0;
//
//    }
