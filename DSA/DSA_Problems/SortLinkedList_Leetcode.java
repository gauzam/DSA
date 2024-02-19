/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode merge2sortedLL(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        ListNode newHead = null;
        ListNode tail = null;

        if(temp1.val <= temp2.val){

            newHead = temp1;
            tail = temp1;
            temp1 = temp1.next;


        }
        else{
            newHead = temp2;
            tail = temp2;
            temp2 = temp2.next;
        }

        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                tail.next = temp1;
                temp1 = temp1.next;
                tail = tail.next;
            }
            else{
                tail.next = temp2;
                temp2 = temp2.next;
                tail = tail.next;
            }
        }

        if(temp1 != null){
            tail.next = temp1;
        }

        if(temp2 != null){
            tail.next = temp2;
        }

        return newHead;

    }
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow points to tail of first LL
        ListNode tail1 = slow;

        //head of 2nd LL
        ListNode head2 = slow.next;

        tail1.next = null;

        //using recursive call to sort first LL
        ListNode head1 = sortList(head);
        //using recursive call to sort second LL
        head2 = sortList(head2);

        //merging two sorted LL
        ListNode newHead = merge2sortedLL(head1, head2);

        return newHead;
    }
}