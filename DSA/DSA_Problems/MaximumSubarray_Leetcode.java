class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;

        for(int i = 0; i < nums.length; i++){
            runningSum = runningSum + nums[i];

            if(runningSum > maxSum){
                maxSum = runningSum;
            }

            //if running sum is negative, we drop the subarray
            //and reinitialize it to zero
            if(runningSum < 0){
                runningSum = 0;
            }
        }

        return maxSum;
    }
}