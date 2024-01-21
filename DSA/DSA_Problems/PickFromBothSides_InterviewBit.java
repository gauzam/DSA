public class Solution {
    public int solve(int[] arr, int B) {

        //sum of the contigous window - to be minimum
        int windowSum = 0;
        //sum of the total array
        int totalSum = 0;

        //length of the window
        int windowlength = arr.length - B;

        //initial start index of window
        int i = 0;
        //initial end index of window
        int j = windowlength-1;

        for(int k = 0; k<arr.length; k++){

            if(k<=j){
                windowSum = windowSum + arr[k];
            }

            totalSum = totalSum + arr[k];
        }

        //for this to be max, windowSum needs to be minimum
        int max = totalSum - windowSum;

        while(j<arr.length){
            j++;
            if(j == arr.length){
                break;
            }
            windowSum = windowSum - arr[i] + arr[j];
            i++;

            if(totalSum - windowSum > max){
                max = totalSum - windowSum;
            }

        }

        return max;

    }
}
