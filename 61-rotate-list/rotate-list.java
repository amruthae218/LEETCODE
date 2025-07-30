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
        if(head==null || head.next==null)return head;
        ListNode temp=head;
        int cnt=1;
        while(temp.next!=null)
        {
            temp=temp.next;
            cnt++;
        }
        temp.next=head;
        k=k%cnt;
        int rem=cnt-k;
        while(rem>0)
        {
            temp=temp.next;
            rem--;

        }
        ListNode head2=temp.next;
        temp.next=null;
        return head2;

    }
}