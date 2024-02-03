class Solution {
    public boolean search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                return true;
            }

            //if all pointers same to duplicate elements, we shrink the search space down
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }

            if(nums[start] <= nums[mid]){
                //left half is sorted

                //target belongs to the left half
                if(target >= nums[start] && target <= nums[mid]){
                    end = mid - 1;
                }
                //target belongs to the right half
                else{
                    start = mid + 1;
                }
            }
            else {
                //right half is sorted

                //target is in the right half
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }
                //target belongs to the left half
                else{
                    end = mid - 1;
                }
            }

        }


        return false;
    }
}