class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            tree.computeIfAbsent(freq, x -> new ArrayList<>()).add(num);
        }

        // 3. Traverse descending
        List<Integer> result = new ArrayList<>();

        for (int freq : tree.descendingKeySet()) {
            for (int num : tree.get(freq)) {
                result.add(num);
                if (result.size() == k) {
                    return result.stream().mapToInt(i -> i).toArray();
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
