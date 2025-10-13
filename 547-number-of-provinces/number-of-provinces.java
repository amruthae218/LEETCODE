class Solution {
    public void traverse(int root,int[][] isConnected,boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int curr=q.poll();
            visited[curr]=true;
            for(int i=0;i<isConnected[0].length;i++)
            {
                if(isConnected[curr][i]==1 && !visited[i]){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited=new boolean[isConnected.length];
        int cnt=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                traverse(i,isConnected,visited);
                cnt++;
            }
        }
        return cnt;
    }
}