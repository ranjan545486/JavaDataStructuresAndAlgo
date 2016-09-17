package tryingsomething.Arrays;

/**
 * Created by rmukherj on 8/30/16.
 */

class ListNode1 {
      int val;
      ListNode1 next;
      ListNode1(int x) { val = x; }
  }
public class ReverseArray {

    //iterative o(n)      space o(1)

    public ListNode1 reverseList(ListNode1 head) {
        ListNode1 prev = null;
        ListNode1 curr = head;
        while (curr != null) {
            ListNode1 nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //recursive.
    public ListNode1 reverseListRecursive (ListNode1 head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode1 p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
