package com_stacks;

import java.util.Queue;
import java.util.Stack;

/*
 * Reverse the givem q
  1.) We can use Recursion as we did for stacks
  2.) Use Auxillary data structure to store and 
  then add in queue again
   
 */
public class reverseQueue {
/** Stackoverflow error   **/
/*
 The risk of stack overflow in recursive queue reversal in Java is that the 
 recursive function calls can exceed the maximum stack size, leading to a
  StackOverflowError. This occurs when the queue is too large and the recursive 
  function calls exceed the maximum stack depth .
 */
	public Queue<Integer> rev(Queue<Integer> q){
        //add code here.
        if(q.isEmpty())
            return q;
        int x = q.poll();
        rev(q);
        q.add(x);
        return q;
    }
 
 
	 public Queue<Integer> rev1(Queue<Integer> queue){
	        //add code here.
	       Stack<Integer> stack = new Stack<>();
	     
	        while(queue.size() > 0) {
	           stack.push(queue.poll());
	        }
	        while(stack.size() > 0) {
	           queue.add(stack.pop());
	        }
	        return queue;
	    }
	 
}
