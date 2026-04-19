class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void dfs(List<Integer> combination, int[] nums, int target, int current, int sum){
        if(sum == target){
            res.add(new ArrayList<>(combination));
            return;
        }

        for(int i = current; i<nums.length; i++){
            if(sum + nums[i] <= target){
                combination.add(nums[i]);
                dfs(combination, nums, target , i, sum + nums[i]);
                combination.remove(combination.size() - 1);
            }
        }    
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(new ArrayList<>(), nums, target, 0, 0);

        return res;
    }
}
