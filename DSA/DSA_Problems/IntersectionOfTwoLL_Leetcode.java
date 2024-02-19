/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode collisionPoint(ListNode largerLLhead, ListNode smallerLLhead, int diff){
        ListNode temp1 = largerLLhead;
        ListNode temp2 = smallerLLhead;

        int count = 1;

        while(count <= diff){
            temp1 = temp1.next;
            count++;
        }

        //both heads are aligned now

        while(temp1 != null && temp2 != null){

            if(temp1 == temp2){
                return temp1;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;

        }
        return null;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int length1 = 0;
        int length2 = 0;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1 != null){
            length1++;
            temp1 = temp1.next;
        }

        while(temp2 != null){
            length2++;
            temp2 = temp2.next;
        }

        if(length1 > length2){
            return collisionPoint(headA, headB, length1-length2);
        }
        else{
            return collisionPoint(headB, headA, length2-length1);
        }

    }
}