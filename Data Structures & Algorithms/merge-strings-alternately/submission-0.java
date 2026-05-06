class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int word1Pointer = 0;
        int word2Pointer = 0;

        char[] result = new char[word1.length() + word2.length()];
        int i = 0;
        boolean toggle = true;

        while(word1Pointer<word1.length() || word2Pointer<word2.length()){
            if(word1Pointer >= word1.length()){
                result[i] = word2.charAt(word2Pointer);
                word2Pointer++;
                i++;
                continue;
            } 
            if(word2Pointer >= word2.length()){
                result[i] = word1.charAt(word1Pointer);
                word1Pointer++;
                i++;
                continue;
            }
            
            if(toggle){
                result[i] = word1.charAt(word1Pointer);
                word1Pointer++;
                i++;
                toggle = !toggle;
                continue;
            }else{
                result[i] = word2.charAt(word2Pointer);
                word2Pointer++;
                i++;
                toggle = !toggle;
                continue;
            }   
        }

        return new String(result);

    }
}