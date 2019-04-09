public class LeetCode695 {
    int[][] grid;
    boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int y=0;y<grid.length;y++){
            for(int x=0;x<grid[0].length;x++){
                ans = Math.max(ans, DFS(y,x));
            }
        }
        return ans;
    }

    public int DFS(int y, int x){
        if(y <0 || x <0 || y >= this.grid.length || x>= this.grid[0].length || this.grid[y][x] == 0 || this.seen[y][x]){
            return 0;
        }
        seen[y][x] = true;
        return 1 + DFS(y+1,x) + DFS(y-1,x) + DFS(y,x+1) + DFS(y,x-1);
    }
}
