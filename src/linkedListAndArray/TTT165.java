package linkedListAndArray;

public class TTT165 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null || l2 == null){
            return l1 == null? l2 : l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        while(p != null || q != null){
            if (p == null){
                curr.next = q;
                return dummy.next;
            }
            if(q == null){
                curr.next = p;
                return dummy.next;
            }
            
            if(p.val <= q.val){
                curr.next = p;
                p = p.next;
                curr = curr.next;
            }
            else{
                curr.next = q;
                q = q.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
