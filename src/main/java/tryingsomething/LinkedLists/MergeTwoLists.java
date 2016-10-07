package tryingsomething.LinkedLists;

/**
 * Created by rmukherj on 10/4/16.
 */
public class MergeTwoLists {
    public Node mergeTwoLists(Node l1, Node l2) {
        Node head = new Node(0);
        Node p=head;

        Node p1=l1;
        Node p2=l2;
        while(p1!=null && p2!=null){
            if(p1.data < p2.data){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p=p.next;
        }

        if(p1!=null){
            p.next = p1;
        }

        if(p2!=null){
            p.next = p2;
        }

        return head.next;
    }
}
