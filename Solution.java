import java.util.*;

public class Solution {
    public static void main(String[] args){
      //int[] nums = {1,1,0,0};
      //int major = majorityElement(nums);
      //System.out.println(major);
      //for(int i = 0; i < 17; i++) {
         //System.out.print("Square root of " + i + "is :");
         //System.out.print(mySqrt(i));
        // climbStairs(35);
      //}
      ListNode l1 = new ListNode(0);
      ListNode l2 = new ListNode(1);
      l2.next = l1;
      ListNode now = l2;now = now.next;
      now = null;
      System.out.println("fuck you");
      ListNode sum = addTwoNumbers(l1,l2);
      
      
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode sum = new ListNode(0);
        ListNode now3 = sum;
        ListNode now1 = l1; ListNode now2 = l2;
        int oldCarry = 0; int carry = 0;
        while(now1 != null && now2 != null){
            
            int tmp = now1.val + now2.val + oldCarry;
            if(tmp > 10){
                carry = 1;
                tmp /= 10;
            }
            
            now3.val = tmp;
            now3.next = new ListNode(0);
            now3 = now3.next;
            now1 = now1.next;
            now2 = now2.next;
            oldCarry =  carry;
        }
        now3 = null;
        if(now1 != null){
            now3.next = now1;
            now3.next.val += oldCarry;
            now3.val = now3.next.val;
            now3.next = now3.next.next;
        } else if(now2 != null){
            now3.next = now2;
            now3.next.val += oldCarry;
            now3.val = now3.next.val;
            now3.next = now3.next.next;
        } else {
            now3 = null;
        }
        
        return sum;
        
    }
    
     public static long climbStairs(int n) {
        if(n <= 1) return n;
        long ways = 0; int twos = 0;
        
        while(twos*2 <= n) {
            long way = combination(twos,n);
            System.out.println(twos + " 2s :" + way);
            ways += way;
            twos++;
        }
        
        return ways;
    }
    
    //return combination of 2s and 1s that sum up to n
    //pre: twos >= 0 && twos * 2 <=n, twos is number of 2s
    private static long combination(int twos, int n){
        int ones = n - 2*twos;//number of 1s
        return (factorial((ones + twos)) / (factorial(ones)*factorial(twos)));
    }
    
    private static long factorial(int n){
        if(n <= 1) return 1;
        long result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }
    
    
    
    public static int mySqrt(int x) {
        if(x <= 1) return x;
        int start = 1; int end = x;
        int mid = mid = start + ((end - start)>>1);
        while(start <= end){
            
            if(mid * mid == x){
               return mid;
            }else if(mid * mid > x){
               end = mid - 1;
            }else{
               start = mid + 1;
            }   
            mid = start + ((end - start)>>1);
        }    
        
        return mid;    
    }    
        
        
        
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> elementOccurrence = new TreeMap<Integer,Integer>();
        //build a map with keys the same as elements of nums, and values for the 
        //occurrence of that element
        for(int i : nums) {
            if(!elementOccurrence.containsKey(i)) {
                elementOccurrence.put(i,1);
            } else {
                int occurrence = elementOccurrence.get(i);
                elementOccurrence.put(i,occurrence + 1);
            }
        }
        System.out.println(elementOccurrence);
        // traverse the map to find the majority element
        int occurrence = 0; int major = 0;
        for(int i : elementOccurrence.keySet()) {
            if (elementOccurrence.get(i) > occurrence) {
                major = i;
                occurrence = elementOccurrence.get(i);
            }
            
        }
        
        return major;
        
    }
    
    
    
}