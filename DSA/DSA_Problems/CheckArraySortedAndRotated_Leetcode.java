class Solution {
    public boolean check(int[] nums) {

        //no. of pairs that break the flow
        int pairs = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                pairs++;
            }
        }

        //cyclic comparison, last element with the first
        if(nums[nums.length-1] > nums[0]){
            pairs++;
        }

        //only one pair is allowed to break the flow coz of array rotation
        if(pairs <= 1){
            return true;
        }
        else{
            return false;
        }
    }
}