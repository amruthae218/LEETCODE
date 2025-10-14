class Solution {
    public class Pair{
        int row;
        int col;
        Pair(int x,int y){
            row=x;
            col=y;
        }
    }
    public int bfs(Queue<Pair> q,int[][]grid,boolean[][]visited){
        int cnt=-1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Pair curr=q.poll();
                int r=curr.row;
                int c=curr.col;
                visited[r][c]=true;
                int[] rowDir = {-1, 1, 0, 0};
                int[] colDir = {0, 0, -1, 1};
                for (int d=0;d<=3;d++){
                    int newRow = r + rowDir[d];
                    int newCol = c + colDir[d];
                    if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length){
                        if(grid[newRow][newCol]==1)
                        {
                            q.offer(new Pair(newRow,newCol));
                            grid[newRow][newCol]=2;
                            visited[newRow][newCol]=true;
                        }
                    }
                }   
            }
            cnt++;        
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return cnt;
    }
    public int orangesRotting(int[][] grid) {
        boolean[][]visited=new boolean[grid.length][grid[0].length];
        int freshcnt=0;
        Queue<Pair> rotten=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2){
                    rotten.add(new Pair(i,j));
                }
                else if(grid[i][j]==1) freshcnt++;
            }
        }
        if(freshcnt==0)return 0;
        return bfs(rotten,grid,visited);
    }
}