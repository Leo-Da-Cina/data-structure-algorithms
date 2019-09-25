
//11p8 is question 11.8
public class Ques11p8 {
   //make a binary search tree
   private TreeNode root;
   
   public static void main(String[] args){
   
   
   }
   
   //make a new tree node using num and insert it in a the
   //binary search tree
   public static void track(int num){
      if(root == null) {
         root = new TreeNode(num);
      } else {
         root.insert(num);
      }
        
   }

   //return the rank of the input number
   public static int getRankOfNumber(int num){
   
      return root.getRank(num);
   }

}