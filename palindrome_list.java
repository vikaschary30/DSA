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
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode rh=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return rh;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode temp1=middleNode(head);
        ListNode temp2=reverse(temp1);
        int f=0;
        ListNode p1=head;
        ListNode p2=temp2;
        while(p1!=null && p2!=null){
            if(p1.val!=p2.val){
                return false;
            }
            p1=p1.next;
            p2=p2.next;
                f=1;
        }
        if(f==1){
            return true;
        }
        else{
            return false;
        }
    }
}