package com_stacks;

import java.util.Stack;

public class maxHistogramArea {

	 public static long getMaxArea(long hist[]) {
	        // Stack to store the indices of the histogram bars
	        Stack<Integer> stack = new Stack<>();
	        
	        long maxArea = 0;  // Variable to store the maximum area
	        int n = hist.length;
	        
	        // Traverse through all bars of the histogram
	        for (int i = 0; i < n; i++) {
	            // If this bar is smaller than the bar at the top of the stack, pop it
	            while (!stack.isEmpty() && hist[stack.peek()] > hist[i]) {
	                long height = hist[stack.pop()];
	                int width;
	            if (stack.isEmpty()) {
	                  // If the stack is empty, the rectangle can extend from the start (index 0) to the current index 'i'
	                 width = i;
	            } else {
	                 // If the stack is not empty, the rectangle extends from the next bar after the one at 'stack.peek()' to 'i - 1'
	                 width = i - stack.peek() - 1;
	            }
	                maxArea = Math.max(maxArea, height * width);
	            }
	            // Push the current index to the stack
	            stack.push(i);
	        }
	        
	        // Pop the remaining bars from the stack
	        while (!stack.isEmpty()) {
	            long height = hist[stack.pop()];
	            int width;
	        if (stack.isEmpty()) {
	             // If the stack is empty, the rectangle extends from the start (index 0) to the last index 'n-1'.
	             width = n;
	            } else {
	                 // If the stack is not empty, the rectangle extends from the next bar after 'stack.peek()' to the last index 'n-1'.
	          width = n - stack.peek() - 1;
	        }
	            
	            maxArea = Math.max(maxArea, height * width);
	        }
	        
	        return maxArea;
	    }
}
