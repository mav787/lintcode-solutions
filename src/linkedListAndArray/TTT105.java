package linkedListAndArray;

import java.util.HashMap;

public class TTT105 {
	public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        
        RandomListNode newHead = cloneRegularList(head,map);
        return cloneRandomPointer(head,map);
    }
    
    private RandomListNode cloneRegularList(RandomListNode node,HashMap<RandomListNode,RandomListNode> map){
       if (node.next == null){
           RandomListNode newNode = new RandomListNode(node.label);
           map.put(node,newNode);
           return newNode;
       }
       
       RandomListNode curr = new RandomListNode(node.label);
       map.put(node, curr);
       RandomListNode newHead = curr;
       RandomListNode next;
       
       while(node.next != null){
           next = new RandomListNode(node.next.label);
           map.put(node.next, next);
           curr.next = next;
           curr = curr.next;
           node = node.next;
       }
        return newHead;
    }
    
    private RandomListNode cloneRandomPointer(RandomListNode node,HashMap<RandomListNode,RandomListNode> map){
        RandomListNode newHead = map.get(node);
        while (node != null){
            RandomListNode rand = node.random;
            RandomListNode newNode = map.get(node);
            RandomListNode newRand = map.get(rand);
            newNode.random = newRand;
            node = node.next;
        }
        return newHead;
    }
}


class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  }
