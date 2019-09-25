
public class TreeNode{
   public int value;
   // it's important to initialize left_size as zero,since a new TreeNode has no
   //left children. left_size increments by 1 every time a new node inserted into 
   //its left subtree.
   public int left_size = 0;
   public TreeNode left;
   public TreeNode right;
   
   public TreeNode(int num){
      value = num;
   } 
   
   //this method will insert new node by gliding the number down into 
   //left and right subtree. In order to keep balance, additional methods
   //needed to check the balance and restore balance
   public void insert(int num){
      if(num <= value){
      //insert into the left subtree
         if(left == null){
            left = new TreeNode(num);
         } else {
            left.insert(num);
         }
         left_size++;
      } else {
      //insert into the right subtree
         if(right == null) {
            right = new TreeNode(num);
         } else {
            right.insert(num);
         }
      }   
   
   }
   
   //the simplest way to get rank is do in-order traverse 
   //this method is more efficient than that by utilizing left_size
   //the basic idea is to traverse the binary search tree from the root, go left or right util
   //the num is found. When pass a node <= num (i.e. go right), increment counter by
   //1+ node.left_size; return -1 if num is not a node of the tree
   public int getRank(int num){
      if(num == value){
         return left_size;
      } else if(num > value){
         if(right == null) return -1; 
         else return left_size + 1 + right.getRank(num);  
      } else {
         if(left == null) return -1;
         else return left.getRank(num);
      }
   }

}