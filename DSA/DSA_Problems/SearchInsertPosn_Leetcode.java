class Solution {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        //default answer if target is larger than largest elem of array
        int ans = nums.length;

        while(start <= end){
            int mid = (start+end)/2;

            if(nums[mid] >= target){
                //we update ans with a smaller index
                ans = mid;
                //and move towards the left half
                end = mid - 1;
            }
            else {
                //lower bound is in the right half
                start = mid + 1;
            }
        }

        //lower bound index
        return ans;

    }
}