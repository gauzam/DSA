class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        //if first element is the single element
        if(nums[0] != nums[1]){
            return nums[0];
        }

        //if last element is the single element
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }

        //trimmed search space as edge cases are handled before hand
        int start = 1;
        int end = nums.length - 2;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                //elem at mid is the single element
                return nums[mid];
            }

            if((mid%2 == 0 && nums[mid] == nums[mid+1]) || (mid%2 == 1 && nums[mid] == nums[mid-1])){
                //mid is on the left half
                //single element is on the right half 
                start = mid + 1;
            }
            else{
                //mid is on the right half
                //single element is on the left half
                end = mid - 1;
            }
        }

        return -1;
    }
}