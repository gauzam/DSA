//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
            long[] res = new Solution().nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here

        long ans[] = new long[arr.length];

        //stack that will contain elements from the back
        Stack<Long> stack = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){
            if(i == arr.length-1){
                ans[i] = -1;
                stack.push(arr[i]);
                continue;
            }

            //if we find one elem in stack that is greater than curr elem, we stop
            while((!stack.isEmpty()) && stack.peek() <= arr[i]){
                stack.pop();
            }

            //if stack is exhausted means curr elem is largest elem till now
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            //else we found an elem that is larger than curr elem so we place it
            else{
                ans[i] = stack.peek();
            }

            //push curr elem in stack as it could be larger elem to upcoming elems
            stack.push(arr[i]);

        }

        return ans;
    }
}