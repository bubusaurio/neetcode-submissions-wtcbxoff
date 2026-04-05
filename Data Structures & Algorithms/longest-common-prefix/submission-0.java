class Solution {
    public String longestCommonPrefix(String[] strs) {

        int smallestIndex = 0;
        for(int i = 0; i<strs.length; i++){
            if(strs[i].length() < strs[smallestIndex].length()){
                smallestIndex = i;
            }
        }

        int commonIndex = strs[smallestIndex].length() - 1;

        for(String s: strs){
            for(int i = 0; i<=commonIndex; i++){
                if(s.charAt(i) != strs[smallestIndex].charAt(i)){
                    commonIndex = i - 1;
                    break;
                }
            }
        }

        char[] sArr = new char[commonIndex + 1];

        for(int i = 0; i<=commonIndex; i++){
            if(strs[smallestIndex].charAt(i) != '\0'){
                sArr[i] = strs[smallestIndex].charAt(i);
            }
        }

        return new String(sArr);

    }
}