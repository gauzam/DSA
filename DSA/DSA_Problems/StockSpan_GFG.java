//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for(i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
    }



}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here

        int ans[] = new int[n];

        //stack that stores the price and its index
        Stack<Pair> stack = new Stack<>();

        for(int i = 0; i < n; i++){

            //if stack is empty, stock span is 1 and we push curr price and index
            //if price at top of stack is greater than curr price, stock span is 1 and we push pair
            if(stack.isEmpty() || stack.peek().elem > price[i]){
                ans[i] = 1;
                Pair newpair = new Pair(price[i], i);
                stack.push(newpair);
                continue;
            }

            //if price at top of stack is smaller than curr price, we might have some stock span
            else if (stack.peek().elem <= price[i]){

                //all days when price was lower are popped out
                while(!stack.isEmpty() && stack.peek().elem <= price[i]){
                    stack.pop();
                }

                //is stack got empty, curr stock price is highest and stock span is all days
                if(stack.isEmpty()){
                    ans[i] = i + 1;
                }
                //if we found a price higher than curr, we stop and calculate stock soan
                else{
                    ans[i] = i - stack.peek().index;
                }

                //we puch curr price and index into the stack
                Pair newpair = new Pair(price[i], i);
                stack.push(newpair);

            }

        }

        return ans;
    }

}

//object of this class will be stored in the stack
class Pair
{
    int elem;
    int index;
    public Pair(int elem, int index){

        this.elem = elem;
        this.index = index;

    }
}