//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            String st = sc.next();

            char ans=new Solution().nonrepeatingCharacter(st);

            if(ans!='$')
                System.out.println(ans);
            else
                System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String s)
    {

        HashMap<Character, Integer> map = new HashMap<>();

        //first scan to store all the chars of the string with their frequency
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //second scan to find the first char that isn't a repeating char
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) == 1){
                return c;
            }
        }

        return '$';
    }
}

