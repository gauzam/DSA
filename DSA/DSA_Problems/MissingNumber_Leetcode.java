class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int sum = 0;

        //calculating summation of elements of the array
        for(int i = 0; i < nums.length; i++){
            sum = sum+nums[i];
        }

        //sum of 'n' natural numbers
        int addition = (n*(n+1))/2;

        //we shall get the missing element by:
        return (addition - sum);
    }
}