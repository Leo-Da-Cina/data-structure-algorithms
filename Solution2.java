/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    
    public Solution2(ListNode head){
         
    }
    
    
    public static void main(String[] args){
         ListNode head = new ListNode(3);
         head.next = new ListNode(2);
         head.next.next = new ListNode(1);
         Solution2 sol = new Solution2(head);
      
         ListNode newHead = sol.insertionSortList(head);
         System.out.println(1);
    }
    
    
    public ListNode insertionSortList(ListNode head) {
        ListNode now = head;
        if(head == null){
            return head;
        }
        
        while(now != null && now.next != null){
            //compare now.data to all previous nodes and insert it in the right position
            head = bubbleUp(now,head);
        }
        return head;
    }
    
    private ListNode bubbleUp(ListNode now, ListNode head){
        ListNode previous = head;
        if(previous.val > now.next.val){
            //insert now.next node in the front if it's smallest value
            ListNode tmp = now.next;
            now.next = now.next.next;
            tmp.next = previous;
            head = tmp;
        }else {
            //search the correct position for now.next node
            while(previous.next != null && previous.next.val < now.next.val){
                previous = previous.next;
            }
            //insert now.next node in the found position
            ListNode tmp = now.next;
            now.next = now.next.next;
            tmp.next = previous.next;
            previous.next = tmp;
            
        }
        return head;
    }
}