class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //index initialised at the end of last nonzero element in nums1
        int i = m-1;

        //index initialised at the end of nums2
        int j = n-1;

        //index initialised at the end of nums1
        int k = m+n-1;

        while(i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        //if arr1 has exhausted, we put all the arr2 elements in nums1
        while(j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}