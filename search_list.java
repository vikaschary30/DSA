/* Node of a linked list
  class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/
class Solution {
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        if(head==null){
            return false;
        }
        while(head!=null){
            if(head.data==key){
                return true;
            }
            head=head.next;
        }
        return false;
    }
}