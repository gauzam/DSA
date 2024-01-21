class Solution {
    public int maxProfit(int[] prices) {

        int maxprofit = 0;
        int minSoFar = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){
            //checking minSoFar at each element
            if(prices[i] < minSoFar){
                minSoFar = prices[i];
            }

            //assuming we sell at each day, if we'd bought at cheapest day
            if(prices[i] - minSoFar > maxprofit){
                maxprofit = prices[i] - minSoFar;
            }
        }

        return maxprofit;
    }
}