package tryingsomething.Strings;

import java.util.HashMap;

/**
 * Created by rmukherj on 9/11/16.
 *
 * 0--a--1--b--2--a--3--b--4--a
 */
public class FiniteAutomata {

    private String pattern;
    private int[][] transitionMatching;
    private char[] alphabetSet;
    private HashMap<Character, Integer> charToIndexMap;



    public FiniteAutomata(String pattern, char[] alphabetSet){
        this.pattern = pattern;
        this.alphabetSet = alphabetSet;
        this.charToIndexMap = new HashMap<>();

        for (int i = 0; i < alphabetSet.length ; i++) {
            this.charToIndexMap.put(alphabetSet[i],i);
        }
    }

    public void InitializeAutomata(){
        this.transitionMatching = new int[this.pattern.length()+1][this.alphabetSet.length];
        int m = pattern.length();
        for (int q = 0; q <=m; q++) {
            String automataPattern = pattern.substring(0,q);
            for(int i=0;i<alphabetSet.length;i++){
                char a = this.alphabetSet[i];
                String aDelta = automataPattern + a;
                if(aDelta.length()>m){
                    aDelta = aDelta.substring(aDelta.length()-m);
                }

                while(!IsPrefix(this.pattern, aDelta)){
                    String temp = aDelta.substring(1);
                    aDelta = temp;
                }

                this.transitionMatching[q][i] = aDelta.length();
            }
        }
    }

    private boolean IsPrefix(String pattern, String aDelta) {
        if(aDelta.length()==0)
            return true;

        for (int i = 0; i < aDelta.length() ; i++) {
            if(aDelta.charAt(i)!=pattern.charAt(i))
            {
                return false;
            }
        }

        return true;
    }

    private void Match(String input){
        int n = input.length();
        int q = 0;
        for (int i = 0; i < n; i++) {
            q = this.transitionMatching[q][this.charToIndexMap.get(input.charAt(i))];
            if(q==this.pattern.length()){
                System.out.println("Valid Shift:" + (i+1-q));
            }
        }
    }

    public static void main(String[] args) {
        String p = "ababaca";
        char[] sigma = {'a','b','c'};
        FiniteAutomata f = new FiniteAutomata(p, sigma);
        f.InitializeAutomata();
        f.Match("bababacaababbacaababaca");
    }

}
