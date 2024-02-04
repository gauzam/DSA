class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if(n==1){
            return 0;
        }

        //returning first elem if it is the peak
        if(nums[0]>nums[1]){
            return 0;
        }

        //returning last elem if it is the peak
        if(nums[n-1]>nums[n-2]){
            return n-1;
        }

        //search space shrinked so that we can write cleaner code
        int start = 1;
        int end = n-2;

        while(start <= end){
            int mid = (start+end)/2;

            //if mid is peak, return mid
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }

            //if mid is on an increasing slope, eliminate left half
            if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
                start = mid+1;
            }

            //if mid is on decreasing slope or mid is a trough, eliminate right half
            else {
                end = mid-1;
            }

        }

        //dummy return statement
        return -1;

    }
}