class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        //sliding window approach
        int numsubarrays = 0;

        int left = 0;
        int right = 0;

        int windowProduct = nums[0];

        while(left <= right && right < nums.length){

            if(windowProduct >= k){
                windowProduct = windowProduct/nums[left];
                left++;
            }

            if(windowProduct < k){
                numsubarrays = numsubarrays + (right - left + 1);
                right++;
                if(right < nums.length){
                    windowProduct = windowProduct * nums[right];
                }
            }

        }


        return numsubarrays;
    }
}