class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        
        if(grid[0][0]==1) return -1;
        
        Queue<int[]> que=new LinkedList<>();
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        
        dist[0][0]=1;
        que.add(new int[]{1,0,0});
        
        int[] dx={0,1,1,1,0,-1,-1,-1};
        int[] dy={1,1,0,-1,-1,-1,0,1};
        
        while(que.size()>0){
            int[] r=que.peek();
            que.remove();
            int dis=r[0];
            int i=r[1];
            int j=r[2];
            
            for(int k=0;k<8;k++){
                int x=i+dx[k];
                int y=j+dy[k];
                
                if(x<0 || x>=n || y<0 || y>=n) continue; 
                
                if(grid[x][y]==0 && dis+1<dist[x][y]){
                    dist[x][y] = dis+1;
                    que.add(new int[]{dis+1,x,y});
                }
            }
        }
        
        return dist[n-1][n-1]==Integer.MAX_VALUE ? -1 : dist[n-1][n-1];
    }
}
