class Solution {
    public String largestOddNumber(String num) {

        for(int i = num.length()-1; i>=0; i--){
            //first odd digit we get from the back forms the largest odd number
            if(num.charAt(i)%2 == 1){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}