class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str);
            sb.append('\0');
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        String[] strs = str.split("\0", -1);
        List<String> list =  new ArrayList<>(Arrays.asList(strs));

        list.remove(list.size() - 1);

        return list;
    }
}
