class Solution {

    public int bfs(int[][] grid, int i, int j, boolean[][] seen){
        Queue<int[]> queue = new LinkedList<>();
        seen[i][j] = true;
        queue.offer(new int[]{i, j});
        int area = 1;

        int dirs[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int[] dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !seen[nr][nc] && grid[nr][nc] == 1){
                    area++;
                    seen[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {

        if(grid == null || grid.length == 0){
            return 0;
        }

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && !seen[i][j]){
                    maxArea = Math.max(maxArea, bfs(grid, i, j ,seen));
                }
            }
        }

        return maxArea;
    }
}
