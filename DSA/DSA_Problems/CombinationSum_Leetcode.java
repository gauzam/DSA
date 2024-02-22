class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> output = new ArrayList<>();

        solve(candidates, target, ans, output, 0);

        return ans;

    }

    public void solve(int arr[], int target, List<List<Integer>> ans, List<Integer> output, int si){

        if(si >= arr.length){
            if(target == 0){
                List<Integer> op = new ArrayList<>(output);
                ans.add(output);
            }
            return;
        }
        if(target == 0){
            List<Integer> op = new ArrayList<>(output);
            ans.add(output);
            return;
        }
        if(target < 0){
            return;
        }

        //picked the current elem
        List<Integer> op1 = new ArrayList<>(output);
        op1.add(arr[si]);
        //we dont move the si forward, as si can be picked again
        solve(arr, target-arr[si], ans, op1, si);

        //do not pick the current elem
        List<Integer> op2 = new ArrayList<>(output);
        //now we move the si forward as we have decided to not pick it
        solve(arr, target, ans, op2, si+1);

        return;
    }
}