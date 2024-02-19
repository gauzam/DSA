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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || k == 0){
            return head;
        }

        int length = 0;

        ListNode temp = head;

        while(temp != null){
            length++;
            temp = temp.next;
        }

        //calculating rotation in range [1, length-1]
        k = k%length;

        if(k == 0){
            return head;
        }

        int breakpoint = length - k;

        int count = 0;

        ListNode newHead = null;

        temp = head;

        while(temp != null){
            count++;

            //when we reach breakpoint, we find our new head and new tail
            if(count == breakpoint){
                newHead = temp.next;
                temp.next = null;
                break;
            }

            temp = temp.next;
        }

        temp = newHead;

        while(temp.next != null){
            temp = temp.next;
        }

        //appending head into rotated segment's end
        temp.next = head;

        return newHead;
    }
}