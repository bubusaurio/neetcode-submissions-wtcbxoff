class Solution {

    public void bfs(char[][] grid, int i, int j, boolean[][] seen){
        Queue<int[]> queue = new LinkedList<>();
        seen[i][j] = true;
        queue.offer(new int[]{i, j});

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1, 0}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] d : dirs){
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !seen[nr][nc] && grid[nr][nc] == '1'){
                    seen[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0 && grid[0].length == 0){
            return 0;
        }

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !seen[i][j]){
                    islands++;
                    bfs(grid, i , j, seen);
                }
            }
        }

        return islands;

    }
}
