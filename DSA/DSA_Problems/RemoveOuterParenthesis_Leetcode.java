class Solution {
    public String removeOuterParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        StringBuilder ans = new StringBuilder("");

        for(int i = 0; i < s.length(); i++){

            //whenever the opening bracket is outermost, stack will be empty
            //and we wont add the bracket to the answer string
            if(s.charAt(i) == '('){
                if(stack.size() != 0){
                    ans.append(s.charAt(i));
                }
                stack.push(s.charAt(i));
            }
            else{
                stack.pop();

                //if stack was empty, means it was a closing bracket of outermost pair
                //so we wont add the bracket to the answer string
                if(stack.size() != 0){
                    ans.append(s.charAt(i));
                }
            }
        }


        return ans.toString();

    }
}