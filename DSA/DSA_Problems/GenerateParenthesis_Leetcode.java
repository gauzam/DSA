class Solution {
    public List<String> generateParenthesis(int n) {

        int open = n;
        int close = n;
        List<String> ans = new ArrayList<>();
        String output = "";
        solve(open, close, output, ans);

        return ans;

    }

    public void solve(int open, int close, String output, List<String> ans){

        //when both are exhausted, we add the output string to the ans arraylist
        if(open == 0 && close == 0){
            ans.add(output);
            return;
        }

        //till we have opening brackets left, we'll keep on calling this fxn
        if(open != 0){
            String op1 = output + "(";
            solve(open-1, close, op1, ans);
        }

        //when closing brackets are greater than opening, we must use closing for balance
        if(close > open){
            String op2 = output + ")";
            solve(open, close-1, op2, ans);
        }
        return;
    }
}