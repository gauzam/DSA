//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {

        //stack to store all the people at the party
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            stack.push(i);
        }

        while(stack.size() >= 2){

            //method of elimination between two people
            int a = stack.pop();
            int b = stack.pop();

            if(M[a][b] == 1){
                //a is definitely not a celebrity coz a knows b
                stack.push(b);
                continue;
            }
            if(M[a][b] == 0){
                //b is definitely not a celebrity coz a does not know b
                stack.push(a);
                continue;
            }

        }

        //stack only has 1 person
        int potentialCeleb = stack.pop();

        //verifying its celebrity status

        //its entire row should be all zeroes
        for(int j = 0; j < n; j++){
            if(M[potentialCeleb][j] != 0){
                return -1;
            }
        }

        int oneCount = 0;

        //its entire column should be all ones except for its own index
        for(int i = 0; i<n; i++){
            if(M[i][potentialCeleb] == 1){
                oneCount++;
            }
        }

        if(oneCount != n-1){
            return -1;
        }

        return potentialCeleb;

    }
}