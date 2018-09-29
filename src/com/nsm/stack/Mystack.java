package com.nsm.stack;

public class Mystack <E>{
	
	private Integer length;
	
	private stackNode<E> top;
	
	public Mystack(){
	}
	
	public void push(E value){
		stackNode<E> temp;
		if(top == null){
			temp = new stackNode<E>(value);
			top = temp;
			length = 1;
		}else{
			temp = new stackNode<E>(value);
			temp.next = top;
			top = temp;
			++length;
		}
	}
	
	public E pop(){
		stackNode<E> temp;
		if(this.isEmpty()){
			throw new RuntimeException("栈空");
		}else{
			temp = top;
			top = top.next;
			--length;
		}
		return temp.value;
	}
	
	public E getTop(){
		return this.top.value;
	}
	
	public boolean isEmpty(){
		return this.length == 0;
	}
		
	private class stackNode<T>{
		
		private T value;
		
		private stackNode<T> next;
		
		public stackNode(T value){
			this.value = value;
		}
	}

	public Integer getLength() {
		return length;
	}
	
}
