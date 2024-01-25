class Solution {
    public int maxProduct(int[] nums) {

        //to calculate prefix product
        int prefix = 1;
        //to calculate suffix product
        int suffix = 1;

        int maxproduct = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){

            //whenever product is zero, set it back to one
            if(prefix == 0 ){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }

            //calculating both products in single scan
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length-i-1];

            //maintaining maxproduct
            maxproduct = Math.max(maxproduct, Math.max(prefix, suffix));

        }

        return maxproduct;


    }
}