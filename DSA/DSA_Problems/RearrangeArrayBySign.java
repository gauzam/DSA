class Solution {
    public int[] rearrangeArray(int[] nums) {

        //new array to store answer
        int ans[] = new int[nums.length];

        //index where next positive element goes
        int np = 0;
        //index where next negative element goes
        int nn = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                ans[np] = nums[i];
                np = np+2;
            }
            else{
                ans[nn] = nums[i];
                nn = nn+2;
            }

        }

        return ans;

    }
}