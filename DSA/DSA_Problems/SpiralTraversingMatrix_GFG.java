//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                    matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans)
                System.out.print(val+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();

        //index for row start
        int rs = 0;
        //index for row end
        int re = matrix.length - 1;

        //index for column start
        int cs = 0;
        //index for column end
        int ce = matrix[0].length - 1;

        //number of elements in the matrix
        int n = r*c;

        //for counting elements
        int elem = 0;

        //one loop means one spiral
        while(elem < n){

            for(int i = cs; i <= ce && elem < n; i++){
                ans.add(matrix[rs][i]);
                elem++;
            }

            rs++;

            for(int i = rs; i <= re && elem < n; i ++){
                ans.add(matrix[i][ce]);
                elem++;
            }

            ce--;

            for(int i = ce; i>=cs && elem < n; i--){
                ans.add(matrix[re][i]);
                elem++;
            }

            re--;

            for(int i = re; i >= rs && elem < n; i--){
                ans.add(matrix[i][cs]);
                elem++;
            }

            cs++;

        }

        return ans;
    }
}
