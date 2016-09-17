package LinkedInQuestions.Strings;

import java.util.*;
import java.util.stream.Collectors;

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

    //=== another way====
    public static ArrayList<String> permutation(String str) {
        List<String> list = new ArrayList<>();
        permutation("", str,list);
        return (ArrayList<String>)list;
    }

    private static List<String> permutation(String prefix, String str, List<String> l) {

        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
            l.add(prefix);
        }

        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),l);
        }
        return l;
    }
    //=====finish another way====

    //====print all anagrams together
    public static String getAnagramsTogether2(String sentence)
    {
        if(sentence == null ||  sentence.trim().isEmpty())
            throw new IllegalArgumentException();

        Map<String, List<String>> map = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(
                        Anagram::sortString));

        return map.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.joining(" "));
    }
    public static String sortString(String string) {

        return  string.chars()
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }
            String ns = new String(arr);

            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }
    public static List<List<String>> groupAnagramsT(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0)
            return res;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i=0;i<strs.length;i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String str = new String(charArr);
            if(map.containsKey(str)){
                map.get(str).add(strs[i]);
            }
            else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str,list);
            }
        }//for i
        Iterator iter = map.values().iterator();
        while(iter.hasNext()){
            ArrayList<String> item = (ArrayList<String>)iter.next();
            Collections.sort(item);
            res.add(item);
        }
        return res;
    }

    public static String getAnagramsTogether(String sentence){

        if(sentence == null || sentence.trim().equals("")) return null;

        String[] words = sentence.split(" ");
        HashMap<String,List<String>> map =new HashMap<String,List<String>>();


        for(String word:words)
        {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);

            List<String> tempList = map.get(new String(wordArray));
            if(tempList == null) tempList = new ArrayList<String>();
            tempList.add(word);
            map.put(new String(wordArray),tempList);
        }

        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, List<String>> entry : map.entrySet())
        {

            for(String item:entry.getValue()){
                result.append(item+ " ");
            }
        }


        return result.toString();
    }


    public static void main(String[] args) {
        Anagram ag = new Anagram();
        ArrayList<String> anags = ag.GetAnagram("cat");
//        for(String x : anags){
//            System.out.println(x);
//        }
        String[] perms = {"cat","dog","123"};
        List<String> strArray = new ArrayList<String>();
        for (int i = 0; i <perms.length ; i++) {
            strArray.addAll(permutation(perms[i]));
        }

        String[] group = strArray.toArray(new String[strArray.size()]);

        List<List<String>> results =  groupAnagramsT(group);
        results.stream().forEach(x->x.forEach(y-> System.out.println(y)));

        //System.out.println(getAnagramsTogether2("cat dog"));

        //List<List<String>> g = groupAnagramsT(new String[]{"cat","dog"});
        //String s = getAnagramsTogether("cat dog");
    }
}
