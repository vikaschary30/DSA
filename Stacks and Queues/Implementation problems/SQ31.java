// LFU Cache - Problem Statement : Design and implement a data structure for a Least Frequently Used (LFU) cache.
//                                 Implement the LFUCache class with the following functions:
//                                 LFUCache(int capacity): Initialize the object with the specified capacity.
//                                 int get(int key): Retrieve the value of the key if it exists in the cache; otherwise, return -1.
//                                 void put(int key, int value): Update the value of the key if it is present in the cache, or insert the key if it is not already present. If the cache has reached its capacity, invalidate and remove the least frequently used key before inserting a new item. In case of a tie (i.e., two or more keys with the same frequency), invalidate the least recently used key.
//                                 A use counter is maintained for each key in the cache to determine the least frequently used key. The key with the smallest use counter is considered the least frequently used.
//                                 When a key is first inserted into the cache, its use counter is set to 1 due to the put operation. The use counter for a key in the cache is incremented whenever a get or put operation is called on it. Ensure that the functions get and put run in O(1) average time complexity.
//             1) optimal - TC:O(N) SC:O(capacity) 


import java.util.*;
class Node {
    int key, value, cnt;
    Node next;
    Node prev;
    
    Node(int _key, int _value) {
        key = _key;
        value = _value;
        cnt = 1;
    }
}

class List {
    int size; 
    Node head; 
    Node tail;
    
    List() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    
    void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
        size++;
    }
    
    
    void removeNode(Node delnode) {
        Node prevNode = delnode.prev;
        Node nextNode = delnode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
}

class LFUCache {
    private Map<Integer, Node> keyNode; 
    private Map<Integer, List> freqListMap; 
    private int maxSizeCache; 
    private int minFreq; 
    private int curSize; 
    

    public LFUCache(int capacity) {
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }
    

    private void updateFreqListMap(Node node) {

        keyNode.remove(node.key);
        freqListMap.get(node.cnt).removeNode(node);
        if (node.cnt == minFreq && freqListMap.get(node.cnt).size == 0) {
            minFreq++;
        }
        List nextHigherFreqList = new List();
        if (freqListMap.containsKey(node.cnt + 1)) {
            nextHigherFreqList = freqListMap.get(node.cnt + 1);
        }
        node.cnt += 1;
        nextHigherFreqList.addFront(node);
        freqListMap.put(node.cnt, nextHigherFreqList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key); 
            int val = node.value; 
            updateFreqListMap(node);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (maxSizeCache == 0) {
            return;
        }
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqListMap(node);
        } else {
            if (curSize == maxSizeCache) {
                List list = freqListMap.get(minFreq);
                keyNode.remove(list.tail.prev.key);
                freqListMap.get(minFreq).removeNode(list.tail.prev);
                curSize--;
            }
            curSize++;
            minFreq = 1;
            List listFreq = new List();
            if (freqListMap.containsKey(minFreq)) {
                listFreq = freqListMap.get(minFreq);
            }
            Node node = new Node(key, value);
            listFreq.addFront(node);
            keyNode.put(key, node);
            freqListMap.put(minFreq, listFreq);
        }
    }
    
}
public class SQ31 {
    public static void main(String[] args) {
        // LFU Cache
        LFUCache cache = new LFUCache(2);
        
        // Queries
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        System.out.print(cache.get(3) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(1) + " ");
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
    }
}