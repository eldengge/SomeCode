package com.nsm.tree;

import com.nsm.stack.Mystack;

public class TestTree {
	public static TreeNode initTree(){
		TreeNode root = new TreeNode(1);
		root.setLeftChild(new TreeNode(2,new TreeNode(3),null));
		root.setRightChild(new TreeNode(4, new TreeNode(5), new TreeNode(6)));
		return root;
	}
	//先序遍历递归
	public static void preOrder1(TreeNode node){
		if(node!=null){
			System.out.println(node.getValue());
			preOrder1(node.getLeftChild());
			preOrder1(node.getRightChild());
		}
	}
	//中序遍历递归
	public static void inOrder1(TreeNode node){
		if(node!=null){
			inOrder1(node.getLeftChild());
			System.out.println(node.getValue());
			inOrder1(node.getRightChild());
		}
	}
	//后续遍历递归
	public static void postOrder1(TreeNode node){
		if(node!=null){
			postOrder1(node.getLeftChild());
			postOrder1(node.getRightChild());
			System.out.println(node.getValue());
		}
	}
	//先序遍历非递归
	public static void preOrder2(TreeNode root){
		if(root!=null){
			Mystack<TreeNode> stack = new Mystack<TreeNode>();
			stack.push(root);
			while(!stack.isEmpty()){
				TreeNode node = stack.pop();
				if(node!=null){
					System.out.println(node.getValue());
					stack.push(node.getRightChild());
					stack.push(node.getLeftChild());
				}
			}
		}
	}
	//中序遍历非递归
	public static void inOrder2(TreeNode root){
		Mystack<TreeNode> stack = new Mystack<TreeNode>();
		while(root!=null||!stack.isEmpty()){
			while(root!=null){
				stack.push(root);
				root=root.getLeftChild();
			}
			if(!stack.isEmpty()){
				TreeNode node = stack.pop();
				System.out.println(node.getValue());
				root=node.getRightChild();
			}
		}
	}
	//后序遍历非递归
	public static void postOrder2(TreeNode root){
		Mystack<TreeNode> stack = new Mystack<TreeNode>();
		TreeNode p = root;
		stack.push(p);
		stack.push(p);
		while(!stack.isEmpty()){
			p=stack.pop();
			if(!stack.isEmpty() && p.equals(stack.getTop())){
				if(p.getRightChild()!=null){
					stack.push(p.getRightChild());
					stack.push(p.getRightChild());
				}
				if(p.getLeftChild()!=null){
					stack.push(p.getLeftChild());
					stack.push(p.getLeftChild());
				}
			}else{
				System.out.println(p.getValue());
			}
		}
	}
}
