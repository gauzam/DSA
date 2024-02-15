class Solution {
    public int beautySum(String s) {

        int n = s.length();
        int ans = 0;

        for(int i = 0; i < n; i++){
            int freq[] = new int[26];

            for(int j = i; j < n; j++){
                freq[s.charAt(j) - 'a']++;
                int min = getMin(freq);
                int max = getMax(freq);

                int beauty = max - min;

                ans = ans + beauty;
            }

        }

        return ans;
    }

    public int getMin(int freq[]){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0){
                min = Math.min(min, freq[i]);
            }
        }

        return min;
    }

    public int getMax(int freq[]){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0){
                max = Math.max(max, freq[i]);
            }
        }

        return max;
    }
}