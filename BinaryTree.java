



// Recursive Java program for level order traversal of Binary Tree
 
/* Class containing left and right child of current 
   node and key value*/
class TreeNode
{
    int data;
    TreeNode left, right;
    public TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}
 
class BinaryTree
{
    // Root of the Binary Tree
    private TreeNode root;
    private int cnt = 0;
    public BinaryTree()
    {
        root = null;
    }
 
    public int height() {
        return helper(this.root);   
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
 
        } else {    
            return Math.max(helper(root.left), helper(root.right)) + 1;
        }
    }
    
    public TreeNode findLCA(int p,int q){
         return findLCA(root,p,q);
    }
    private TreeNode findLCA(TreeNode root, int p, int q){
         if(root == null){
            return null;
         } else if(root.data == p || root.data == q){
            return root;
         } else {
            TreeNode leftLCA = findLCA(root,p,q);
            TreeNode rightLCA = findLCA(root,p,q);
            if(leftLCA != null && rightLCA != null){
               return root;
            } else {
               return (leftLCA != null)?leftLCA:rightLCA;
            }
         
         }
    
    }
    
    
    public int kthSmallest(int k) {
         return kthhelper(root,k);
         
    }
    private int kthhelper(TreeNode root, int k){
        if(root == null) return 0;
        int result = 0;
        result = kthhelper(root.left,k);
        cnt++;
        if(cnt == k) {
            return root.data;
        }
        result += kthhelper(root.right,k);
        return result;
    }
    
    
    private int[] firstMismatch(TreeNode t1, TreeNode t2){
      if(t1 == null && t2 == null) return new int[0];
      if(t1 == null) return new int[]{null,t2.data};
      if(t2 == null) return new int[]{t1.data,null};
      int[] left = firstMismatch(t1.left,t2.left);
         if(left.length > 0) return left;
         if(t1.data != t2.data) return new int[]{t1.data,t2.data};
      int[] right = firstMismatch(t1.right, t2.right);
         if(right.length > 0) return right;
    
    }
    
    
    
    
    
    
    
     
         /* Driver program to test above functions */
    public static void main(String args[])
    {
       BinaryTree tree = new BinaryTree();
       tree.root= new TreeNode(4);
       tree.root.left= new TreeNode(2);
       tree.root.right= new TreeNode(3);
       tree.root.left.left= new TreeNode(1);
       tree.root.left.right= new TreeNode(6);
       tree.root.right.left= new TreeNode(5);
       tree.root.right.right= new TreeNode(7);

       /*System.out.println("LCA(4, 5) = " +
                            tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " +
                            tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                            tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                            tree.findLCA(2, 4).data);*/
                            
                            
        int kth = tree.kthSmallest(1);                     
                            
       
    }
}
