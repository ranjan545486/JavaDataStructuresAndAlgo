package LinkedInQuestions.PriorityQueue;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rmukherj on 8/19/16.
 */
class ListNode {
    public int data;       // data stored in this node
    public ListNode next;  // link to next node in the list

    // post: constructs a node with data 0 and null link
    public ListNode() {
        this(0, null);
    }

    // post: constructs a node with given data and null link
    public ListNode(int data) {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

public class MergeKSortedLists {

    public ListNode mergeKlists(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> queue =
                new PriorityQueue<>(new Comparator<ListNode>(){
                    public int compare(ListNode l1, ListNode l2){
                        return l1.data -l2.data;
                    }
                });
        return null;

    }
}
