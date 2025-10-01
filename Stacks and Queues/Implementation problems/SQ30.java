
import java.util.HashMap;

// Implement LRU Cache - Problem Statement : “Design a data structure that follows the constraints of Least Recently Used (LRU) cache”.
//                                            Implement the LRUCache class:
//                                                  LRUCache(int capacity) we need to initialize the LRU cache with positive size capacity.
//                                                  int get(int key) returns the value of the key if the key exists, otherwise return -1.
//                                                  Void put(int key,int value), Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.if the number of keys exceeds the capacity from this operation, evict the least recently used key.
//                                                  The functions get and put must each run in O(1) average time complexity.
//                       1) optimal - TC:O(1(for all oprations)) SC:O(capacity) Your LRUCache uses a HashMap for O(1) lookups and a doubly linked list for O(1) insertions/removals, ensuring the most recently used item stays near the head and the least recently used item near the tail for quick eviction. 


class LRUCache{
    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key, int val){
            this.key=key;
            this.val=val;
            next=prev=null;
        }
    }
    HashMap<Integer,Node> hm=new HashMap<>();
    Node head=new Node(0,0), tail= new Node(0,0);
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    public int get(int key){
        if(!hm.containsKey(key)){
            return -1;
        }
        else{
            Node node=hm.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
    }
    public void put(int key, int val){
        if(hm.containsKey(key)){
            remove(hm.get(key));
        }
        if(hm.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key, val));
    }
    public void remove(Node node){
        hm.remove(node.key);
        Node prevnode=node.prev;
        Node afternode=node.next;
        prevnode.next=afternode;
        afternode.prev=prevnode;
    }
    public void insert(Node node){
        hm.put(node.key, node);
        Node aftermenode=head.next;
        head.next=node;
        node.next=aftermenode;
        node.prev=head;
        aftermenode.prev=node;
    }
}
class SQ30{
    public static void main(String[] args) {
        LRUCache lru=new LRUCache(3);
        lru.put(1, 1);
        lru.put(2, 2); 
        System.out.println(lru.get(1));    
        lru.put(3, 3); 
        System.out.println(lru.get(2));    
        lru.put(4, 4); 
        System.out.println(lru.get(1));    
        System.out.println(lru.get(3));    
        System.out.println(lru.get(4));    
    }
}