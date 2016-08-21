package LinkedInQuestions.Strings;

import java.util.ArrayList;

/**
 * Created by rmukherj on 8/16/16.
 */
public class Anagram {

    public static ArrayList<String> GetAnagram(String src)
    {
        if(src == null)
            return null;

        ArrayList<String> permutation = new ArrayList<String>();
        if(src.length() == 0)
        {
            permutation.add("");
            return permutation;
        }

        char first = src.charAt(0);
        String remainder = src.substring(1);
        ArrayList<String> words = GetAnagram(remainder);
        for(String word : words)
        {
            for (int i = 0; i <= word.length(); i++)
            {
                String temp = InsertCharactersAt(word,first,i);
                permutation.add(temp);
            }
        }

        return permutation;
    }

    private static String InsertCharactersAt(String word, char first, int i)
    {
        String end = word.substring(0,i);
        String start = word.substring(i);
        return start + first + end;
    }

    public static void main(String[] args) {
        Anagram ag = new Anagram();
        ArrayList<String> anags = ag.GetAnagram("cat");
        for(String x : anags){
            System.out.println(x);
        }
    }
}
