class Solution {
    public String longestPalindrome(String s) {

        //indexes of answer substring
        int ansL = 0;
        int ansR = 0;

        int maxLength = 0;

        int length = s.length();

        for(int i = 0; i < s.length(); i++){

            //for if substring is of odd length
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){

                if(right-left+1 > maxLength){
                    maxLength = right-left+1;
                    ansL = left;
                    ansR = right;
                }

                left--;
                right++;
            }

            //for if substring is of even length
            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxLength){
                    maxLength = right-left+1;
                    ansL = left;
                    ansR = right;
                }

                left--;
                right++;
            }
        }

        return s.substring(ansL, ansR+1);

    }
}