class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dist[][] = new int[n][m];

        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        dist[0][0] = grid[0][0];
        pq.add(new int[]{grid[0][0],0,0});

        //direction
        int[] dr = {1,0};
        int[] dc = {0,1};

        while(!pq.isEmpty()){
            int curr[] = pq.poll();

            int cost = curr[0];
            int row = curr[1];
            int col = curr[2];

            //reached
            if(row == n-1 && col == m-1){
                return cost;
            }

            for(int i=0; i<2; i++){
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow >=0 && newRow < n && newCol >= 0 && newCol < m){
                    int newCost = cost + grid[newRow][newCol];

                    if(newCost < dist[newRow][newCol]){
                        dist[newRow][newCol] = newCost;
                        pq.add(new int[]{newCost,newRow,newCol});
                    }
                }
            }
        }
        return -1;
    }
}