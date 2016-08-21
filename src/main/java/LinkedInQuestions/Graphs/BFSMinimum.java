package LinkedInQuestions.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by rmukherj on 8/15/16.
 */

class Pair<X, Y> extends Object{

    public final X left;
    public final Y right;

    public Pair(X left, Y right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left + "," + right + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Pair)) {
            return false;
        }
        Pair<X, Y> other_ = (Pair<X, Y>) other;
        return Objects.equals(other_.left, this.left) && Objects.equals(other_.right, this.right);
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int result = 1;
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        return result;
    }

}

class Tuple<X, Y> {
    public final X x;
    public final Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tuple)){
            return false;
        }

        Tuple<X,Y> other_ = (Tuple<X,Y>) other;

        // this may cause NPE if nulls are valid values for x or y. The logic may be improved to handle nulls properly, if needed.
        return other_.x.equals(this.x) && other_.y.equals(this.y);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }
}
public class BFSMinimum {

    public void bfsMin() throws IOException {
        Queue<Pair<String, Integer>> grph = (Queue<Pair<String,Integer>>) new LinkedList<Pair<String, Integer>>();
        HashSet<String> words =
                new HashSet<>();
        //{"cat","bat","bet","bot","bog","dog","cot","dot","dog"
        // };
        words.add("cat");
        words.add("bat");
        words.add("bet");
        words.add("bot");
        words.add("bog");
        words.add("dog");
        words.add("cot");
        words.add("dot");
        words.add("dog");


        HashSet<String> visited = new HashSet<String>();
        String allEnglishCharacters = "abcdefghijklmnopqrstuvwxyz";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String start = null;
        String end = null;
        // if console is not null


        // read line from the user input
        start = "cat";//br.readLine();
        System.out.println("The start is " + start);
        end = "cot";//br.readLine();

        System.out.println("The end is " + end);
        //grph..add( new Pair<String,Integer>( start, 1 ));
        grph.add(new Pair<String, Integer>(start, 1));

        int level = -1;
        while (grph.size() > 0) {
            Pair<String, Integer> target = grph.remove();
            String src = target.left;
            for (int i = 0; i < src.length(); i++) {
                for (Character c : allEnglishCharacters.toCharArray()) {
                    String res = src.substring(0, i) + c + src.substring(i + 1);
                    //Optimization to reduce unnecessary checks
                    if (visited.contains(res)) {
                        continue;
                    } else {
                        visited.add(res);
                    }
                    // if target word found exit
                    if (res == end) {
                        level = target.right + 1;
                        //System.out.println("The level is "+ level);
                        break;
                    }
                    // if found in dictionary add
                    if (words.contains(res)) {
                        grph.add(new Pair<String, Integer>(res, target.right + 1));
                        //System.out.println("The level is "+ level);
                    }
                }
                if (level != -1)
                    break;
            }
            if (level != -1)
                break;
        }

        System.out.println("The level is "+ level);

    }


    public static void main(String[] args) throws IOException {
        BFSMinimum bfs = new BFSMinimum();
        bfs.bfsMin();
    }
}



