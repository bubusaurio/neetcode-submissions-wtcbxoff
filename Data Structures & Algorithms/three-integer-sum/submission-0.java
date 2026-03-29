class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int start = 0;
        int end = nums.length - 1;

        Arrays.sort(nums);

        for(int i = 0; i<nums.length; i++){
            int negative = (nums[i]) * -1;
            start = i + 1;
            end = nums.length - 1;
            while(start < end){
                int num1 = nums[start];
                int num2 = nums[end];
                int sum = num1 + num2;

                if(sum == negative){
                    set.add(Arrays.asList(nums[i], num1, num2));
                    start++;
                    end--;
                }else if(sum > negative){
                    end--;
                }else if(sum < negative){
                    start++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
