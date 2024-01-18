class Solution {

    public void reverse(int arr[], int si, int ei){

        //si is startindex, ei is endindex
        while(si<ei){
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }

        return;
    }


    public void rotate(int[] nums, int k) {

        //if k = size, rotated array is same as original array
        if(k > nums.length){
            k = k%nums.length;
        }

        //reverse entire array
        reverse(nums, 0, nums.length-1);

        //reverse first k elements
        reverse(nums, 0, k-1);

        //reverse last n-k elements
        reverse(nums, k, nums.length-1);

        return;
    }
}