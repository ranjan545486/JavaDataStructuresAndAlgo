package tryingsomething.LinkedLists;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rmukherj on 10/4/16.
 */
class Node{
   public int data;
    public Node next;
    public Node(){}
    public Node (int data){
        this.data = data;
    }
}
public class MergeKLists {
    public Node mergeKLists(Node[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });

        Node head = new Node(0);
        Node p = head;

        for (Node list:
              lists) {
            if(list != null){
                queue.offer(list);
            }
        }

        while(!queue.isEmpty()){
            Node n = queue.poll();
            p.next = n;
            p = p.next;

            if(n.next != null){
                queue.offer(n.next);
            }
        }

        return head.next;
    }
}
