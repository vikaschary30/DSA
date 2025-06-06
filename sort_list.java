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
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode mid= getmid(head);
        ListNode left=head;
        ListNode right=mid.next;
        mid.next=null;
        left=sortList(left);
        right=sortList(right);
        return mergeTwoLists(left,right);
    }
    public ListNode getmid(ListNode temp){
        ListNode slow=temp;
        ListNode fast=temp;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode p1=list1;
        ListNode p2=list2;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                prev.next=p1;
                p1=p1.next;
                prev=prev.next;
            }
            else{
                prev.next=p2;
                p2=p2.next;
                prev=prev.next;
            }
        }
        if(p1!=null){
            prev.next=p1;
        }
        if(p2!=null){
            prev.next=p2;
        }
        return dummy.next;
    }
}