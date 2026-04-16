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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pL1 = list1;
        ListNode pL2 = list2;
        ListNode head;
        
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val <= list2.val){
            head = list1;
            pL1 = pL1.next;
        }
        else{
            head = list2;
            pL2 = pL2.next;
        }

        while(pL1 != null || pL2 != null){
            int l1value = Integer.MAX_VALUE;
            int l2value = Integer.MAX_VALUE;

            if(pL1 != null){
                l1value = pL1.val;
            }

            if(pL2 != null){
                l2value = pL2.val;
            }

            if(l1value <= l2value){
                head.next = pL1;
                pL1 = pL1.next;
            }else{
                head.next = pL2;
                pL2 = pL2.next;
            }

            head = head.next;
        }

        if(list1.val <= list2.val){
            return list1;
        }
        else{
            return list2;
        }
    }
}