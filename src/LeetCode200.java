public class LeetCode200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        if(grid.length == 0)
            return ans;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j] == '1'){
                    helper(i,j,grid);
                    ans++;
                }
        return ans;
    }


    private void helper(int x,int y, char[][] grid){
        if(x<0 || x >=grid.length || y <0 || y >= grid[0].length || grid[x][y] == '0' || grid[x][y] == '2')
            return;
        grid[x][y] = '2';
        helper(x+1,y,grid);
        helper(x-1,y,grid);
        helper(x,y+1,grid);
        helper(x,y-1,grid);
    }
}
