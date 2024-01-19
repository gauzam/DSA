//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while(testcases-- > 0){
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr [] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for(int i = 0;i<sizeOfArray;i++){
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{


    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int k) {

        //hashmap that will contain summations till each index
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;

        for(int i = 0; i < n; i++){
            //sum till index i
            sum = sum + arr[i];

            //if subarray from 0 to i sums to k
            if(sum == k){
                if(i+1 > maxlen){
                    maxlen = i+1;
                }
            }

            //to find subarray that sums to k in between 0 and i
            if(map.containsKey(sum-k)){
                int index = map.get(sum-k);

                if(i-index > maxlen){
                    maxlen = i-index;
                }

            }

            //we do not update map if sum already exists - for longest subarray
            if(map.containsKey(sum)){
                continue;
            }

            map.put(sum, i);
        }

        return maxlen;

    }


}