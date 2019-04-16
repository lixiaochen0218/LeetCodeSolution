public class LeetCode079 {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(DFS(j,i,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean DFS(int x, int y, char[][] board, String word, int index){
        if(x<0 || y<0 || x >=board[0].length || y>=board.length || board[y][x] != word.charAt(index)){
            return false;
        }
        if(index == word.length() -1){
            return true;
        }
        char c = board[y][x];
        board[y][x] = '0';
        boolean ans = DFS(x+1,y,board,word,index+1)||
                DFS(x-1,y,board,word,index+1)||
                DFS(x,y+1,board,word,index+1)||
                DFS(x,y-1,board,word,index+1);
        board[y][x] = c;
        return ans;
    }
}
