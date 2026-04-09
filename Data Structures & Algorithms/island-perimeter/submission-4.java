class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return bfs(grid, seen, i, j, dirs);
            }
        }
        return 0;
    }

    private int bfs(int[][] grid, boolean[][] seen, int si, int sj, int[][] dirs){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{si, sj});
        seen[si][sj] = true;
        int totalP = 0;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int p = 4;
            for(int[] dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                    p--;
                    if(!seen[nr][nc]){
                        seen[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            totalP += p;
        }
        return totalP;
    }
}