package linkedListAndArray;

public class TTT102 {
	public boolean hasCycle(ListNode head) {  
        // write your code here
        if(head == null){
            return false;
        }
        
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
