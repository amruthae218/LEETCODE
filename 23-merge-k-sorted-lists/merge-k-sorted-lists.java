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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a, b) -> a.val - b.val);;
        for(ListNode head:lists){
            if(head!=null)pq.offer(head);
        }
        while(!pq.isEmpty()){
            ListNode nextNode=pq.poll();
            tail.next=nextNode;
            tail=tail.next;
            if(nextNode.next!=null)pq.offer(nextNode.next);
        }
        return dummy.next;
    }
}