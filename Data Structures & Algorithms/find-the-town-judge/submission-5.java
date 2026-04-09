class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        for(int i = 1; i <=n ; i++){
            in.put(i, 0);
            out.put(i, 0);
        }


        for(int[] edge : trust){
            int src = edge[0];
            int dst = edge[1];
            in.put(dst, in.get(dst) + 1);
            out.put(src, out.get(src) + 1);
        }

        for(int i = 1; i<=n; i++){
            if(in.get(i) == n - 1 && out.get(i) == 0){
                return i;
            }
        }
        return -1;
    }
}