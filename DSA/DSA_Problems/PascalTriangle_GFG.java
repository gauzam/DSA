//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {

        //given
        long mod = 1000000007;

        //basecase1
        if(n == 1){
            ArrayList<Long> ans = new ArrayList<>();
            ans.add((long)1);
            return ans;
        }

        //basecase2
        if(n == 2){
            ArrayList<Long> ans = new ArrayList<>();
            ans.add((long)1);
            ans.add((long)1);
            return ans;
        }

        //recursion brings us the previous row
        ArrayList<Long> smallAns = nthRowOfPascalTriangle(n-1);

        ArrayList<Long> Ans = new ArrayList<>();
        Ans.add((long)1);
        for(int i = 0; i<smallAns.size()-1; i++){
            long sum = smallAns.get(i) + smallAns.get(i+1);
            sum = sum%mod;
            Ans.add(sum);
        }
        Ans.add((long)1);

        return Ans;
    }
}