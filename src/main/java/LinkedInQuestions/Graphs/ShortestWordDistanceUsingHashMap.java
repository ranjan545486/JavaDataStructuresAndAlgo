package LinkedInQuestions.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rmukherj on 8/23/16.
 */
public class ShortestWordDistanceUsingHashMap {
    HashMap<String, ArrayList<Integer>> map;
    //======ON2============
    public String WordDistance(String[] words) {
        map = new HashMap<String, ArrayList<Integer>>();
        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
        return null;
    }

    public int shortest(String word1, String word2) {

        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);

        int result = Integer.MAX_VALUE;
        for(int i1: l1){
            for(int i2: l2){
                result = Math.min(result, Math.abs(i1-i2));
            }
        }
        return result;
    }


    public int shortestOp(String word1, String word2) {

        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);

        int result = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(i<l1.size() && j<l2.size()){
            result = Math.min(result, Math.abs(l1.get(i)-l2.get(j)));
            if(l1.get(i)<l2.get(j)){
                i++;
            }else{
                j++;
            }
        }

        return result;
    }

}
