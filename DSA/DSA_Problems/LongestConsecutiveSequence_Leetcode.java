class Solution {
    public int longestConsecutive(int[] nums) {

        //initializing a hashset to store unique elements
        HashSet<Integer> set = new HashSet<>();

        //storing each element in the hashset
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int longest = 0;
        int streak = 1;

        for(Integer temp : set){

            int prev = temp - 1;

            //if current element is the starting element of a sequence
            if(!set.contains(prev)){

                streak = 1;

                //till it contains consecutive elements
                while(set.contains(temp+1)){
                    streak++;
                    temp++;
                }

                //update longest sequence length
                longest = Math.max(streak, longest);

            }

        }

        return longest;
    }
}