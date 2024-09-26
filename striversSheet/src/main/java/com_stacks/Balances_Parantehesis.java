package com_stacks;

import java.util.Stack;

/*
 * Given an expression string x. Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.
For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(]).

Note: The driver code prints "balanced" if function return true, otherwise it prints "not balanced".
 */

public class Balances_Parantehesis {


    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> st = new Stack<>();
        
        for( Character c:x.toCharArray()){
            if(c=='(')
                st.push(')');
            else if(c=='[')
                st.push(']');
            else if(c=='{')
                st.push('}');
            else if (st.isEmpty() || st.pop()!=c)
                return false;
        }
        return st.isEmpty();
    }
}
