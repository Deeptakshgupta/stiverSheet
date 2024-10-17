package com_stacks;

import java.util.Stack;

/*
 * the task is to sort it such that the top of the stack has the greatest element.
 
 for sorting we have to pop every element and then push each element by checking whole stack(using recursion)
 
 But also we have to maintain the sorted stack such that top element gives the largest element
 
 */

public class sortStackUsingRecursion {

	public Stack<Integer> sort(Stack<Integer> s) {
		if (s.empty() == true) {
			return s;
		}

		// Remove the top element
		int top = s.peek();
		s.pop();
		// Recursion for the remaining elements in the stack
		sort(s);
		// Insert the popped element back in the sorted stack
		sortedInsert(s, top);
		return s;
	}

	/*
	 * public Stack<Integer> sort(Stack<Integer> s) { // Base case: If the stack is
	 * empty, return the stack List<Integer> ans =
	 * s.stream().collect(java.util.stream.Collectors.toList()); // Insert the
	 * popped element back into the sorted stack s = new Stack<Integer>();
	 * 
	 * for( int i : ans) sortedInsert(s, i);
	 * 
	 * return s; }
	 */

	public static void sortedInsert(Stack<Integer> stack, int current) {
		if (stack.empty() == true || current > stack.peek()) {
			stack.push(current);
			return;
		}

		// Remove the top element
		int top = stack.peek();
		stack.pop();
		// Recursion for the remaining elements in the stack
		sortedInsert(stack, current);
		// Insert the popped element back in the stack
		stack.push(top);
	}

}
