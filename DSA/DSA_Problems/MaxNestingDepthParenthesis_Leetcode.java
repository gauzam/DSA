class Solution {
    public int maxDepth(String s) {

        if(s.length() <=1 ){
            return 0;
        }

        int openingbrackets = 0;

        //max number of brackets open in the string
        int maxSize = 0;

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '('){
                openingbrackets++;
            }

            maxSize = Math.max(maxSize, openingbrackets);

            if(s.charAt(i) == ')'){
                openingbrackets--;
            }
        }

        return maxSize;

    }
}