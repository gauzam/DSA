class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //sorting the given array
        Arrays.sort(nums);

        //initializing answer list
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            //for unique "i"
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            //two pointer approac
            int j = i+1;
            int k = nums.length-1;

            while(j < k){

                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0){
                    j++;
                }
                else if (sum > 0){
                    k--;
                }
                else{

                    //sum is zero, means triplet is found

                    List<Integer> trip = new ArrayList<>();
                    trip.add(nums[i]);
                    trip.add(nums[j]);
                    trip.add(nums[k]);

                    ans.add(trip);

                    j++;
                    k--;

                    //so that j points to unique new element
                    while(j<k && nums[j] == nums[j-1]){
                        j++;
                    }

                    //so that k points to unique new element
                    while(j<k && nums[k] == nums[k+1]){
                        k--;
                    }
                }

            }


        }

        return ans;
    }
}