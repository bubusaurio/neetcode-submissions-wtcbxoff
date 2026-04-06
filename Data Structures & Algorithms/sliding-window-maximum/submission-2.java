class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int nW = nums.length - k + 1;
        int[] windows = new int[nW];
        int l = 0;

        for(int r = 0; r<nums.length; r++){
            int currentValue = nums[r];

            while(!deq.isEmpty() && nums[deq.peekFirst()] < currentValue){
                deq.removeFirst();
            }
            deq.addFirst(r);

            if(l > deq.peekLast()){
                deq.removeLast();
            }

            if(r+1 >= k){
                windows[l] = nums[deq.peekLast()];
                l++;
            }
        }

        return windows;

    }
}
