//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        int sign = 1;
        if(s1.charAt(0) == '-' && s2.charAt(0) != '-'){
            sign = -1;
            s1=s1.substring(1);
        }
        else if (s1.charAt(0) != '-' && s2.charAt(0) == '-'){
            sign = -1;
            s2=s2.substring(1);
        }
        else if(s1.charAt(0) == '-' && s2.charAt(0) == '-'){
            s1=s1.substring(1);
            s2=s2.substring(1);
        }

        int n = s1.length();
        int m = s2.length();

        int carry = 0;

        //declaring variables to be used
        int shift, n1, n2, k, pro, sum, i;

        //array containing result of product
        int res[] = new int[n+m];

        StringBuilder a = new StringBuilder();

        //array storing product of each level
        int product[] = new int[n+m];

        //iterating over the 2nd string from right to left
        for(int j = m - 1; j >= 0; j--){

            //shift is 0 for 1st level, 1 for 2nd level and so on...
            shift = m - 1 - j;

            //for every digit in string2, carry starts with value = 0
            carry = 0;

            //clearing the product array to all zero values
            for(i = 0; i < n+m; i++){
                product[i] = 0;
            }

            //extract the digit out from the string2 in n1
            n1 = s2.charAt(j) - '0';

            //now n1 needs to be multiplied with every digit in string1
            //"i" iterates over string1 from right to left
            //"k" keeps track of product array from right to left
            for(i = n - 1, k = n+m-1-shift; i>=0; i--, k--){

                //extract the digit out from string1 in n2
                n2 = s1.charAt(i) - '0';

                //storing product in pro
                pro = n1*n2 + carry;

                if(pro >= 10){
                    product[k] = pro%10;
                    carry = pro/10;
                }
                else{
                    product[k] = pro;
                    carry = 0;
                }
            }

            //we've finished multiplying, if there's any carry leftover we add it
            if(carry>0){
                product[k] = carry;
            }

            carry = 0;

            //now we'll add this number in product[] to the res[]
            for(i = n+m-1; i >= 0; i--){

                sum = product[i] + res[i] + carry;

                if(sum >= 10){
                    res[i] = sum%10;
                    carry = sum/10;
                }
                else{
                    res[i] = sum;
                    carry = 0;
                }

            }

        }

        // now we have our final product in res[]
        //to remove leading zeroes, we iterate i to first non zero digit
        i = 0;
        while(i < n+m && res[i] == 0){
            i++;
        }

        if(i == n+m){
            return "0";
        }

        //now i points to first non zero digit in res[]
        //a is our answer string
        if(sign == -1){
            a.append('-');
        }

        //appending each digit into the string
        while(i < n+m){
            a.append((char) (res[i] + 48));
            i++;
        }

        //converting stringBuilder to String
        return a.toString();
    }
}