//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static boolean isPrime(int n){

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }

        return true;
    }

    static long largestPrimeFactor(int n) {
        // code here

        if(n<=3){
            return n;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.add(1);

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                pq.add(i);
                if(i == Math.sqrt(n)){
                    break;
                }

                //adding both the factors in the pq
                pq.add(n/i);
            }
        }

        //adding the number itself as it is its own factor
        pq.add(n);

        while(!pq.isEmpty()){

            //removing largest factors one by one
            int num = pq.remove();
            boolean ans = isPrime(num);

            //the factor which is also prime is returned
            if(ans){
                return num;
            }
        }

        return n;

    }
}