//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();

            Solution g = new Solution();
            int n = g.remove_duplicate(a,N);

            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int remove_duplicate(int arr[],int n){
        // code here

        //checks where the next distinct will go
        int nextdistinct = 0;

        for(int i = 1; i < n; i++){

            if(arr[i] == arr[nextdistinct]){
                continue;
            }
            else{
                //means a distinct elem
                nextdistinct++;
                arr[nextdistinct] = arr[i];
            }

        }

        //no of elems will be where last distinct elem is + 1
        return nextdistinct + 1;


    }
}