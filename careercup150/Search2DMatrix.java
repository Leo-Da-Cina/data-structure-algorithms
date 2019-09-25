
/* search an element in a 2D array
*/

public class Search2DMatrix {
   public static void main(String[] args){
      int[][] matrix = {{15,20,22,23},
                        {25,35,40,45},
                        {48,53,60,65},
                        {70,72,80,120}}; 
      int target  = 121;                  
      //Point origin = new Point(0,0);
      //Point dest = new Point(matrix.length - 1, matrix[0].length - 1); 
      //Point coord = findElement(matrix,target,origin,dest);
      System.out.println(searchMat(matrix,target));
   }
   
   public static boolean searchMat(int[][] matrix, int target) {
        return search(matrix, target,0,0,matrix.length - 1, matrix[0].length - 1);
    }
    
    public static boolean search(int[][] matrix, int target,int x1, int y1, int x2,int y2){
        if(x1 > x2 || y1 > y2) return false;
        if(target < matrix[x1][y1] || target > matrix[x2][y2]) return false;
        int midx = x1 + (x2 - x1)/2, midy = y1 + (y2 - y1)/2;
        if(matrix[midx][midy] == target) return true;
        if(matrix[midx][midy] < target) {
            return search(matrix, target, midx + 1, midy + 1, x2, y2) || search(matrix,target,x1, midy + 1, midx,y2) ||
                   search(matrix, target, midx + 1,y1, x2,midy);
        } else {
            return search(matrix, target, x1, y1, midx-1, midy-1) || search(matrix,target,x1, midy, midx - 1,y2) ||
                   search(matrix, target, midx,y1, x2,midy - 1);
        }
    }
   
   
    public static boolean searchMatrix(int[][] matrix, int target) {
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        if(nrow < 1 || ncol < 1 ) return false;
        if(target < matrix[0][0] || target > matrix[nrow - 1][ncol - 1]) return false;
        
        int st = 0, ed = nrow - 1;
        int mid = st + (ed - st)/2;
        while(st < ed){
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target) {
                ed = mid - 1;    
            } else {
                if(matrix[mid][ncol - 1] == target){
                    return true;
                } else if(matrix[mid][ncol - 1] > target) {
                    break;
                } else {
                    st = mid + 1;
                }
                
            }
            mid = st + (ed - st)/2;
        }
        
        //search mid th row
        int i = mid;
        if(matrix[i][0] > target || matrix[i][ncol - 1] < target) return false;
        st = 0; ed = ncol - 1; mid = st + (ed - st)/2;
        while(st < ed){
            if(matrix[i][mid] == target) return true;
            else if(matrix[i][mid] > target) ed = mid - 1;
            else st = mid + 1;
            mid = st + (ed - st)/2;
        }
        return false;
        
        
    }
   
   
   
   
   
   
   public static Point findElement(int[][] matrix, int target, Point origin, Point dest){
      
      //base case
      if(!origin.inbounds(matrix) || !dest.inbounds(matrix)){
         return null;
      }
      
      if(!origin.isBefore(dest)){
         return null;
      }
      if(matrix[origin.row][origin.col] == target){
         return origin;
      }
      
      if(matrix[dest.row][dest.col] == target){
         return dest;
      }


      //binary search pivot which is the first element in diagonal that's
      //greater than target
      Point pivot = new Point(0,0);
      Point start = (Point) origin.clone(); 
      Point end = (Point) dest.clone();
      while(start.isBefore(end)){
         pivot.setToAverage(start,end);
         if(matrix[pivot.row][pivot.col] == target){
            return pivot;
         
         } else if (matrix[pivot.row][pivot.col] > target){
            end.row = pivot.row - 1; end.col = pivot.col - 1;
         } else {
            start.row = pivot.row + 1; start.col = pivot.col + 1; 
         }   
      
      }
      //use this pivot value recursively search the lower left and upper right quadrants
      
      Point leftBotOrigin = new Point(start.row,origin.col);
      Point leftBotDest = new Point(dest.row,start.col - 1);
      Point rightUpOrigin = new Point(origin.row,start.col);
      Point rightUpDest = new Point(start.row - 1, dest.col);
      
      //recurisve case
      if (findElement(matrix,target,leftBotOrigin, leftBotDest) == null){
         return findElement(matrix,target, rightUpOrigin,rightUpDest);
      } else {
         return findElement(matrix,target,leftBotOrigin, leftBotDest);
      }   
      
      
   }
   
   






}