package com_stacks;

import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {

	
	 public int orangesRotting(int[][] grid)
	    {
	        // Code here
	        
	        Queue<int[]> q = new LinkedList<>();
	        int t = 0;
	        
	        //dx -> represents the coordinates that we need to traverse the 
	        // top, left, up ,right
	        int dx[] = { 0, -1, 1, 0 };
	        int dy[] = { -1, 0, 0, 1 };
	        
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[0].length; j++) {
	                if (grid[i][j] == 2) {
	                    q.add(new int[] { i, j, 0 });
	                }
	            }
	        }
	       
	        while (!q.isEmpty()) {
	            int[] temp = q.poll();
	            int k = temp[0];
	            int l = temp[1];

	            t = Math.max(t, temp[2]);

	            int x;
	            int y;

	            for (int p = 0; p < 4; p++) {
	                x = k + dx[p];
	                y = l + dy[p];

	                if (

	                x >= 0 && x <= grid.length - 1 &&
	                        y >= 0 && y <= grid[0].length - 1 &&
	                        grid[x][y] == 1

	                ) {
	                    grid[x][y] = 2;
	                    q.add(new int[] { x, y, t + 1 });
	                }

	            }

	        }
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[0].length; j++) {
	                if (grid[i][j] == 1)
	                    return -1;
	            }
	        }
	        return t;
	    }
}
