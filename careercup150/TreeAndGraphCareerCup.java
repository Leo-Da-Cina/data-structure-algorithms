
import java.util.*;
public class TreeAndGraphCareerCup{
   
   public static void main(String[] args){
      
      /*UndirectedGraphNode node = new UndirectedGraphNode(0);
      node.neighbors.add(new UndirectedGraphNode(0));
      node.neighbors.add(new UndirectedGraphNode(0));
      UndirectedGraphNode newNode = cloneGraph(node);
      for(UndirectedGraphNode n : node.neighbors){
                  System.out.println(n.label);
                  System.out.println(n.neighbors);
      }
      */
      String s = "abc";
      System.out.println(s.substring(4));
      
   }
  
  public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> qClone = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode nodeClone = new UndirectedGraphNode(node.label);
        q.add(node); qClone.add(nodeClone);
        boolean exit = false;
        while(!exit && !q.isEmpty()){
        
                UndirectedGraphNode cur = q.remove();
                UndirectedGraphNode curClone = qClone.remove();
                  
                //explore its neighbours 
                for(UndirectedGraphNode n : cur.neighbors){
                    
                    curClone.neighbors.add(new UndirectedGraphNode(n.label));
                    q.add(n);
                    //exit condition
                    if(n.label == cur.label) exit = true;
                    
                }
                
                for(UndirectedGraphNode n : curClone.neighbors){
                  System.out.println(n.label);
                  System.out.println(n.neighbors);
                }
                
                qClone.addAll(curClone.neighbors);

        }
        
        return nodeClone;
    }
  
  
  
  
  
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null || root.left.value != root.right.value) return false;
        return isMirror(root.left.left,root.right.right) && isMirror(root.left.right, root.right.left); 
        
    }
    
    public static boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.value != t2.value) return false;
        return isMirror(t1.left,t2.right) && isMirror(t1.right, t2.left);
        
    }
   
      
   public static boolean isBalanced(TreeNode root,Height height){
      if(root == null) {
         height.height = 0; 
         return true;
      }
      boolean leftBalance = isBalanced(root.left,height);
      int leftHeight = height.height;
      boolean rightBalance = isBalanced(root.right,height);
      int rightHeight = height.height;
      //update the height
      height.height = 1+ Math.max(leftHeight,rightHeight);
      
      return (Math.abs(leftHeight - rightHeight) <= 1) && 
            leftBalance && rightBalance;
   }
   
   //is a binary search tree
   //definition: 
   //for every node, all left child n grandchildren <= now.val < all right child n grandchilden
   // now.left.val <= now.val < now.right.val is too weak, since now.left.right.val might be greater
   //than now.val
   /*wrong code
   public static boolean isBST(TreeNode now){
      if(now == null) return true;
      if((now.left != null && now.left.value > now.value)||
         (now.right != null && now.value >= now.right.value)) return false;
      return isBST(now.left) && isBST(now.right); 
   
   }
   */
   //start from [leftb rightb], check for every node now.value is within this boundary
   //update leftb with now.value if go to right subtree, update rightb with now.value if
   //go to left subtree
   public static boolean isBST(TreeNode now){
      return isBSTHelper(now,Integer.MIN_VALUE, Integer.MAX_VALUE);
   
   } 
   
   public static boolean isBSTHelper(TreeNode now, int min, int max){
      if(now == null) return true;
      if(!(min < now.value && now.value <= max)) return false;
      return isBSTHelper(now.left,min,now.value) && isBSTHelper(now.right, now.value,max);
   
   }


}