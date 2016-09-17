package LinkedInQuestions.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rmukherj on 8/22/16.
 */
public class WordWrap {
    static void justifyString(List<String> s, int n){
        char[] charArr = new char[n];
        LinkedList<String> just = new LinkedList<>();

        for(String st : s){
            char[] ch = st.toCharArray();
            String str = just.peekLast();
            if(st.length() >n){
                just.addLast(st.substring(0,n));
                just.addLast(st.substring(n,st.length()));
            }
            else if (str == null){

                {
                    just.addLast(st);
                }
            }
            else if(st.length() + str.length() + 1<=n){
                just.removeLast();
                just.addLast(str + " " + st);
            }
            else {
                just.addLast(st);
            }
        }

        for(String j : just) {
            System.out.println(j);
        }
    }

    public static void main(String args[]) {
        List<String> st = new ArrayList<String>();
        st.add("aaa");
        st.add("bb");
        st.add("cc");
        st.add("ddddd");
        justifyString(st, 5);
    }
}
