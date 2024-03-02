//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int q = sc.nextInt();
            GfG g = new GfG();
            while(q>0)
            {
                int qt = sc.nextInt();

                if(qt == 1)
                {
                    int att = sc.nextInt();
                    g.push(att);
                    //System.out.println(att);
                }
                else if(qt == 2)
                {
                    System.out.print(g.pop()+" ");
                }
                else if(qt == 3)
                {
                    System.out.print(g.getMin()+" ");
                }

                q--;
            }
            System.out.println();
            T--;
        }

    }
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Pair> st;

    // Constructor    
    GfG() {
        minEle = Integer.MAX_VALUE;
        st = new Stack();
    }

    /*returns min element from stack*/
    int getMin() {

        if(st.isEmpty()){
            return -1;
        }

        return st.peek().min;
    }

    /*returns poped element from stack*/
    int pop() {

        if(st.isEmpty()){
            return -1;
        }
        return st.pop().val;
    }

    /*push element x into the stack*/
    void push(int x) {

        if(st.isEmpty()) {
            st.push(new Pair(x, x));
            minEle = x;
        }
        else {
            int prevMin = st.peek().min;
            st.push(new Pair(x, Math.min(x, prevMin)));
        }
    }
}

class Pair {
    int val;
    int min;

    public Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}