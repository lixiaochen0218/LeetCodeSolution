public class LeetCode059 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int x = 0, y=0;
        int top = 0;
        int bottom = n-1;
        int left = -1;
        int right = n-1;
        for(int i=1;i<=n*n;i++){
            // System.out.println(top + " " + bottom);
            if(y == top && x <=right && x > left){
                ans[y][x] = i;
                x++;
                if(x > right){
                    x--;
                    y++;
                    left++;
                }
            }else if(x == right && y <= bottom){
                ans[y][x] = i;
                y++;
                if(y > bottom){
                    y--;
                    x--;
                    top++;
                }
            }else if(y == bottom && x >= left){
                ans[y][x] = i;
                x--;
                if(x<left){
                    x++;
                    y--;
                    right--;
                }
            }else if(x == left && y >= top){
                ans[y][x] = i;
                y--;
                if(y < top){
                    y++;
                    x++;
                    bottom--;
                }
            }
        }
        return ans;
    }
}
