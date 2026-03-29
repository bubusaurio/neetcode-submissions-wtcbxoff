class Solution {
    public boolean isPalindrome(String s) {

        char[] array = s.toCharArray();
        int start = 0;
        int end = array.length - 1;
        
        for(int i = 0; i<array.length; i++){
            char startChar = Character.toLowerCase(array[start]);
            char endChar = Character.toLowerCase(array[end]);
            boolean areAlphanumerical = (Character.isLetterOrDigit(startChar)) && (Character.isLetterOrDigit(endChar)); 

            if(startChar != endChar && areAlphanumerical){
                return false;
            }

            if(!Character.isLetterOrDigit(startChar) && Character.isLetterOrDigit(endChar)){
                start++;
            }
            else if(Character.isLetterOrDigit(startChar) && !Character.isLetterOrDigit(endChar)){
                end--;
            }
            else{
                start++;
                end--;
            }
        }

        return true;
    }
}
