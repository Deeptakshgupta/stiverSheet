package com_stacks;

import java.util.*;

/*
 You are given a queue Q of N integers of even length, 
 rearrange the elements by interleaving the first half 
 of the queue with the second half of the queue.
 */

public class interLeaverFirstHalfWithSecondHalfOf_Q {

	public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
        // code here
        Queue<Integer> q1 = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = q.size();
        
        for(int i =0; i<n/2; i++){
           q1.add(q.remove());
        }
        
        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q.remove());
        }
        while(!q.isEmpty()){
            ans.add(q.remove());
        }
        return ans;
    }
	
}
