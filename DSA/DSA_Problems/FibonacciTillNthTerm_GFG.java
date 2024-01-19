//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans[] = obj.Series(n);
            for (long i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    long[] Series(int n) {
        //basecase1
        if (n == 0){
            long ans[] = new long[1];
            return ans;
        }
        //basecase2
        if(n == 1){
            long ans[] = new long[2];
            ans[1] = 1;
            return ans;
        }

        //recursion to bring us smaller ans
        long smallans[] = Series(n-1);

        long Ans[] = new long[smallans.length + 1];

        for(int i = 0; i<smallans.length; i++){
            Ans[i] = smallans[i];
        }
        int j = Ans.length-1;
        Ans[j] = Ans[j-1] + Ans[j-2];

        return Ans;

    }
}