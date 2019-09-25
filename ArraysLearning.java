

import java.util.*;
import java.lang.*;

public class ArraysLearning {
    public static void main(String[] args) {
        //int[] nums1 = {3}; int[] nums2 = {1,2};
        //double twoArrMedian = findMedian(nums1, nums2, nums1.length,nums2.length);
        //System.out.println(twoArrMedian);
        /*String s = "a.b.c";
        s = s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "");
        //System.out.println(s);
        //System.out.println(isPalindrome(s));
        int[] nums = {1,2,3};
        permutation("", Arrays.toString(nums));
        */
        
        int[] a1 = {3};
        int[] a2 = {1,2};
        System.out.println(findMedianSortedArrays(a1, a2));
        /*System.out.println("The peak element is : " + res[0]);
        System.out.println("The index is : " + res[1]);
        System.out.println(Long.MIN_VALUE);
        
        String s = " little   adg a abc";
        
        String rev = reverseWords(s);
        System.out.println(rev);
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>(2);
        map.put(1,3);
        map.put(2,4);
        map.put(3,5);
        Set<Integer> keys = map.keySet();
        keys.remove(3);
        System.out.println(map.keySet());
        System.out.println(map.size());
        System.out.println(map.get(3));*/
        
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0) return median(nums2);
        if(nums2.length == 0) return median(nums1);
        int m = nums1.length, n = nums2.length;
        if(m <= n){
            return findMedian(nums1,nums2);
        } else {
            return findMedian(nums2,nums1);
        }
        
    }
    //pre: a is sorted
    public static double median(int[] a){
        if(a.length == 0) return 0.0;
        int n = a.length;
        if(n % 2 == 0){
            return ((double)a[n/2] + (double)a[n/2 - 1])/2.0;
        } else {
            return (double) a[n/2];
        }
    }
    //pre: length of nums1 is <= length of nums2
    public static double findMedian(int[] a, int[] b){
        int m = a.length, n = b.length;
        int st = 0 , ed = m;
        double leftMax = 0, rightMin = 0;
        while(st <= ed){
            int i = st + ((ed -st)>>1), j = (m + n)/2 - i;
            if(i < m && a[i] < b[j-1]){ // include i = 0 and without comparison and searching case 
                st = i+1;
            } else if(i > 0 && b[j] < a[i-1]){
                ed = i-1;
            } else {
                if(i == 0){ // after search and compare , i = 0 means the entire a belongs to right half here. 
                    if(j < n){
                        leftMax =(double) b[j-1]; rightMin = (double) Math.min(a[0],b[j]);
                    } else { // j = m
                        leftMax =(double) b[j-1]; rightMin = (double) a[0];
                    }
                    
                } else if(i == m){
                    if(j > 0){
                        leftMax = (double) Math.max(a[m-1],b[j-1]); rightMin = (double) b[j];
                    } else { // j = 0 case, that 's due to a.length = b.length or b.length + 1
                        leftMax = (double) a[m-1]; rightMin = (double) b[j];
                    }
                    
                } else {
                    leftMax = (double) Math.max(a[i-1],b[j-1]); rightMin = (double) Math.min(a[i],b[j]);
                }
                return (m + n) % 2 == 0 ? (leftMax + rightMin)/2.0:rightMin;
                
            }
            
        }
        
        return (m + n) % 2 == 0 ? (leftMax + rightMin)/2.0:rightMin;
  
    }
    
    
    
    
    
    
    public static String reverseWords(String s) {
        if(s == null) return s;
        s.trim();
        int n = s.length();
        if(n <= 1) return s;
        int i = 0,j = 0;
        String rev = "";
        while(i < n){
            while(i < n && s.charAt(i) != ' '){
                i++;
            }
            rev = " " + s.substring(j,i) + rev;
            while(i < n && s.charAt(i) == ' '){
                i++;
            }
            j = i;
            
        }
        
        return rev.substring(0);
        
    }
    
    

    
    
    
    
    
    //find an element that's greater than all elements to its left and right
    public static int[] findPeak(int[] a){
         if(a == null || a.length < 1) return new int[0];
         int[] res = new int[2];
         res[0] = Integer.MIN_VALUE;
         for(int i = 0; i< a.length;i++){
            if(a[i] > res[0]){
               res[0] = a[i];
               res[1] = i;
             }
         }
         return res;
    }
    
    
    
    
    
    
    
    
    //find mininum difference btw elements from two different arrays with different size
    //variation of this problem: find a1[i] + a2[j] closest to x. The common idea is
    //first sorting the arrays, secondly use two pointers. The difference is where to start
    //the two pointers. for the sum problem, one pointer starts at the minimum of one array, 
    //the other pointer starts at the max of another array. 
    //These two problems are different from 2-sum which is searching on single array rather than
    // two arrays.     
    public static int findMinDiff(int[] a1, int[] a2){
      int n1 = a1.length; int n2 = a2.length;
      if(n1 == 0 || n2 == 0) return -1;
      Arrays.sort(a1); Arrays.sort(a2);
      if(a1[0] >= a2[n2 - 1]) return a1[0] - a2[n2 - 1];
      if(a1[n1 - 1] <= a2[0]) return a2[0] - a1[n1 - 1];
      int p1 = 0, p2 = 0;
      int diff = Math.abs(a1[p1] - a2[p2]);
      while(p1 < n1 && p2 < n2){
         if(a1[p1] == a2[p2]) return 0;
         if(a1[p1] > a2[p2]){
            diff = Math.min(a1[p1] - a2[p2],diff);
            p2++;
         }else {
            diff = Math.min(a2[p2] - a1[p1],diff);
            p1++;

         }      
      }
      return diff;
    }
    
    
        
    
    public static void permutation(String prefix,String s){
      
      int n = s.length();
      if(n == 0) System.out.println(prefix);
      
      //there are n! , start from first one , then second one, and so on
      for(int i = 0; i < n ; i++){
         permutation(prefix + s.charAt(i),s.substring(0,i)+s.substring(i+1,n));
      }
    
    }
    
    
    public static boolean isPalindrome(String s) {
        return isPal(s);
    }
    
    private static boolean isPal(String s){
        if(s.length() <= 1){
            return true;
        } else {
            s = s.toLowerCase();
            return (s.charAt(0) == s.charAt(s.length() - 1) && isPal(s.substring(1,s.length()-1)));
        }
    }
    
    
        
    
}