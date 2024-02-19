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

    public ListNode remove(ListNode head, int pos){
        if(pos == 1){
            return head.next;
        }

        ListNode smallHead = remove(head.next, pos-1);
        head.next = smallHead;

        return head;

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;

        ListNode temp = head;

        //calculating length of the LL
        while(temp != null){
            length++;
            temp = temp.next;
        }

        //calculating index to be deleted from start
        int posFromStart = length - n + 1;

        //using this method to solve rest
        return remove(head, posFromStart);
    }
}