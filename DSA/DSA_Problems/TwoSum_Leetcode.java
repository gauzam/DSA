import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        //initialising a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){

            //if map contains current element's complement
            if(map.containsKey(target-nums[i])){

                //we create answer array and return
                int ans[] = {i, map.get(target-nums[i])};
                return ans;
            }

            //else we put current key-value pair in the hashmap
            map.put(nums[i], i);
        }

        //will reach here if the pair sum doesn't exist
        int ans[] = {};
        return ans;

    }
}