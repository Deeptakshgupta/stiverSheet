package com_stacks;

import java.util.Stack;

/*
 * Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), 
 * isFull() and an additional operation getMin() which should return the minimum element from the SpecialStack. 
 * Your task is to complete all the functions, using a stack data structure.
 */

public class stacksMinimum {

	private Stack<int[]> stack = new Stack<>();
	// to maintain the minimum element alongside the stack structure

	public void push(int x, Stack<Integer> s) {
		if (stack.isEmpty()) {
			stack.push(new int[] { x, x });
			return;
		}

		int currentMin = stack.peek()[1];
		stack.push(new int[] { x, Math.min(x, currentMin) });
	}

	public int pop(Stack<Integer> s) {
		int[] ans = stack.pop();
		return ans[0];
	}

	public int min(Stack<Integer> s) {
		return stack.peek()[1];
	}

	public boolean isFull(Stack<Integer> s, int n) {
		return stack.size() == n;
	}

	public boolean isEmpty(Stack<Integer> s) {
		return stack.size() == 0;
	}
}

/*
 * Complexity
 * 
 * Time Complexity : O(1), for all operations.
 * Space Complexity : O(n), Worst
 * case is that all the operations are push. In this case, there will be
 * O(2⋅n)=O(n)O(2 \cdot n) = O(n)O(2⋅n)=O(n) space used.
 */
