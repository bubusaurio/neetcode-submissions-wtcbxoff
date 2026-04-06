class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int[] res = new int[2];

        for(int r = 0; r<s.length(); r++){
            char c = s.charAt(r);
            window.put(c , window.getOrDefault(c, 0) + 1);
            
            if(countT.containsKey(c) && window.get(c) == countT.get(c)) have++;

            while(have == need){
                if(minLength > r - l + 1){
                    minLength = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar)-1);
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) have--;
                l++;
            }
        }
        if(minLength == Integer.MAX_VALUE) return "";
        return s.substring(res[0], res[1] + 1);     
    }
}
