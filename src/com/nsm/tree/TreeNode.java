package com.nsm.tree;

public class TreeNode {
	private Integer value;
	private TreeNode leftChild;
	private TreeNode  rightChild;
	
	public TreeNode(Integer value) {
		this.value = value;
	}

	public TreeNode(Integer value, TreeNode leftChild, TreeNode rightChild) {
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
}
