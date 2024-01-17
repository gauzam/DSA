//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();

            Solution ob = new Solution();

            out.println(ob.reverseEqn(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{

    String reverseEqn(String S)
    {
        // your code here
        StringBuilder ans = new StringBuilder("");
        Stack<Character> stack = new Stack<>();

        //iterating over the string from right to left
        for(int i = S.length()-1; i >= 0; i--){
            char x = S.charAt(i);
            if(x == '+' || x == '-' || x == '*' || x == '/'){
                //when we encounter any sign char, we empty the stack and append the string
                while(!stack.isEmpty()){
                    ans.append(stack.pop());
                }

                //appending the sign character
                ans.append(x);
                continue;
            }

            //else we push the character in the stack
            stack.push(x);
        }

        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        return ans.toString();
    }
}