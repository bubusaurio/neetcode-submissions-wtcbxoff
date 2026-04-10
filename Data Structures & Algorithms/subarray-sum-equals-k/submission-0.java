class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int totalSum = 0;

        for (int r = 0; r < nums.length; r++) {
            totalSum += nums[r];
            if (map.containsKey(totalSum - k)) {
                result += map.get(totalSum - r - (totalSum - k) == 0 ? totalSum - k : totalSum - k);
            }
            map.put(totalSum, map.getOrDefault(totalSum, 0) + 1);
        }
        return result;
    }
}