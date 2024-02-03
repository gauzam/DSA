class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[start] <= nums[mid]){
                //left half is sorted

                //target belongs to the left half
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid - 1;
                }

                //target belongs to the unsorted right half
                else{
                    start = mid + 1;
                }
            }

            else{
                //right half is sorted

                //target belongs to the right half
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }
                //target belongs to the unsorted left half
                else{
                    end = mid - 1;
                }
            }
        }

        //target not found and the search space is exhausted
        return -1;

    }
}