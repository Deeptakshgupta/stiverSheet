package com_stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 A stack permutation is a permutation of objects in the given input queue which is done by transferring elements
  from the input queue to the output queue with the help of a stack and the built-in push and pop functions.
 
 
Input: arr1[] = [ 1, 2, 3 ] , arr2[] = [ 2, 1, 3 ]
Output: YES
Explanation: 
push 1 from input to stack
push 2 from input to stack
pop 2 from stack to output
pop 1 from stack to output
push 3 from input to stack
pop 3 from stack to output


Input: arr1[] = [ 1, 2, 3 ] , arr2[] = [ 3, 1, 2 ]
Output: Not Possible


 
 */
/*
 The idea to start iterating on the input array and storing its element one by one in a stack 
 and if the top of our stack matches with an element in the output array we will pop that element 
 from the stack and compare the next element of the output array with the top of our stack if again 
 it matches then again pop until our stack isn’t empty
 Avoid unnecessary comparisons by breaking out of the loop early. If we encounter an element in the
  input array that is already in the output array, we know that it cannot be a valid stack permutation, 
  so we can return false immediately. 


 */
public class StackPermutations {

	public static boolean checkStackPermutation(List<Integer> input, List<Integer> output) {
		Stack<Integer> s = new Stack<>();
		int j = 0;

		for (int i = 0; i < input.size(); i++) {
			s.push(input.get(i));

			while (!s.empty() && s.peek() == output.get(j)) {
				s.pop();
				j++;
			}

		}

		if (s.isEmpty())
			return true;
		return false;
	}

	public static int isStackPermutation(int n, int[] ip, int[] op) {
		Stack<Integer> s = new Stack<>();
		int j = 0;

		for (int i = 0; i < ip.length; i++) {
			s.push(ip[i]);

			while (!s.empty() && s.peek() == op[j]) {
				s.pop();
				j++;
			}

		}

		if (s.isEmpty())
			return 1;
		return 0;
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));
		List<Integer> output = new ArrayList<>(Arrays.asList(8, 7, 6, 5, 4));

		if (input.size() != output.size()) {
			System.out.println("Not Possible");
			return;
		}

		if (checkStackPermutation(input, output)) {
			System.out.println("Yes");
		} else {
			System.out.println("Not Possible");
		}
	}
}