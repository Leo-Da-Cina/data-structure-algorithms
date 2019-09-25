

public class LearningHeap{
   private int currentSize;
   private int[] array;
   /*
   public void insert(int x){
      if(currentSize == array.length - 1){
         //double arraysize
      }
      int hole = currentSize++;//the end of heap
      for(array[0] = x; x.compareTo(array[hole/2]) < 0 ;hole /= 2)
         array[hole] = array[hole/2];
      
      array[hole] = x;
   }
   */
   //use a for loop to percolateDown the hole th element
   
   private void percolateDown1(int hole){
      //loop from hole to the last one, each time double hole
      //to search its children
      int child = hole*2;
      for( ; 2*hole < currentSize; hole = child){
         //search for smaller child
         child = hole*2;
         if(array[child] > array[child+1]){
            child++;
         }
         //compare hole value to smaller child, swap if hole value is 
         //larger
         if(array[hole] > array[child]){
            int tmp = array[hole];
            array[hole] = array[child];
            array[child] = tmp;
         } else{
            break;
         } 
      
      }
   
   }
   
  
   //use recursion to percolateDown holeth element
   private void percolateDown2(int hole,boolean isLargerThanChildren){
      //base case is when hits the end of array or that
      //current element is less than its children
      if(hole < currentSize && isLargerThanChildren){
         int child = hole*2;
         if(array[child] > array[child+1])
            child++;
         if(array[hole] > array[child]){
            int tmp = array[hole];
            array[hole] = array[child];
            array[child] = tmp;   
         } else {
            isLargerThanChildren = false;
   
         }
         
         percolateDown2(child,isLargerThanChildren);
      
      
      
      }
   }


}