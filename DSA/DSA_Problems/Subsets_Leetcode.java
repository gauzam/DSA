class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        //ans arraylist that stores arraylists of integers
        List<List<Integer>> ans = new ArrayList<>();

        //initial subset arraylist
        List<Integer> output = new ArrayList<>();

        //method that will solve the ques
        solve(nums, 0, ans, output);

        return ans;
    }

    public void solve(int arr[], int si, List<List<Integer>> ans, List<Integer> output){

        //if we reach the leaf node, whatever is the output subset,
        //we add it into the ans arraylist
        //we create a new copy of the output to add into the ans
        if(si >= arr.length){
            List<Integer> op = new ArrayList<>(output);
            ans.add(op);
            return;
        }

        //we create a copy of the output subset and 
        //dont add the elem at startindex
        List<Integer> op1 = new ArrayList<>(output);
        //and ask recursion to to solve without choosing this elem
        solve(arr, si+1, ans, op1);

        //we create a copy of the output subset and 
        //we add the elem at startindex
        List<Integer> op2 = new ArrayList<>(output);
        op2.add(arr[si]);
        //and ask recursion to to solve when we choose this elem
        solve(arr, si+1, ans, op2);

        return;
    }
}