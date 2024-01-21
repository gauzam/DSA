class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        //traversing over the array to build a frequency hashmap
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //one element in the hashmap has to occur more than n times:
        int n = nums.length/2;

        //traversing over the key set of the hashmap
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > n){
                return entry.getKey();
            }
        }

        return 0;
    }
}