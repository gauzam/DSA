class Solution {
    public String longestCommonPrefix(String[] strs) {

        //lexicographically sorting the array
        Arrays.sort(strs);

        //longest prefix must be common in first and last strings
        String s1 = strs[0];
        String s2 = strs[strs.length-1];

        //index till where prefix is common
        int index = 0;

        //if the string is exhausted or the chars arent same, we break
        while(index < s1.length() && index < s2.length()){
            if(s1.charAt(index) == s2.charAt(index)){
                index++;
            } else {
                break;
            }
        }

        //return the substring
        return s1.substring(0, index);

    }
}