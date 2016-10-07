package tryingsomething.Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rmukherj on 9/18/16.
 */
public class SmallWordsStringPermutation {
    public static void main(String[] args) {
        String[] arr = {"bad", "actor", "good", "acting"};
        System.out.println(isPermutate(arr, "badactorgoodacting"));
    }

    public static Boolean isPermutate(String [] strings,String str){
        Set<String> set = new HashSet<>();
        permString(strings, 0, strings.length,set);
        return set.contains(str);
    }

    private static void permString(
            String[] strings, int i, int length, Set<String> set) {
        if(i==length){
            StringBuffer buffer = new StringBuffer();
            for(String string: strings){
                buffer.append(string);
            }

            set.add(buffer.toString());
            System.out.println(buffer.toString());
        } else{
            for (int j = i; j < length; j++) {
                swap(strings,j,i);
                permString(strings,i+1,length,set);
                swap(strings,j,i);
            }
        }
    }

    static void swap(final String[] strings, final int pos1, final int pos2) {
        String temp = strings[pos1];
        strings[pos1] = strings[pos2];
        strings[pos2] = temp;
    }

}
