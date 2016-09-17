package tryingsomething.TRies;

/**
 * Created by rmukherj on 9/10/16.
 * Suggest a data structure and implement efficient phrase search along with word search in a huge chunk of text.


 */

class TrieNode{
    TrieNode[] nextLetters; //points to the next character of current word
    TrieNode[] nextWordStart; //points to starting charactarer of next word
                              // (if trienode is the last letter of a word in a phrase)

    public TrieNode(){
        nextLetters = new TrieNode[26];
        nextWordStart = new TrieNode[26];
    }

}
public class SearchTrie {

    private static TrieNode rt = new TrieNode(); // reference to the root node of the trie.
    public static boolean searhWord(String word){
        if(word == null || word.length() ==0 ){
            return false;
        }

        for (int i = 0; i < word.length() ; i++) {
            int idx = (int)word.charAt(i) - 'a';
            TrieNode v = rt;
            if(v.nextLetters[idx]== null){
                return false;
            }

            v = v.nextLetters[idx];
        }

        return true;
    }

    public static boolean searchPhrase(String[] phrase){

        TrieNode v=rt;
        for(int i=0;i<phrase[0].length();i++){
            int idx=(int)phrase[0].charAt(i)-'a';
            if(v.nextLetters[idx]==null){
                return false;
            }
            v=v.nextLetters[idx];
        }
        for(int i=1;i<phrase.length;i++){
            String wrd=phrase[i];

            //check if the node corresponding to the last letter of the previous word has a
            //pointer to the first letter of the current word
            int currChar=(int)wrd.charAt(0)-'a';
            if(v.nextLetters[currChar]==null || v.nextWordStart[currChar]==null){
                return false;
            }
            v=v.nextLetters[currChar];
            for(int j=1;j<wrd.length();j++){
                currChar=wrd.charAt(j)-'a';
                if(v.nextLetters[currChar]==null){
                    return false;
                }
                v=v.nextLetters[currChar];
            }
        }
        return true;
    }



}
