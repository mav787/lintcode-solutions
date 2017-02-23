package linkedListAndArray;

public class TTT599 {
	public ListNode insert(ListNode node, int x) {
        // Write your code here
        
        // copy of answer
       if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }

        ListNode nextNode = node;
        ListNode prev = null;
        do {
            prev = nextNode;
            nextNode = nextNode.next;
            if (x <= nextNode.val && x >= prev.val) { 
                break;
            }
            if ((prev.val > nextNode.val) && (x < nextNode.val || x > prev.val)) {
                break;
            }
        } while (nextNode != node);

        ListNode newNode = new ListNode(x);
        newNode.next = nextNode;
        prev.next = newNode;
        return newNode;
    }
}
