package com_stacks;

import java.util.Stack;

/*
 * Given a string s consisting only of opening and closing parenthesis
 *  'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
NOTE: The length of the smallest valid substring ( ) is 2.
 */
public class validSubString {

	static int findMaxLen(String S) {
        // code here
           // code here
        Stack<Integer> s= new Stack<>();
        int ans=0;
        s.push(-1);
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(') s.push(i);
            else{
                
                if(!s.isEmpty()) 
                    s.pop();
            
                if(s.isEmpty())
                    s.push(i);
                else 
                    ans=Math.max(i-s.peek(),ans);
            }
        }
        return ans;
	}
	
}
