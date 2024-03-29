class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }

            if(c == ')'){
                if(!stack.isEmpty() && stack.pop() == '('){
                    continue;
                }
                else{
                    return false;
                }
            }

            if(c == '}'){
                if(!stack.isEmpty() && stack.pop() == '{'){
                    continue;
                }
                else{
                    return false;
                }
            }

            if(c == ']'){
                if(!stack.isEmpty() && stack.pop() == '['){
                    continue;
                }
                else{
                    return false;
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }
}