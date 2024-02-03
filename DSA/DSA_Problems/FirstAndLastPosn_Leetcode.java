class Solution {
    public int[] searchRange(int[] nums, int target) {

        //initialising answer array
        int ans[] = new int[2];

        int start = 0;
        int end = nums.length - 1;

        //indexes for first and last occurence
        int first = -1;
        int last = -1;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                //we store the occurence index
                first = mid;
                //and continue search on the left half for the first occurence
                end = mid - 1;
            }
            else if (target < nums[mid]){
                end = mid - 1;
            }
            else if(target > nums[mid]){
                start = mid + 1;
            }
        }

        start = 0;
        end = nums.length - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                //we store the occurence index
                last = mid;
                //and continue search on the right half for the last occurence
                start = mid + 1;
            }
            else if (target < nums[mid]){
                end = mid - 1;
            }
            else if(target > nums[mid]){
                start = mid + 1;
            }

        }

        ans[0] = first;
        ans[1] = last;
        return ans;

    }
}