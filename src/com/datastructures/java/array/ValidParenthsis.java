package com.datastructures.java.array;

import java.util.Stack;

public class ValidParenthsis {

    public static void main(String[] args) {
        ValidParenthsis validParenthsis = new ValidParenthsis();
        System.out.println(validParenthsis.isValid("{{}}[[]]()()"));
        System.out.println(validParenthsis.isValid("{{}}[[]]())"));
    }

    public boolean isValid(String s) {
        char[] cStr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c:cStr){
            if(c=='('){
                stack.push(')');
            }else if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

}
