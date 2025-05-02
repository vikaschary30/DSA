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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy= new ListNode(-1);
        ListNode curr=head;
        ListNode prev=dummy;
        while(curr!=null){
            int var=curr.val;
            if(curr.next!=null && var==curr.next.val){
                while(curr!=null && var==curr.val){
                    curr=curr.next;
                }
            }
            else{
                prev.next=curr;
                curr=curr.next;
                prev=prev.next;
                prev.next=null;
            }
        }
        return dummy.next;
    }
}