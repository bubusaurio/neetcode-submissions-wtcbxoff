class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        int matches = 0;

        if(s2.length() < s1.length()) return false;

        for(char c : s1.toCharArray()){
            s1Count[c - 'a']++;
        }

        for(int i = 0; i<windowSize; i++){
            windowCount[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i<26; i++){
            if(s1Count[i] == windowCount[i]){
                matches++;
            }
        }

        for(int i = windowSize; i<s2.length(); i++){
            int removedChar = s2.charAt(i-windowSize) - 'a';
            int newChar = s2.charAt(i) - 'a';
            if(matches == 26) return true;

            if(windowCount[removedChar] == s1Count[removedChar]) matches--;
            windowCount[removedChar]--;
            if(windowCount[removedChar] == s1Count[removedChar]) matches++;

            if(windowCount[newChar] == s1Count[newChar]) matches--;
            windowCount[newChar]++;
            if(windowCount[newChar] == s1Count[newChar]) matches++;
        }

        return matches == 26;
    }
}
