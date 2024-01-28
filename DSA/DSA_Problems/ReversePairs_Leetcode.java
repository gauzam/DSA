
class Solution {

    //global variable for counting reverse pairs
    int count = 0;

    public void countPairs(int arr[], int si, int ei, int mid){

        int start1 = si;
        int end1 = mid;

        int start2 = mid+1;
        int end2 = ei;

        int j = start2;

        //loop that counts reverse pairs
        for(int i = si; i <= end1; i++){
            while(j<=ei && (long)arr[i] > (long)2*arr[j]){
                j++;
            }
            count = count + (j-start2);
        }

        return;
    }

    public void merge(int arr[], int si, int ei, int mid){

        int start1 = si;
        int start2 = mid+1;

        int temp[] = new int[ei-si+1];
        int k = 0;

        while(start1<=mid && start2<=ei){
            if(arr[start1] <= arr[start2]){
                temp[k] = arr[start1];
                start1++;
            }
            else{
                temp[k] = arr[start2];
                start2++;
            }
            k++;
        }

        while(start1<=mid){
            temp[k] = arr[start1];
            start1++;
            k++;
        }

        while(start2<=ei){
            temp[k] = arr[start2];
            start2++;
            k++;
        }

        k = 0;

        for(int p = si; p <= ei; p++){
            arr[p] = temp[k];
            k++;
        }

        return;
    }

    public void mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }

        int mid = (si+ei)/2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        //when the two halves of the array are sorted, we call the 
        //countPairs method to count the no. of reverse pairs
        countPairs(arr, si, ei, mid);

        merge(arr, si, ei, mid);
    }
    public int reversePairs(int[] nums) {

        mergeSort(nums, 0, nums.length-1);

        //after calling the merge sort fxn, we have our ans in the global variable count
        return count;

    }
}