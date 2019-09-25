

public class LinkIntList{
   private ListNode front;
   
   public LinkIntList(ListNode front){
      this.front = front;
   }
   
   public void removeDuplicates(){
      ListNode current = this.front;
      while(current != null){
         ListNode runner = current;
         //runner go through rest of list to find duplicates
         while(runner.next != null){
            if(runner.next.data == current.data){
               runner.next = runner.next.next;
            } else{
               runner = runner.next;
            }
         
         }
         current = current.next;
      }  
   }
   
   //switch each pair of elements in the list
   public void switchPairs(){
      if(this.front != null && this.front.next != null){
         //switch first two 
         ListNode now = this.front.next;
         front.next = now.next;
         now.next = front;
         front = now;
         now = front.next;
         
         //switch rest nodes if there exist 
         while(now.next != null && now.next.next != null){
            ListNode tmp = now.next.next;//a new pointer points to a second node to be switched
            now.next.next = tmp.next;//the first node points to the node right behind second node
            tmp.next = now.next;//second node points first node;
            now.next = tmp; //tmp.i.e.second node which became first node be pointed by previous node
            now = tmp.next; //move now to the node right before two nodes that will be switched.   
         }
      //summary: first two node switch is a special case
      //general case showes up after that. two pointers needed, one points to the second node, another
      //one always points the node right before first node
      //two ways to solve this problem, say we are switching node 1 and node 2
      // we need two pointers. now always points to the node right before node 1
      // tmp can either 1) points to node 1 , 2) points to node 2
      //above method is for the case that tmp points node 2;
      
      
      }
   
   }
   
   //resverse each successive sequence 3 elements in a list 
   public void reverse3(){
      if(front != null && front.next != null && front.next.next !=null){
         //reverse first three
         ListNode t1 = front;
         front = t1.next.next;
         ListNode t2 = front.next;
         front.next = t1.next;
         t1.next.next = t1;
         t1.next = t2;//now t1 points the node before node 1, t2 at node 1
        
         //reverse next sequence if there are 3 elements in that sequence
         while(t2 != null && t2.next != null && t2.next.next !=null){
            t1.next = t2.next.next;
            t1 = t2;
            t2 = t2.next.next.next;
            t1.next.next.next = t1.next;
            t1.next.next = t1;
            t1.next = t2;
         }
      }

   }
   
   //split a list into two halves, the first half has one more element if size is odd
   public ListNode splitHalf(){
      if(front != null && front.next != null){
         if(front.next.next == null){ // only two elements
            ListNode secondHalf = front.next;
            front.next = null;
            return secondHalf;
         }else {  
            ListNode c1 = this.front;
            ListNode c2 = this.front;
            while(c2.next.next != null){
               c1 = c1.next;
               c2 = c2.next.next;
               if(c2.next == null){
                  break;
               }
        
            }
            ListNode secondHalf = c1.next;
            c1.next = null;
            return secondHalf;
       }
     }
     return new ListNode();
   }

   //
   public void moveSecondToLastToFront(){
      if(front != null && front.next != null && front.next.next != null){
         ListNode current1  = front;
         while(current1.next.next.next != null){
            current1 = current1.next;
         }
         ListNode current2 = current1.next;
         current1.next = current2.next;
         current2.next = front;
         front = current2;
      }
   }
   
   public void add(ListNode node){
      ListNode current = this.front;
      while(current.next != null){
         current = current.next;
      }
      current.next = node;
   }
   
   public String toString() {
 
      if (front == null) {
  
          return "[]";
   
      } else {
 
          String result = "[" + front.data;
          ListNode current = front.next;
          while (current != null) {
            
          result += ", " + current.data;
            
          current = current.next;
        
          }
        
          result += "]";
        
          return result;
    
      }
   }
   

    public ListNode mergeTwoLists(ListNode l2) {
        ListNode now1 = this.front;
        ListNode now2 = l2;
        return helper(now1,now2);
    }
    
    private ListNode helper(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;//base case
        } else if(l2 == null) {
            return l1;//base case
        } else {
            //recursive case
            if(l1.data < l2.data){
               l1.next = helper(l1.next,l2);
               return l1;
            } else if(l1.data > l2.data){
               l2.next = helper(l1,l2.next);
               return l2;
            } else {
               l2.next = helper(l1.next,l2.next);
               l1.next = l2;
               return l1;
            }
        }
        
    }

   
   public static void main(String arg[]){
      LinkIntList list = new LinkIntList(new ListNode(1));
      //list.add(new ListNode(1,new ListNode(2,new ListNode(1,new ListNode(2,new ListNode(3))))));
      list.add(new ListNode(3));
      list.add(new ListNode(4));
      System.out.println(list);
      LinkIntList list2 = new LinkIntList(new ListNode(1));
      list2.add(new ListNode(5));
      System.out.println(list2);
      list.mergeTwoLists(list2.front);
     
      //list.moveSecondToLastToFront();
      //ListNode second = list.splitHalf();
      System.out.println(list);
      //System.out.println(new LinkIntList(second));
      
   } 
   
   
   
}