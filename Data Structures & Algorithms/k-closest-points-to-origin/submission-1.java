class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // distance -> list of points (to handle duplicates)
        Map<Double, List<int[]>> map = new HashMap<>();

        PriorityQueue<Double> minH = new PriorityQueue<>();

        int[][] result = new int[k][2];

        // fill map and heap
        for (int[] point : points) {
            double distance = point[0]*point[0] + point[1]*point[1];

            map.computeIfAbsent(distance, x -> new ArrayList<>()).add(point);
            minH.offer(distance);
        }

        int i = 0;

        while (i < k) {
    double dist = minH.poll();
    List<int[]> list = map.get(dist);

    // skip if empty
    if (list == null || list.isEmpty()) continue;

    int[] coords = list.remove(list.size() - 1);
    result[i++] = coords;

    // only reinsert if still has elements
    if (!list.isEmpty()) {
        minH.offer(dist);
    }
}

        return result;
    }
}