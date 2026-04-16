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
    public void reorderList(ListNode head) {

        //Find middle
        ListNode middle = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            middle = middle.next;
            fast = fast.next.next;

            if(fast == null) break;
        }

        //Reverse from middle
        ListNode prev = null;
        ListNode curr = middle.next;
        middle.next = null;

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }


        ListNode currMerged = head;

        //Merge 2 arrays
        while(prev != null){
            ListNode reverseNext = prev.next;
            ListNode currNext = currMerged.next;
            currMerged.next = prev;
            prev.next = currNext;

            currMerged = currNext;
            prev = reverseNext;
        }
    }
}
