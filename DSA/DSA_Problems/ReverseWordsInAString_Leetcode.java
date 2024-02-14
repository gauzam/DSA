class Solution {
    public String reverseWords(String str) {

        //to trim off starting and ending spaces
        str = str.trim();

        //creating an array of strings that will contain the words from str
        String words[] = str.split("\\s+");

        StringBuilder ans = new StringBuilder("");

        //start appending words from the back
        for(int i = words.length-1; i>0; i--) {
            ans.append(words[i] + " ");
        }

        //append the first word explicitly
        ans.append(words[0]);

        return ans.toString();

    }
}