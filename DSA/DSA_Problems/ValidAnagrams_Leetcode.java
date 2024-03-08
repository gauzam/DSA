class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        //creating a frequency array of fixed size
        int arr[] = new int[26];

        //updating freq array for string1
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        //updating freq array for string2
        for(int i = 0; i < t.length(); i++){
            arr[t.charAt(i) - 'a']--;
        }

        //for it to be anagrams, the freq array should be all zeroes
        for(int i = 0; i < arr.length; i++){
            //any non zero value found means not anagrams
            if(arr[i] != 0){
                return false;
            }
        }

        return true;
    }
}