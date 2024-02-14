class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();

        int i = 0;
        int j = 0;

        while(i < s.length()){
            if(map.containsKey(s.charAt(i))){
                if(t.charAt(j) != map.get(s.charAt(i))){
                    return false;
                }
            }

            map.put(s.charAt(i), t.charAt(j));
            i++;
            j++;
        }

        map.clear();
        i = 0;
        j = 0;

        //to check the mapping other way around
        while(i < t.length()){
            if(map.containsKey(t.charAt(i))){
                if(s.charAt(j) != map.get(t.charAt(i))){
                    return false;
                }
            }

            map.put(t.charAt(i), s.charAt(j));
            i++;
            j++;
        }

        return true;

    }
}