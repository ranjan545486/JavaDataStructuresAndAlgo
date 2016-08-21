package LinkedInQuestions.Graphs;

import LinkedList.LinkedList;

import java.util.Queue;
import java.util.Set;

/**
 * Created by rmukherj on 8/15/16.
 *
 *  One way BFS
 a.) Create a class to store word and the level of the word from the root.
 b.) Maintain a queue of the above class to do BFS.
 c.) loop until queue is not empty
 d.) For each char replace it with 26 possible chars and check if it exists in dictionary
 e.) if found return the level.
 */

class WordLadderOneWay
{
    public String word;
    public int numsteps;

    public WordLadderOneWay(String word, int numsteps)
    {
        this.word = word;
        this.numsteps = numsteps;
    }
}
public class WordLadderOneWayBFS {


    public int LadderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null)
            return 0;
        if (beginWord.length() != endWord.length())
            return 0;
        if (beginWord.length() == 1)
            return 2;
        if (!wordList.contains(beginWord) || !wordList.contains(endWord))
            return 0;

        int maxCount = Integer.MAX_VALUE;
        Queue<WordLadderOneWay> myq = (Queue) new LinkedList();
        myq.add(new WordLadderOneWay(beginWord, 1));

        while (myq.size() != 0) {

            WordLadderOneWay top = myq.poll();
            if (top.word.equals(endWord) && maxCount > top.numsteps)
                maxCount = top.numsteps;
            char[] ch = top.word.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = ch[i];
                    ch[i] = c;
                    String s = new String(ch);
                    if (wordList.contains(s)) {
                        myq.remove(new WordLadderOneWay(s, top.numsteps + 1));
                        if (!top.word.equals(endWord))
                            wordList.remove(s);
                    }
                    ch[i] = temp;
                }
            }

        }
        return maxCount == Integer.MAX_VALUE ? 0 : maxCount;
    }
}
