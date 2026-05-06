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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode temp = head;

        while(temp.next != null){
            int val1 = temp.val;
            int val2 = temp.next.val;

            int gcdVal = gcd(val1,val2);

            ListNode nextVal = temp.next;
            ListNode gcdNode = new ListNode(gcdVal);

            temp.next = gcdNode;
            gcdNode.next = nextVal;

            temp = temp.next.next;
        }

        return head;

    }

    public int gcd(int a, int b){
        int smaller = Math.min(a,b);
        int bigger = Math.max(a,b);

        int remainder = bigger%smaller;

        while(remainder != 0){
            int temp = smaller;
            smaller = remainder;
            bigger = temp;
            remainder = bigger%smaller;
        }

        return smaller;
    }
}