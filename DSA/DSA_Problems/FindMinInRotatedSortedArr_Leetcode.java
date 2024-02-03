class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        int min = Integer.MAX_VALUE;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] < min){
                min = nums[mid];
            }

            if(nums[start] <= nums[mid]){
                //left half is sorted
                //we just check with its smallest element
                min = Math.min(min, nums[start]);

                //in unsorted half we continue our search
                start = mid+1;
            }

            else{
                //right half is sorted

                //right half's min is mid only

                //we can eliminate right half
                end = mid - 1;
            }
        }

        return min;
    }
}