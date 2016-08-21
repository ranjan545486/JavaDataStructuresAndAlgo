package LinkedInQuestions.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rmukherj on 8/12/16.
 */
public class WordBreak {

    /*
    Naive Approach
     */

    public boolean wordBreak(String s, Set<String> dict){
        return wordBreakHelper(s,dict,0);
    }

    private boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length()){
            return true;
        }

        for(String a: dict) {
            int len = a.length();
            int end = start + len;

            //end index should be <= string length

            if(end>s.length())
                continue;

            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s,dict,start+len))
                    return true;
        }

        return false;
    }

    /**
     *
     * @param String s
     * @param wordDict
     * @return boolean
    Approach: Back­track­ing– Naive Approach

    Nav­i­gate the given input string.
    Take a blank string and keep adding one char­ac­ter at a time to it.
    Keep check­ing if the word exist in the dictionary.
    If word exist in the dic­tio­nary then add that word to the answer string and make recur­sive call to the rest of the string.
    If any of the recur­sive call returns false then back­track and remove the word from the answer string and again keep adding the char­ac­ters to string.
    If all the recur­sive calls return true that means string has been bro­ken successfully.
     */

    public boolean wordBreaker(String s, Set<String> wordDict) {
        int[] pos = new int[s.length()+1];
        Arrays.fill(pos, -1);
        pos[0]=0;
        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()]!=-1;
    }

    public boolean wordBreakBT(String s, HashSet<String> hs){
       if(wordBreakBTHelper(s, hs, "")){
           return true;

       }else {
           System.out.println("Cannot break.");
           return false;
       }
    }

    private boolean wordBreakBTHelper(String s, HashSet<String> dict, String answer){
        if(s.length()==0){
            System.out.println(answer);
            return true;
        } else {
            int index=0;
            String word = "";
            while(index<s.length()){
                word+=s.charAt(index); // add one char at a time.
                //check if the word exists in the dictionary.
                if(dict.contains(word)){
                    //add word to the answer and make a recursive call.
                    if(wordBreakBTHelper(s.substring(index+1),dict, answer + word + " ")){
                        return true;
                    } else {
                        index++;
                    }
                } else {
                    index++;
                }
            }

        }

        return false;

    }

    /**
     *
     * @param s
     * @param hs
     * @return boolean
     * Dynamic Program Top Down
     * Dynamic Pro­gram­ming to Rescue:

    We will use top-down  approach.
    Before we solve it for any string check if we have already solve it.
    We can use another HashMap to store the result of already solved strings.
    When­ever any recur­sive call returns false, store that string in HashMap.
     */

    public boolean wordBreakUsingDP(String s, HashSet<String> hs){
        if(wordBreakHelperUsingDP(s,hs,new HashSet<String>(),"")){
            return true;
        }else {
            System.out.println("Cannot Break");
            return false;
        }

    }

    public boolean wordBreakHelperUsingDP(
            String s, HashSet<String> dict, HashSet<String> memory, String answer){
        if(s.length()==0){
            System.out.println(answer);
            return true;
        } else if(memory.contains(s)){
            return false;
        } else
        {
            int index = 0;
            String word = "";
            while(index<s.length()){
                word+=s.charAt(index); // add one char at a time.
                //check if the word is already solved.
                if(dict.contains(word)){
                    if(wordBreakHelperUsingDP
                            (s.substring(index+1),dict, memory, answer+word + " ")){
                        return true;
                    }else {
                        System.out.println("backtrack");
                        index++;
                    }
                } else {
                    index++;
                }

            }

            memory.add(s);
            return false;

        }
    }

    public static void main(String[] args) {
        String[] dictionary = {"mobile","samsung", "cat","dog","catch","dog","man","go","mango"};
        Set<String> mySet = new HashSet<>(Arrays.asList(dictionary));
        WordBreak wb = new WordBreak();
        System.out.println("The word catdogcat in wordbreaker is "+ wb.wordBreak("catdogcat",mySet));
        System.out.println(wb.wordBreakBT("catdogcat",(HashSet<String>) mySet));
        System.out.println(wb.wordBreakUsingDP("dogcatchdog", (HashSet<String>) mySet));


    }

}
