package LinkedInQuestions.Strings;

/**
 * Created by rmukherj on 8/22/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordFinder {
    private Map<String, ArrayList<Integer>> dictionary = new HashMap<String, ArrayList<Integer>>();

    public WordFinder(String[] list) {
        for (int i = 0; i < list.length; i++) {
            addToDictionary(list[i], i);
        }
    }

    private void addToDictionary(String word, int position) {
        ArrayList<Integer> positions = dictionary.get(word);
        if (positions == null) {
            positions = new ArrayList<Integer>();
        }

        positions.add(position);
        dictionary.put(word, positions);
    }

    public int findDistance(String a, String b) {
        if (a == null || b == null) {
            return -1;
        }

        if (a.equals(b)) {
            return 0;
        }
        ArrayList<Integer> posA = dictionary.get(a);
        ArrayList<Integer> posB = dictionary.get(b);
        if (posA == null || posB == null) {
            return -1;
        }

        int min = 0;
        for (int x : posA) {
            for (int y : posB) {
                int distance = Math.abs(x - y);
                if (min > distance || min == 0) {
                    min = distance;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        String[] a = new String[] { "the", "quick", "brown", "fox", "quick" };
        WordFinder distanceFinder = new WordFinder(a);
        System.out.println("Distance between words is: "
                + distanceFinder.findDistance("fox", "the"));
        System.out.println("Distance between words is: "
                + distanceFinder.findDistance("quick", "fox"));
        System.out.println("Distance between words is: "
                + distanceFinder.findDistance("brown", "brown"));
        System.out.println("Distance between words is: "
                + distanceFinder.findDistance("apple", "mango"));
    }

    //===dfs way
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean result = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board,word,i,j,0)){
                    result = true;
                }
            }
        }

        return result;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k){
        int m = board.length;
        int n = board[0].length;

        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }

        if(board[i][j] == word.charAt(k)){
            char temp = board[i][j];
            board[i][j]='#';
            if(k==word.length()-1){
                return true;
            }else if(dfs(board, word, i-1, j, k+1)
                    ||dfs(board, word, i+1, j, k+1)
                    ||dfs(board, word, i, j-1, k+1)
                    ||dfs(board, word, i, j+1, k+1)){
                return true;
            }
            board[i][j]=temp;
        }

        return false;
    }
}
