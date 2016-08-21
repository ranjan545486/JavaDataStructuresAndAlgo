package LinkedInQuestions.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rmukherj on 8/19/16.
 */
public class PriorityQueueTest {

    static class PQSort implements Comparator<Integer>{

        public int compare(Integer one, Integer two){
            return two -one;

        }
    }

    public static void main(String[] args) {
        int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();

        // use offer() method to add elements to the PriorityQueue pq1
        for (int x : ia) {
            pq1.offer(x);
        }

    }
}
