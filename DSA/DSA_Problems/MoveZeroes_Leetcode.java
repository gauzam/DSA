class Solution {
    public void moveZeroes(int[] nums) {

        //index where next non-zero element goes
        int nnz = 0;

        for(int i = 0; i<nums.length; i++){

            //if we find a non-zero element
            //we swap it with element at i and increment nnz
            if(nums[i] != 0){
                int temp = nums[nnz];
                nums[nnz] = nums[i];
                nums[i] = temp;
                nnz++;
            }

        }

        return;
    }
}