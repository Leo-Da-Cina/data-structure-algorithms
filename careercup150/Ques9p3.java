
//return the i where a[i] == i.
//Q: what if there are more than one magic index ? if we want to return the first one
//then brute force. Otherwise binary search might randomly choose one. 

public class Ques9p3 {
   public static void main(String[] args){
      int[] a = {-1,0,1,2,4};
      System.out.println("magic index of a : " + magicFast(a,0, a.length - 1));
   
   }
   
   //Brute force: for sorted array with distinct integers 
   public static int magicIndex(int[] a){
      for(int i = 0; i < a.length; i++){
         if(a[i] == i) return i;
         if(a[i] >= i + 1) break;
      }
      return -1;
   }
   
   //Brute force: find magic index in a sorted array with duplicate integers
   public static int magicIndexDuplicate(int[] a){
      for(int i = 0; i < a.length; i++){
         if(a[i] == i) return i;
         if(a[i] > i + 1) break;
      }
      return -1;
   }

   //binary search, distinct integers
   // index:   0 -  1 -  2 - ..- i - ...-  n, increment or decrement by 1
   // array: a[0]-a[1]-a[2]-...-a[i]-a[4]..a[n], increment or decrement by at least 1 
   // if a[i] > i, a[i+1] - a[i] >= 1, => a[i+1] >= a[i] + 1 > i + 1, there is no chance
   // to find magic index to the right of a[i]. If the elements to the left decrease more than by 1
   // then it's possible to have a[j] == j (j < i). 
   // if a[i] < i, a[i - 1] <= a[i] - 1, => a[i - 1] < i - 1, there is no way to find magic index
   // to the left. If the elements to the right increase more than 1, it's possible to catch up
   // with the index increment.i.e. a[j] == j (j > i)
   public static int magicFast(int[] a, int st, int end){
      if(st > end || a.length <= 0 ) return -1;
      int mid = st + ((end - st)>>1);
      while(st <= end){
         
         if(a[mid] == mid) return mid;
         else if(a[mid] > mid) end = mid - 1;  
         else st = mid + 1;
         mid = st + ((end - st)>>1);
      }
      return -1;
      
   }
   
   //binary search , duplicate integers
   // index, 0-1-2-3,...n, increase by 1
   // array, increase by at least zero (no longer by at least 1 like in the distinct case)
   // if a[mid] < mid or a[mid] > mid , we only know some values close to a[i] might not have magic
   // index. We still need to search both sides of a[i] though the boundaries can be tighten
   // by comparing a[mid] to mid -1 and mid + 1; 
      
   
   
  

}