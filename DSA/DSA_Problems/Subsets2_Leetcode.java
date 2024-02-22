class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        //so that duplicate elements are clubbed up
        Arrays.sort(nums);

        //to only have unique entries in this hashset
        HashSet<List<Integer>> set = new HashSet<>();

        //initialed the list that will contain all the subsets
        List<Integer> output = new ArrayList<>();

        //function that uses recursion to solve the ques
        solve(nums, 0, set, output);

        //answer arraylist that will contain all the subsets
        List<List<Integer>> ans = new ArrayList<>();

        //all the arraylists in the set are a subset which we add in the ans list
        for(List<Integer> list : set){
            ans.add(list);
        }

        return ans;

    }

    public void solve(int arr[], int si, HashSet<List<Integer>> set, List<Integer> output){

        //when we reach a leaf node
        //we have found a subset, which we add into the hashset
        if(si >= arr.length){
            List<Integer> op = new ArrayList<>(output);
            set.add(op);
            return;
        }

        //decision to not pick curr elem
        List<Integer> op1 = new ArrayList<>(output);
        solve(arr, si+1, set, op1);

        //decision to pick curr elem
        List<Integer> op2 = new ArrayList<>(output);
        op2.add(arr[si]);
        solve(arr, si+1, set, op2);

        return;
    }
}