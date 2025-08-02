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
        ListNode t1=list1;
        ListNode t2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(t1!=null && t2!=null)
        {
            if(t1.val>t2.val)
            {
                tail.next=t2;
                t2=t2.next;
            }
            else
            {
                tail.next=t1;
                t1=t1.next;
            }
            tail=tail.next;
        }
        if(t1==null)tail.next=t2;
        if(t2==null)tail.next=t1;

        return dummy.next;
    }
}