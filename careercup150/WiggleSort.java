import java.util.*;
public class WiggleSort{
   public static void main(String[] args){
      //int[] nums = {5,4,5,6,7};
      //System.out.println(Arrays.toString(nums));
      //wiggleSort(nums);
      //System.out.println(Arrays.toString(nums));
      for(int i = 0 ; i < 6; i++){
         System.out.println((i | 1));
         //System.out.println(newIndex(i,6));
      }
      
   }
   private static int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

   public static void wiggleSort(int[] nums) {
                
       if(nums == null || nums.length <= 1) return;
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        //find median index
        int p = ((nums.length)>>1);
        int i = p - 1, k = 0;
        //copy the smaller ones to the even index 0,2,4,...
        while(i >= 0 ){
            result[k] = nums[i--];
            k += 2;
        }    
        //copy the >= ones to the odd index;
        k = 1; i = nums.length - 1;
        while(i > p && k < nums.length){
            result[k] = nums[i--];
            k += 2;
        }
       
            result[nums.length - 1] = nums[p];
        
        
        for(i = 0; i < nums.length; i++){
            nums[i] = result[i];
        }        
    }
}