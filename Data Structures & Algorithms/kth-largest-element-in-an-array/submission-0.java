class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n : nums){
            maxH.offer(n);
        }

        int result = 0;

        for(int i = 0; i<k; i++){
            result = maxH.poll();
        }

        return result;
    }
}
