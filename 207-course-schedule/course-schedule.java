class Solution {
    public boolean dfs (int i,List<List<Integer>> adj,boolean[]visited,boolean[]dfsvisited)
    {
        visited[i]=true;
        dfsvisited[i]=true;
        for(int neighbor:adj.get(i))
        {
            if(!visited[neighbor])
            {
                if(dfs(neighbor,adj,visited,dfsvisited))return true;
            }
            else if(dfsvisited[neighbor])
            {
                return true;
            }
        }
        dfsvisited[i]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[]visited=new boolean[numCourses];
        boolean[]dfsvisited=new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            adj.get(prereq).add(course); 
        }
        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,adj,visited,dfsvisited))
                {
                    return false;
                }
            }
        }
        return true;
    }
}