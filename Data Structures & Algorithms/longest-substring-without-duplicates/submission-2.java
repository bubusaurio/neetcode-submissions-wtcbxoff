class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int start = 0;
        char[] word = s.toCharArray();


        for(int i = 0; i<word.length; i++){
            char letter = word[i];

            while(set.contains(letter)){
                set.remove(word[start]);
                start++;
            }

            set.add(letter);

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;

    }
}
