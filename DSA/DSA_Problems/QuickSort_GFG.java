//{ Driver Code Starts
import java.util.*;
class Sorting
{
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();


            new Solution().quickSort(arr,0,n-1);
            printArray(arr);
            T--;
        }
    } }
// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int si, int ei)
    {
        //base case
        if(si>=ei){
            return;
        }

        //partition method ensures elements to the left of pivotElem are smaller
        //and elements to the right are larger than pivot element, and returns pivot index
        int pivotIndex = partition(arr, si, ei);

        //recursive calls to sort the array halves
        quickSort(arr, si, pivotIndex-1);
        quickSort(arr, pivotIndex+1, ei);

        return;
    }

    static int partition(int arr[], int si, int ei)
    {
        int pivotElem = arr[si];

        int count = 0;

        //counting elements smaller/equal than pivot element
        for(int i = si+1; i <= ei; i++){
            if(arr[i] <= pivotElem){
                count++;
            }
        }

        int pivotIndex = si+count;

        //placing pivot element at its correct posn
        arr[si] = arr[pivotIndex];
        arr[pivotIndex] = pivotElem;

        int i = si;
        int j = ei;

        //ensuring all elements less than pivot are on the left and larger ones are the right
        while(i < pivotIndex && j > pivotIndex){
            if(arr[i] <= pivotElem){
                i++;
            }
            else if(arr[j] > pivotElem){
                j--;
            }
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        return pivotIndex;

    }
}
