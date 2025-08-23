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
    public ListNode findkth(ListNode head,int k)
    {
        ListNode temp=head;
        while(temp!=null && k>1)
        {
            temp=temp.next;
            k--;
        }
        return temp;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode front =temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null|| head.next==null) return head;
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode kth=findkth(temp,k);
            if(kth==null)
            {
                if(prev!=null)
                {
                    prev.next=temp;
                    break;
                }
            }
            ListNode nextNode =kth.next;
            kth.next=null;
            ListNode reversedH=reverse(temp);
            if(temp==head)
            {
                head=reversedH;
            }
            else
            {
                prev.next=reversedH;
            }
            prev=temp;
            temp=nextNode;
        }
        return head;
    }
}