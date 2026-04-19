class KthLargest {

    private PriorityQueue<Integer> maxHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n : nums) this.maxHeap.offer(n);
        this.k = k;

    }
    
    public int add(int val) {
        this.maxHeap.offer(val);
        PriorityQueue<Integer> aux = new PriorityQueue<>(this.maxHeap);
        int n = 0;

        for(int i = 0; i<this.k; i++){
            n = aux.poll();
        }

        return n;
    }
}
