//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                    new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here

        StringBuilder ans = new StringBuilder("");

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('^',3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);
        map.put('(', 0);

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(c == '^' || c == '*' || c == '/' || c == '+' || c == '-'){
                if(stack.isEmpty()){
                    stack.push(c);
                    continue;
                }
                else{
                    char x = stack.peek();

                    if(map.get(c) > map.get(x)){
                        stack.push(c);
                    }
                    else{
                        while(!stack.isEmpty() && map.get(c) <= map.get(stack.peek())){
                            ans.append(stack.pop());
                        }

                        stack.push(c);

                    }
                }


            }
            else if (c == '('){
                stack.push(c);
            }

            else if (c == ')'){

                while(!stack.isEmpty()){
                    if(stack.peek() == '('){
                        break;
                    }
                    ans.append(stack.pop());
                }
                stack.pop();
            }

            else{
                ans.append(c);
            }
        }

        while(!stack.isEmpty() ){
            ans.append(stack.pop());
        }

        return ans.toString();
    }
}