class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minH = new PriorityQueue<>((a,b) -> (a[0]*a[0] + a[1]*a[1])- (b[0]*b[0] + b[1]*b[1]));
        int[][] result = new int[k][2];

        for(int[] p : points){
            minH.offer(p);
        }

        for(int i = 0; i<k; i++){
            result[i] = minH.poll();
        }

        return result;

    }
}