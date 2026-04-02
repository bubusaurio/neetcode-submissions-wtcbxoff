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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carrier = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;

        while(l1 != null || l2 != null || carrier != 0){
            int l1Val = 0;
            int l2Val = 0;
            int sum = 0;

            if(l1 != null){
                l1Val = l1.val;
            }

            if(l2 != null){
                l2Val = l2.val;
            }
            
            sum = l1Val+l2Val+carrier;
            carrier = sum/10;

            ListNode newNode = new ListNode(sum%10);
            temp.next = newNode;
            temp = temp.next;
            

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
            
        }

        return result.next;
    }
}
