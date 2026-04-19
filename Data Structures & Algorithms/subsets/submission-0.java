class Solution {
    List<List<Integer>> res = new ArrayList<>();


    public void dfs(List<Integer> subset, int i, int[] nums){
        res.add(new ArrayList<>(subset));

        for(int j = i; j < nums.length; j++){
            subset.add(nums[j]);

            dfs(subset, j+1, nums);

            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(new ArrayList<>(), 0, nums);
        
        return res;
    }
}
