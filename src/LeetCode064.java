public class LeetCode064 {
    private int ans = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if(row == 0 && col == 0) grid[row][col] = grid[row][col];
                else if(row == 0 && col != 0) grid[row][col] = grid[row][col] + grid[row][col - 1];
                else if(col == 0 && row != 0) grid[row][col] = grid[row][col] + grid[row - 1][col];
                else grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[height - 1][width - 1];
    }

    private void helper(int[][] grid, int x, int y, int m, int n, int sum) {
        if (x < 0 || y < 0 || x >=m || y >=n || grid[x][y] == -1) {
            return;
        }
        if (x == m -1 && y == n-1) {
            sum += grid[x][y];
            ans = Math.min(ans, sum);
            return;
        } else {
            sum += grid[x][y];
            int temp = grid[x][y];
            grid[x][y] = -1;
            helper(grid, x + 1,y, m,n,sum);
            helper(grid, x - 1,y, m,n,sum);
            helper(grid, x ,y + 1, m,n,sum);
            helper(grid, x ,y - 1, m,n,sum);
            grid[x][y] = temp;
            sum -= temp;
        }
    }
}
