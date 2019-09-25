
public class ListNodeLearning{
   public static void main(String[] args){
      ListNode head = new ListNode(1);
      head.next = new ListNode(0);
      head.next.next = new ListNode(-1);
      deleteNode(head);           
   
   
   }

   public static void deleteNode(ListNode node){
      if(node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;      
   }

   public static boolean isPalindrome(ListNode head) {
       if(head == null || head.next == null) return true;
       boolean result = true;
       //find middle node
       ListNode slow = head, fast = head;
       //if fast.next == null, then it's of odd length, slow points at last node of left half, 
       //else if fast.next.next == null, it's of even length, slow points at the middle node which will be included in the left half
       while(fast.next != null && fast.next.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       ListNode rightHead = slow.next;
       slow.next = null; // important, cut the left half off the right half
       //reverse the right half
       rightHead = reverseList(rightHead);
       ListNode left = head; ListNode right = rightHead;
       while(left != null && right != null){
           if(left.val != right.val){
               result = false;
               break;
           } 
           left = left.next;
           right = right.next;
       }
       //reverse right half back and connect to left half 
       rightHead = reverseList(rightHead);
       slow.next = rightHead;
       return result;
       
    }
    
    private static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = head; ListNode newHead;
        while(p.next != null){
            newHead = p.next;
            p.next = newHead.next;
            newHead.next = head;
            head = newHead;
        }
        return head;
        
        
    }
    
   
}