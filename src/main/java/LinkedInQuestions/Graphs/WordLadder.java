package LinkedInQuestions.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by rmukherj on 8/14/16.
 * For typical word ladder problem to get the shortest path,
 * BFS has complexity exponential to the word string length. How to optimize?
 Biderectional BFS -
 a.) In previous solution as we go deeper , the number of words to loop will increase exponentially.
 b.) if we consider end word as begin word , we could repeat the same step to find the soultion.
 c.) Therefore , if we start from both end and eventually check if we found intermediate target list of words which can eventually form the end word in end list.
 d.) Since we are using HashSet , We can save time for lopping through each word at deeper levels.
 */
class WordNode{
    String word;
    int numSteps;

    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));

        wordDict.add(endWord);

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

            if(word.equals(endWord)){
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return 0;
    }

    //Two way BFS solution faster than single side BFS
    public int LadderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord ==null || endWord==null ||wordList==null)
            return 0;
        if(beginWord.length() != endWord.length())
            return 0;
        HashSet<String> beginSet = new HashSet<String>();
        HashSet<String> endSet = new HashSet<String>();
        int level=1;
        beginSet.add(beginWord);
        endSet.add(endWord);

        HashSet<String> visited = new HashSet<String>();
        while(beginSet.size()!=0 && endSet.size()!=0)
        {
            //Store next level child element which are one character different
            HashSet<String> temp = new HashSet<String>();

            if(beginSet.size() > endSet.size())
            {
                HashSet<String> swap = endSet;
                endSet = beginSet;
                beginSet = swap;
            }

            for( String s : beginSet)
            {
                char[] ch = s.toCharArray();
                for(int i = 0; i < ch.length; i++)
                {
                    char old = ch[i];
                    for(char c ='a'; c<= 'z'; c++)
                    {
                        if(c!=old)
                            ch[i]=c;

                        String target = new String(ch);
                        if(endSet.contains(target))
                            return level+1;

                        if(!visited.contains(target)&& wordList.contains(target))
                        {
                            temp.add(target);
                            visited.add(target);
                        }

                        ch[i]=old;
                    }
                }
            }
            beginSet=temp;
            level++;
        }

        return 0;
    }
}

/*
Linkedin Interview Question
l
Answers
For typical word ladder problem to get the shortest path,
BFS has complexity exponential to the word string length. How to optimize?

//Two way BFS solution faster than single side BFS
    public int LadderLength(string beginWord, string endWord, Set<string> wordList) {
        if(beginWord ==null || endWord==null ||wordList==null)
            return 0;
        if(beginWord.Length != endWord.Length)
            return 0;
        HashSet<string> beginSet = new HashSet<string>();
        HashSet<string> endSet = new HashSet<string>();
        int level=1;
        beginSet.Add(beginWord);
        endSet.Add(endWord);

        HashSet<string> visited = new HashSet<string>();
        while(beginSet.Count!=0 && endSet.Count!=0)
        {
            //Store next level child element which are one character different
            HashSet<string> temp = new HashSet<string>();

            if(beginSet.Count > endSet.Count)
            {
                HashSet<string> swap = endSet;
                endSet = beginSet;
                beginSet = swap;
            }

            foreach( var s in beginSet)
            {
                char[] ch = s.ToCharArray();
                for(int i = 0; i < ch.Length; i++)
                {
                    char old = ch[i];
                    for(char c ='a'; c<= 'z'; c++)
                    {
                        if(c!=old)
                            ch[i]=c;

                        string target = new string(ch);
                        if(endSet.Contains(target))
                            return level+1;

                        if(!visited.Contains(target)&& wordList.Contains(target))
                        {
                            temp.Add(target);
                            visited.Add(target);
                        }

                        ch[i]=old;
                    }
                }
            }
            beginSet=temp;
            level++;
        }

        return 0;
    }
 */


