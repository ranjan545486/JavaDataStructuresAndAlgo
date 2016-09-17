package tryingsomething;

import java.util.Stack;

/**
 * Created by rmukherj on 7/26/16.
 */


public class StackPrac {
    public static String sbu = "Harry has a heart";
    public static Stack<String> sb = new Stack<>();

    public static void reverse(String s1){
        int i=0;
        String[] arr = sbu.split(" ");
        for (String a: arr
             ) {
            sb.push(a);
            sb.push(" ");

        }

        while(!sb.isEmpty()){
            s1 += sb.pop();
        }

        System.out.println(s1);
    }

    public static void wordRotate(String word, Integer length){
        if(length>0) {
            //for(int i =word.length();i>0;i--) {
            Character first = word.charAt(0);
            String s = word.substring(1);
            //String rem = s + first;
            String rem = s + first;
            System.out.println(rem);
            wordRotate(rem, length - 1);
        }

    }

    public static String wordReverse(String word){
        if(null == word || word.length()<=1){
            return word;
        }

        // if just want to send that same word back reversing in one shot then below return.
        //return wordReverse(word.substring(1))+word.charAt(0);

       return wordReverse(word.substring(1))+word.charAt(0);


    }

    public static void swapper(char[] wordArray, int start, int end){
        while(start<end){
            char temp = wordArray[start];
            wordArray[start] = wordArray[end];
            wordArray[end] = temp;
            start++;
            end--;
        }
    }

    public static String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }
    //================reverse words in-place without allocating extra space===================
    public void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    //======================================end===============================================
    public static void main(String[] args){
        StackPrac spi= new StackPrac();
        char[] c = new char[]{'t','h','e', ' ', 's','k','y'};


       spi.reverseWords(c);

        String w = "ranjan";
        String g = "ranjan is the person";
        wordRotate(w, w.length());


       String str = wordReverse(g);
        char[] charArray = str.toCharArray();
        int start = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]==' '){
                swapper(charArray,start,i-1);
                start = i+1;

            }

        }

        swapper(charArray, start, charArray.length - 1);

        //String x = swapper(str.toCharArray(),0,str.length()-1);
       // System.out.println("The reverse string passed is "+str);
        String st = reverseWords(g);
        System.out.println(st);

    }


}

