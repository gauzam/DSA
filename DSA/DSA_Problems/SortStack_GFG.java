//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Stack<Integer> s=new Stack<>();
            int n=sc.nextInt();
            while(n-->0)
                s.push(sc.nextInt());
            GfG g=new GfG();
            Stack<Integer> a=g.sort(s);
            while(!a.empty()){
                System.out.print(a.peek()+" ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
    public Stack<Integer> sort(Stack<Integer> s)
    {
        //add code here.

        if(s.size() == 0 || s.size() == 1){
            return s;
        }

        int elem = s.pop();

        Stack<Integer> smallans = sort(s);

        Stack<Integer> helper = new Stack<>();

        while(!smallans.isEmpty() && smallans.peek() >= elem){
            helper.push(smallans.pop());
        }

        smallans.push(elem);

        while(!helper.isEmpty()){
            smallans.push(helper.pop());
        }

        return smallans;


    }
}