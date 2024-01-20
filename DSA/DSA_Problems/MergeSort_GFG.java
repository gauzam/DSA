//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
    static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }



    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking testcases
        int T = sc.nextInt();
        while(T>0)
        {
            //taking elements count
            int n = sc.nextInt();

            //creating an object of class Merge_Sort
            Merge_Sort ms = new Merge_Sort();

            //creating an array of size n
            int arr[] = new int[n];

            //adding elements to the array
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();


            Solution g = new Solution();

            //calling the method mergeSort
            g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
            ms.printArray(arr);
            T--;
        }
    }
}



// } Driver Code Ends


class Solution
{
    void merge(int arr[], int si, int mid, int ei)
    {
        //variables for first array
        int start1 = si;
        int end1 = mid;

        //variables for 2nd array
        int start2 = mid+1;
        int end2 = ei;

        //constructing new array to merge and sort
        int ans[] = new int[ei-si+1];
        int k = 0;

        while(start1 <= end1 && start2 <= end2){
            if(arr[start1] <= arr[start2]){
                ans[k] = arr[start1];
                start1++;
            }
            else {
                ans[k] = arr[start2];
                start2++;
            }

            k++;
        }

        while(start1 <= end1){
            ans[k] = arr[start1];
            start1++;
            k++;
        }

        while(start2 <= end2){
            ans[k] = arr[start2];
            start2++;
            k++;
        }

        //ans array is merged and sorted
        //now we place the elements back in the original array
        for(int i = 0; i < ans.length; i++){
            arr[si] = ans[i];
            si++;
        }

        return;

    }
    void mergeSort(int arr[], int si, int ei)
    {
        //base case
        if(si>=ei){
            return;
        }

        int mid = (si+ei)/2;

        //sorting both halves using recursion
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        //we merge two sorted arrays using this function
        merge(arr, si, mid, ei);

        return;
    }
}
