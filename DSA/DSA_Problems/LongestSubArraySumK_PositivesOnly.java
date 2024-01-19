public class Solution {
    public static int longestSubarrayWithSumK(int []arr, long k) {

        //initializing two pointers for the subarray window
        int left = 0;
        int right = 0;

        int maxlen = 0;
        long sum = arr[0];

        int size = arr.length;

        while(right<size && left<size){

            //increase the subarray till sum is less than target
            while(right<size && sum<k){
                right++;
                if(right<size){
                    sum = sum+arr[right];
                }
            }

            //decrease the subarray till the sum is more than target
            while(left<size && sum>k){
                sum = sum - arr[left];
                left++;
            }

            //if sum equals target, we compare maxlen, and move right further
            if(sum == k){
                if((right-left+1) > maxlen){
                    maxlen = right-left+1;
                }
                right++;
                if(right<arr.length){
                    sum = sum + arr[right];
                }
            }
        }

        return maxlen;

    }
}