class Solution {
    Set<List<Integer>> res = new HashSet<>();

    public void dfs(List<Integer> combination, int[] nums, int target, int current){
        if(target == 0){
            res.add(new ArrayList<>(combination));
            return;
        }

        for(int i = current; i<nums.length; i++){

            if(i>current && nums[i] == nums[i-1]) continue;

            if(nums[i] > target) break;

            combination.add(nums[i]);
            dfs(combination, nums, target - nums[i], i+1);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), candidates, target, 0);

        return new ArrayList<>(res);
    }   
}
