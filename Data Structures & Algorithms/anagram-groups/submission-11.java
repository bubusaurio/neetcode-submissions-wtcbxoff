class Solution {
    private boolean isAnagram(String s, String t){
        Map<Character, Integer> map = new HashMap<>();

        if(s.length() != t.length()) return false;


        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()){
            if(!map.containsKey(c)) return false;

            if(map.get(c) == 1){
                map.remove(c);
            }
            else{
                map.put(c, map.get(c)-1);
            }
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listOfAnagrams = new ArrayList<>();
        Set<String> set = new HashSet<>();

        if(strs.length == 0){
            return listOfAnagrams;
        }

        if(strs.length == 1){
            listOfAnagrams.add(Arrays.asList(strs[0]));
            return listOfAnagrams;
        }

        for(String str : strs){
            set.add(str);
        }

        int current = 1;

        for(String str : strs){
            if(set.contains(str)){
                set.remove(str);
                ArrayList<String> arr = new ArrayList<>();
                arr.add(str);
                for(int i = current; i<strs.length; i++){
                    if(isAnagram(str, strs[i])){
                        arr.add(strs[i]);
                        set.remove(strs[i]);
                    }
                }
                listOfAnagrams.add(arr);
            }
            current++;
        }

          
        return listOfAnagrams;
        
    }
}
