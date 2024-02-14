class Solution {
    public int myAtoi(String s) {

        s = s.trim();

        if(s.length() == 0){
            return 0;
        }

        int sign = 1;

        if(s.charAt(0) == '-'){
            sign = -1;
            s = s.substring(1);
        }
        else if(s.charAt(0) == '+'){
            s = s.substring(1);
        }

        int multiplier = 10;
        int ans = 0;

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) - '0' > 9 || s.charAt(i) - '0' < 0){
                break;
            }

            int num = (int)(s.charAt(i) - '0');

            if (ans > (Integer.MAX_VALUE - num) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = (ans*multiplier) + num;

        }

        return ans*sign;
    }
}