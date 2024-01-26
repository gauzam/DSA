class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int subarrays = 0;

        //window start index
        int i = 0;
        //window end index
        int j = 0;

        //current product of window
        int product = 1;

        while(j < nums.length){

            product = product * nums[j];

            //while start index is <= end index and the product is >= to k
            while(i <= j && product >= k){
                product = product/nums[i];
                i++;
            }

            if(product < k){
                //found a subarray that has product < k
                //add all its subarrays
                subarrays = subarrays + (j-i+1);
            }

            j++;
        }

        return subarrays;
    }
}