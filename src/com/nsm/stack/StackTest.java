package com.nsm.stack;


public class StackTest {
	public static void main(String[] args) {
		Mystack<Integer> stack = new Mystack<Integer>();
		for(int i=1;i<=10;i++){
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}
