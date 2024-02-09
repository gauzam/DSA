class Solution {

    public int shipDays(int weights[], int capacity){
        int days = 1;
        int currLoad = 0;

        for(int i = 0; i < weights.length; i++){
            if(currLoad + weights[i] > capacity){
                days++;
                currLoad = weights[i];
            }
            else{
                currLoad = currLoad + weights[i];
            }
        }

        return days;
    }
    public int shipWithinDays(int[] weights, int days) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < weights.length; i++){
            if(weights[i] > max){
                max = weights[i];
            }

            sum = sum + weights[i];
        }

        int start = max;
        int end = sum;

        int minCap = Integer.MAX_VALUE;

        while(start <= end){
            int mid = (start + end)/2;

            int currdays = shipDays(weights, mid);

            if(currdays > days){
                start = mid+1;
            }
            else{
                minCap = mid;
                end = mid-1;
            }
        }

        return minCap;

    }
}