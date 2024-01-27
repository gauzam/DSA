class Solution {
    public int subarraySum(int[] nums, int k) {

        //hashmap that stores the sum, and its number of occurences
        HashMap<Integer, Integer> map = new HashMap<>();

        //contigous sum of elements of the array
        int sum  = 0;
        //no. of subarrays that sum to k
        int subarrays = 0;

        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];

            //if contigous sum equals k, we've found a subarray
            if(sum == k){
                subarrays++;
            }

            //if map contains 'sum - k', means a subarray with sum=k would also exist
            if(map.containsKey(sum - k)){
                //no. of times sum-k exists is how many subarrays we've found
                int freq = map.get(sum - k);
                subarrays = subarrays + freq;
            }

            //putting the frequency of current sum in the hashmap
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return subarrays;
    }
}