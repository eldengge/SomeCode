package com.nsm.tree;

public class Test {
	public static void main(String[] args) {
		TreeNode root = TestTree.initTree();
		//TestTree.preOrder1(root);
//		TestTree.inOrder1(root);
		//TestTree.postOrder1(root);
//		TestTree.preOrder2(root);
//		TestTree.inOrder2(root);
		TestTree.postOrder2(root);
	}
}
