package LinkedInQuestions.Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rmukherj on 8/13/16.
 */
public class WordBreakUsingTrie {
    class TrieNode {
        char val;
        boolean isRoot;
        boolean isLeaf;
        TrieNode children[]; // There can be atmost 26 children (english alphabets)
        TrieNode() {
            val = '^';
            isRoot = true;
            children = new TrieNode[26];
            initializeChildren();
        }
        TrieNode(char val) {
            this.val = val;
            isRoot = false;
            isLeaf = false;
            children = new TrieNode[26];
            initializeChildren();
        }

        void initializeChildren() {
            for(int i=0;i<children.length;i++) {
                children[i] = null;
            }
        }
    }

    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        void insert(String input) {
            int start = 'A';
            TrieNode current = root;

            for(int i=0;i<input.length();i++) {
                int val = Character.toUpperCase(input.charAt(i));
                int index = val - start;

                if(current.children[index] == null)
                    current.children[index] = new TrieNode(input.charAt(i));

                current = current.children[index];
            }
            current.isLeaf = true;
        }
    }



        boolean wordBreak(String s, Set<String> dict) {
            // First Construct Trie from the dictionary

            Trie a = new Trie();
            for(String i : dict) {
                a.insert(i);
            }


            TrieNode current = a.root;
            int start = 'A';

            boolean result = false;

            for(int i=0; i<s.length();i++) {
                int val = Character.toUpperCase(s.charAt(i));
                int index = val - start;

                if(current.children[index] == null) {
                    // Word is not in the dictionary
                    current = a.root;
                    result = false;
                    break;
                }
                current = current.children[index];
                if(current.isLeaf == true) {
                    // Start from the beginning for the next character
                    current = a.root;
                    result = true;
                }
            }

            return result;

        }

        public static void main(String[] args) {
            WordBreakUsingTrie temp = new WordBreakUsingTrie() ;
            Set<String> dict = new HashSet<String>();
            dict.add("leet");
            dict.add("code");
           // dict.add("lee");
            dict.add("programcree");
            dict.add("program");
            dict.add("creek");
            System.out.println("Wordbreak (programcreek) = " + temp.wordBreak("programcreek", dict));
            System.out.println("Wordbreak (leetcode) = " + temp.wordBreak("leetcode", dict));
            System.out.println("Wordbreak (lesscode) = " + temp.wordBreak("lesscode", dict));
        }


}
