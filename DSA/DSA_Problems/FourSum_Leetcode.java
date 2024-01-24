class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        //sorting the array
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            //to avoid duplicates
            if(i != 0){
                if(nums[i] == nums[i-1]){
                    continue;
                }
            }
            for(int j = i+1; j < nums.length; j++){
                //to avoid duplicates
                if(j != i+1){
                    if(nums[j] == nums[j-1]){
                        continue;
                    }
                }

                //initialising two variables for two pointer approach
                int k = j+1;
                int l = nums.length - 1;

                while (k<l){
                    long sum = nums[i] + nums[j] ;
                    sum = sum + nums[k] + nums[l];

                    if(sum == target){

                        //quad is found
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add(nums[l]);

                        ans.add(quad);

                        k++;
                        l--;

                        //for unique element at k
                        while(k < l && nums[k] == nums[k-1]){
                            k++;
                        }
                        //for unique element at l
                        while(k < l && nums[l] == nums[l+1]){
                            l--;
                        }
                    }

                    else if(sum < target){
                        k++;
                    }
                    else{
                        l--;
                    }

                }
            }
        }

        return ans;

    }
}