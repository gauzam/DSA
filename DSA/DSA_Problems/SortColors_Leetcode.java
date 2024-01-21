class Solution {
    public void sortColors(int[] nums) {

        //index where the next zero will be placed
        int nz = 0;

        //index where the next two will be placed
        int nt = nums.length-1;

        //iterator
        int i = 0;

        while(i<=nt){
            if(nums[i] == 0){
                int temp = nums[nz];
                nums[nz] = nums[i];
                nums[i] = temp;
                nz++;
                i++;
            }
            else if(nums[i] == 2){
                int temp = nums[nt];
                nums[nt] = nums[i];
                nums[i] = temp;
                nt--;
            }
            else{
                i++;
            }
        }

        return;
    }
}