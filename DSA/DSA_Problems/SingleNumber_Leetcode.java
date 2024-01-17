class Solution {
    public int singleNumber(int[] nums) {

        //best approach to solve this question is using XOR

        int ans = 0;

        for(int i = 0; i<nums.length; i++){
            //xor each element of the array
            ans = ans^nums[i];
        }

        //contains the unique element
        return ans;

    }
}