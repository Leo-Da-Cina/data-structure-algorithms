
import java.util.*;
public class sortLearning{
   
   public static void main(String[] args){
      /*int[][] m = {{20,35,80,95},
                   {30,55,95,105},
                   {40,80,100,120}};
      
      /*print2DMatrix(m);      
      int target = 121;
      int[] id = findEInMatrix(m,target);
      System.out.println("Index of " + target + ":");
      System.out.println(" Row = " + id[0] + ", Col = " + id[1]); 
      */  
      
      
      for(int i = 1; i <= 30; i++){
         System.out.println(12 >> i);

      }
  }
   
     
   
   
    //from Introduction to Algorithm 
    //use two pointers, last element as pivot (modified version: randomly pick up one element and 
    //exchange it with last element). initially i = -1, j = 0, if a[j] <= pivot, j++,otherwise i++, and swap
    //a[i] and a[j]. At any particular time, a[0,..i] <= pivot, a[i+1,..j] > pivot, a[j+1,..n-1] not examined
    //exit condition: j == n-1
    //exit execution: swap a[i+1] with a[n-1]
    //pivot will be in the sorted position, recursively sort a[0,..i-1] and a[i+1,..n-1]
    public static void quickSort1(int[] a, int st, int ed){
      if(st < ed){
         int index = partition1(a,st,ed);//return position of sorted pivot
         quickSort1(a,st,index-1);
         quickSort1(a,index+1,ed);
      }
    }
    
    public static int partition1(int[] a, int st, int ed){
      int pivot = a[ed];
      int i = st - 1; //start from i = st - 1, not i = -1
      for(int j = st; j < ed; j++){
         if(a[j] <= pivot){
            swap(a,++i,j);
         }
      }
      swap(a,i+1,ed);
      return (i+1);
    }
    
    public static void swap(int[] a, int i, int j){
        int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
    }
    
    //from CAREERCUP 150 
    //left pointer i starts at 0, right pointer j at n-1, i and j move towards each
    //other, swap when a[i] >= pivot and a[j] <= pivot. exit when i > j, at the end 
    //i will point at first element that > pivot. recursively sort a[0,..i - 1] and a[i,n-1]
    //important boundaries are 1) while(i <= j), NOT (i < j) ;2) a[i] < pivot, NOT a[i] <= pivot; for example
    // a = {2,1} will not be sorted if (a[i] <= pivot, i++ )used. 3) st < ed NOT st <= ed 
    //this method will not put pivot value at the sorted position, it only split array into
    //two halves a[0..i-1] <= pivot, a[i,..n-1] > pivot.     
    public static void quickSort2(int[] a, int st, int ed){
        if(st >= ed) return;
//base case, if(st < ed) then do sth, if st==ed, only one element, no need to sort
        int mid =  st + (ed - st)/2;
        int pivot = a[mid];
        int i = st, j = ed;
        while(i <= j){
// i == j included
            if(a[i] < pivot){
 // if a[i] == pivot, left pointer i NOT increment
                i++;
            } else if(a[j] <= pivot){
                swap(a,i,j);
                i++;j--;
            } else {
                j--;
            }
        }
        //if(target >= i){
            quickSort2(a,i,ed);
        //} else {
            quickSort2(a,st,i - 1);
        //}
        
    }
    
    /*public static void quickSort3(int[] a, int st, int ed){
      if(st < ed){
         int index = partition3(a, st,ed);
         quickSort3(a,st,index - 1);
         quickSort3(a,index + 1, ed);
      }
    
    }*/
    
    //move pivot around, each time only move one pointer, FIX IT LATER
    /*public static int partition3(int[] a, int st, int ed){
      int i = st, p = st, j = ed;
      while(i < j){
         while(a[j] > a[p]){
            j--;
         }
         if(i < j){
            swap(a,p,j);
            p = j;
            while(a[i] <= a[p]){
               i++;
            }
            if(i < j){
               swap(a,p,i);
               p = i;
            }
            
         }   
         
      }
      return p;
    }
    */
   
   
   
   
   //find an element in a sorted matrix, operate binary search on each
   //column from the right to the left. 
   //pre: can't deal with duplicate elements
   public static int[] findEInMatrix(int[][] m, int e){
      int[] id = new int[2]; // id[0] = row id, id[1] = col id
      id[0] = -1; id[1] = -1;
      int col = m[0].length - 1, row = 0;
      while(row < m.length && col >=0){
         if(m[row][col] == e){
            id[0] = row; id[1] = col;
            return id;
         } else if(m[row][col] > e){
            col--;
         } else {
            row++;
         }
      }
            
      return id;
   }
   
   //print a 2-D matrix
   public static void print2DMatrix(int[][] m){
      int rowMax = m.length; int colMax = m[0].length;
      for(int i = 0; i < rowMax; i++){
         for(int j = 0; j < colMax; j++){
            System.out.print(m[i][j] + " ");
         }
         System.out.println();
      }
   
   }
   
   
   public static int findStrIndex(String[] a,String target,int st, int ed){
      while(st <= ed){
         int mid = st + ((ed - st)>>1);
         if("".equals(a[mid])){
            while(mid >= 0 && "".equals(a[mid])){
               mid--;
            }
         }
         
         if(target.compareTo(a[mid]) == 0){
            return mid;
         } else if(target.compareTo(a[mid]) > 0){
            st = mid + 1;               
         } else {
            ed = mid - 1;
         }
      }
      return -1;
   }
   
   public static int findE(int[] a, int target){
      int i = 0;
      while(i < a.length -1 && a[i+1] >= a[i]){
         i++;
      }
      System.out.println("The rotated index is " + (i+1));
      int index = binarySearch(a,target,0,i);
      if(index >= 0) {
         return index;
      } else {
         return binarySearch(a,target,i+1,a.length - 1);
      } 
   } 
   
   public static int binarySearch(int[] a, int target, int st, int ed){ 
      while(st <= ed){
         int mid = st + ((ed - st)>>1);
         if(target == a[mid]) {
            return mid;
         } else if(target > a[mid]) {
            st = mid + 1;
         } else {
         
            ed = mid - 1;
         }        
      }
      return -1;
   }
   
   public static void insertSort(int[] a){
      //start from second element, move backward
      //insert the ith element in the proper position
      //the first ith elements are sorted
      //if a.isEmpty() throw new illegalArgumentException;
      
      if (a.length > 1) {
         for(int i = 1; i < a.length; i++){
            int tmp = a[i];
            int p = i-1;
            //move all larger elements backwards
            
            while(p >= 0 && a[p] > tmp){
               a[p+1] = a[p];
               p--;
            }
            
            a[p+1] = tmp;
      
         }   
      }
   } 
   
   //merge sort
   public static void mergeSort(int[] a, int st, int ed){
      if(st < ed){
         int mid = st + ((ed - st)>>1);
         mergeSort(a, st, mid);
         mergeSort(a, mid + 1, ed);
         merge(a, st, mid, ed);
      }
      
   }
   
   //merge two sorted arrays into sorted one
   public static void merge(int[] a, int st, int mid, int ed){
      int[] b = new int[ed - st + 1];      
      int i = st, j = mid + 1, k = 0;
      while(i <= mid && j <= ed){
         if(a[i] <= a[j]){
            b[k++] = a[i++];
         } else {
            b[k++] = a[j++];
         }
      }      
      
      while(i <= mid){
         b[k++] = a[i++];
      }
      while(j <= ed){
         b[k++] = a[j++];
      }
      k = 0;
      for(i = st; i <= ed; i++){
         a[i] = b[k++];
      }
            
   }
   
     
      //in place sort a into two halves that are lower and larger than pivot
   //pre: array has at least three elements                
   private static int pivotSort(int[] a , int pivot){
      int n = a.length;
      //swap pivot with first element
      int tmp = a[pivot];
      a[pivot] = a[0];
      a[0] = tmp;
      //left pointer points at second element while right pointer points at last element
      //move pointers toward each other, swap if left pointed value is larger than pivot 
      //and right pointed value if smaller than pivot
      int iL = 1; int iR = n - 1;
      while(iL < iR) {
         if(a[iL] < a[0]) {
            iL++;
         }else if(a[iR] > a[0]){
            iR--;
         }else {
            //swap
            tmp = a[iL];
            a[iL] = a[iR];
            a[iR] = tmp;
         }
            
         
      }
      //swap pivot with iL th element
      if(a[0] > a[iL-1]) {
         tmp = a[0];
         a[0] = a[iL-1];
         a[iL-1] = tmp;
      } 
      return iL;
   }
   
   //update elements of array a using firstHalf and secondHalf
   //pre: length of first and second half == length of a
   private static void update(int[] a, int[] firstHalf, int[] secondHalf){
      int index = 0;
      int len1 = firstHalf.length;
      int len2 = secondHalf.length;
      //insert elements in firstHalf into a
      while(index < len1){
         a[index] = firstHalf[index];
         index++;
      }
      //insert elements in secondHalf into a
      while(index < (len1 + len2)){
         a[index] = secondHalf[index - len1];
         index++;
      
      }
     
   
   }
   
   //quick sort
    public static ListNode quickSortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        //pick up the pivot
        ListNode pivot = head;
        ListNode smaller = new ListNode(-1); ListNode smallerHead = smaller; 
        ListNode larger = new ListNode(-1); ListNode largerHead = larger;
        ListNode equal = new ListNode(-1); ListNode equalHead = equal;
        ListNode now = head;
        while(now != null){
            //add the smaller nodes to smaller list
            if(now.val < pivot.val){
                smaller.next = new ListNode(now.val);
                smaller = smaller.next;
            } else if(now.val > pivot.val){
                //add larger nodes to larger list
                larger.next = new ListNode(now.val);
                larger = larger.next;
            } else {
                //add same nodes in same list
                equal.next = new ListNode(now.val);
                equal = equal.next;
            } 
            now = now.next;
        }
        smaller.next = larger.next = equal.next = null;
        smallerHead = smallerHead.next;equalHead = equalHead.next;largerHead = largerHead.next;
        smallerHead = quickSortList(smallerHead);
        largerHead = quickSortList(largerHead);
        //glue together three pieces
        return concat(smallerHead, equalHead,largerHead);

    }
    
    //concatenate three sorted lists, smaller < equal < larger
    public static ListNode concat(ListNode small, ListNode equal, ListNode large){
        ListNode leftTail = getTail(small);
        ListNode midTail = getTail(equal);
        if(leftTail == null) {
            if(midTail == null){
                return large;
            }else {
                midTail.next = large;
                return equal;
            }
        } else {
            if(midTail == null){
                leftTail.next = large;
                return small;
            }else{
                midTail.next = large;
                leftTail.next = equal;
                return small;
            }
        }
        
    }
    
    //return the last node of a list
    public static ListNode getTail(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }
  
   
   
   
   
   

}