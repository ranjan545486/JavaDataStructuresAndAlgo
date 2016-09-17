package LinkedList;

/**
 * Created by rmukherj on 8/23/16.
 */
public class RemoveNthNodeFromEndOfList {
    public LinkedList.Node removeNthFromEnd(LinkedList.Node head, int n) {
        if(head == null)
            return null;

        LinkedList.Node fast = head;
        LinkedList.Node slow = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        //if remove the first node
        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
