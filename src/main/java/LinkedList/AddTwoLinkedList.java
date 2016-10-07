package LinkedList;

/**
 * Created by rmukherj on 8/23/16.
 * You are given two linked lists representing two non-negative numbers. The digits are
 stored in reverse order and each of their nodes contains a single digit. Add the two
 numbers and return it as a linked list.
 Input: (2 􀃆 4 􀃆 3) + (5 􀃆 6 􀃆 4)
 Output: 7 􀃆 0 􀃆 8
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class AddTwoLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int digit = carry + x + y;
            carry = digit / 10;
            curr.next = new ListNode(digit % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        AddTwoLinkedList addTwo = new AddTwoLinkedList();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(50);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = addTwo.addTwoNumbers(l1,l2);

        while(l3!=null){
            System.out.println(l3.val);
            l3 = l3.next;
        }

    }
}
