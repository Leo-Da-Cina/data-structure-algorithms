public class NumArray {
    private int[] accSum;
    public NumArray(int[] nums) {
        accSum = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            accSum[i+1] = accSum[i] + nums[i];
        }
        
    }    public static void main(String[] args){
      int[] nums = {-2,1,3,4,5};
      NumArray numArray = new NumArray(nums);
      System.out.println(numArray.sumRange(1,2));
    }   


    public int sumRange(int i, int j) {
        return accSum[j+1] - accSum[i];
    }
}