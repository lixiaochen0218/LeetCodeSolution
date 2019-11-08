public class LeetCode207 {    
    public boolean canFinish(int numCourses, int[][] prerequisites) {        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        
        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];            
            graph.get(course).add(prerequisite);
        }
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (dfs(i, graph, visited)) return false;
        
        return true;
    }
    // 0:never vistied, 1:visiting, 2:visited
    // If dfs return true, cycle existed.
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        // If curr is visiting, whicih means a cycle exists.
        if (visited[curr] == 1) return true;
        // If curr is visited, which means curr is not depend on others.
        if (visited[curr] == 2) return false;
        
        visited[curr] = 1;
                
        for (int next : graph.get(curr))
            if (dfs(next, graph, visited)) return true;
        
        visited[curr] = 2;
        return false;
    }
 
}