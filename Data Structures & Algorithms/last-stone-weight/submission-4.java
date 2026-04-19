class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n : stones){
            maxHeap.offer(n);
        }

        while(maxHeap.size() > 1){
            int stoneX = maxHeap.poll();
            int stoneY = maxHeap.poll();

            int stoneZ = Math.abs(stoneX - stoneY);

            if(stoneZ != 0){
                maxHeap.offer(stoneZ);
            }
        }

        if(maxHeap.isEmpty()){
            return 0;
        }
        return maxHeap.poll();
    }
}
