class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int counter = 0;

        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }

        for(int i = 0; i<nums.length; i++){
            int temp = 0;
            if(!set.contains(nums[i]-1)){
                int j = 0;
                while(set.contains(nums[i]+j)){
                    temp++;
                    j++;
                }
            }
            counter = Math.max(counter, temp);
        }

        return counter;
    }
}
