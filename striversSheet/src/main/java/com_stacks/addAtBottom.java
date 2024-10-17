package com_stacks;

import java.util.Stack;

/*
 * Implement a method to insert an element at its bottom without using any other data structure.
 */


/*
 * Use Recusrive call pop the element out :-
 * 
 * if(st==null)
 * 	st.push(x);
 * 
 *  x= st.pop();
 *  
 *  recursiceCall(st);
 *  st.push(x);
 */
public class addAtBottom {

	 static Stack<Integer> recur(Stack<Integer> S, int N)
	    {
	        // If stack is empty
	        if (S.size() == 0)
	            S.push(N);
	       
	        else {
	       
	            // Stores the top element
	            int X = S.peek();
	       
	            // Pop the top element
	            S.pop();
	       
	            // Recurse with remaining elements
	            S = recur(S, N);
	       
	            // Push the previous
	            // top element again
	            S.push(X);
	        }
	        return S;
	    }
	       
	    // Function to insert an element
	    // at the bottom of stack
	    static void insertToBottom(Stack<Integer> S, int N)
	    {
	       
	        // Recursively insert
	        // N at the bottom of S
	        S = recur(S, N);
	       
	        // Print the stack S
	        while (S.size() > 0) {
	            System.out.print(S.peek() + " ");
	            S.pop();
	        }
	    }
	     
	    public static void main(String[] args) {
	        // Input
	        Stack<Integer> S = new Stack<Integer>();
	        S.push(5);
	        S.push(4);
	        S.push(3);
	        S.push(2);
	        S.push(1);
	      
	        int N = 7;
	      
	        insertToBottom(S, N);
	    }
	
	
}



