
//make a point

public class Point{
   public int row; 
   public int col;
   public Point(int x, int y){
      this.row = x;
      this.col = y;
   }
  
   public boolean isBefore(Point other){
      if(row <= other.row && col <= other.col){
         return true;
      } else {
         return false;
      }      
   
   } 
 
   public Object clone(){
      return new Point(this.row,this.col);
   }
   
   public void setToAverage(Point a, Point b){
      this.row = (a.row + b.row)/2;
      this.col = (a.col + b.col)/2;
   }
   
   public boolean inbounds(int[][] m){
      return row >= 0 && col >= 0 && row < m.length && col < m[0].length; 
   }
}