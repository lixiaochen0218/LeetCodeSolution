import java.util.LinkedList;
import java.util.Queue;

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
---------------------
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
---------------------


 */
public class LeetCode286 {
    public void wallsAndGates(int [][] rooms) { //DSF
        if (rooms.length == 0) return;
        int row = rooms.length, col = rooms[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                if (rooms[i][j] == 0) DFS(rooms, i, j, 0);
        }
    }

    private void DFS(int [][] rooms, int x, int y, int dis)
    {
        int row = rooms.length, col = rooms[0].length;
        if(x<0||y<0||x>=row||y>=col||rooms[x][y]<0||rooms[x][y]<dis) return;
        rooms[x][y] = dis++;
        DFS(rooms, x+1, y, dis);
        DFS(rooms, x-1, y, dis);
        DFS(rooms, x, y+1, dis);
        DFS(rooms, x, y-1, dis);
    }

    public void wallsAndGates2(int [][] rooms) {  //BSF
        Queue<Room> queue = new LinkedList();

        if (rooms.length == 0) return;
        int row = rooms.length, col = rooms[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                if(rooms[i][j] == 0){
                    queue.add(new Room(i,j));
                }
            }
        }
        while(!queue.isEmpty()){
            Room temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            helper(x+1,y,rooms, queue,rooms[x][y]+1);
            helper(x-1,y,rooms, queue,rooms[x][y]+1);
            helper(x,y+1,rooms, queue,rooms[x][y]+1);
            helper(x,y-1,rooms, queue,rooms[x][y]+1);
        }
    }

    private void helper(int x, int y, int [][] rooms, Queue<Room> queue, int steps ){
        if (x<0 || x >= rooms.length || y<0 || y> rooms[0].length || rooms[x][y] == -1 || rooms[x][y] != Integer.MAX_VALUE)
            return;

        rooms[x][y] = steps;
        queue.add(new Room(x,y));

    }//moves

    class Room {
        int x;
        int y;
        public Room(int m,int n){
            this.x = m;
            this.y = n;
        }
    }


}
