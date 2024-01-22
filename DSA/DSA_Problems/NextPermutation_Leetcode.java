class Solution {

    public void reverse(int arr[], int si, int ei){

        //method to reverse the array in given bounds
        while(si<ei){
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }

        return;
    }

    public void nextPermutation(int[] nums) {

        if(nums.length <= 1){
            return;
        }

        int n = nums.length;

        //breakpoint index
        int bpindex = -1;

        for(int i = n-2; i >= 0; i--){

            //breakpoint is when element at i is smaller then element at i+1
            if(nums[i+1] > nums[i]){
                bpindex = i;
                break;
            }
        }

        //if no breakpoint index found, means array is sorted in descending order
        if(bpindex == -1){

            //we just reverse the array for default smallest permutation and return
            reverse(nums, 0, n-1);
            return;
        }

        //we have to realise that the array on the right of breakpoint is
        //a descending sorted array

        for(int i = n-1; i>=0; i--){
            //we find the element that is just larger than elem at breakpoint
            if(nums[i] > nums[bpindex]){

                //and swap it with elem at break point
                int temp = nums[bpindex];
                nums[bpindex] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        //even after swapping, array on the right is sorted in descending order,
        //which can be sorted by a simple reverse of the array
        reverse(nums, bpindex+1, n-1);
        return;

    }
}