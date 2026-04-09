class Solution {

    public int bfs(int[][] grid, int i, int j, boolean[][] seen){
        Queue<int[]> queue = new LinkedList<>();
        seen[i][j] = true;
        queue.offer(new int[]{i, j});
        int totalP = 0;

        while(!queue.isEmpty()){
            int p = 4;
            int[] current = queue.poll();
            int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int[] dir : dirs){
                int nr = current[0] + dir[0];
                int nc = current[1] + dir[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                    p--;
                }
            }
            totalP += p;
        }

        return totalP;

    }

    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int totalP = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && !seen[i][j]){
                    totalP += bfs(grid, i, j, seen);
                }
            }
        }

        return totalP;
    }
}