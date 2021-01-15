package com.leetcode.microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeABinaryTree {
	
	public static void main(String[] args) {
		SerializeAndDeserializeABinaryTree app = new SerializeAndDeserializeABinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(" Original Tree");
		printTree(root);
		TreeNode decoded = app.deserialize(app.serialize(root));
		System.out.println(" Decoded Tree");
		printTree(decoded);
	}
	
	public static void printTree(TreeNode root) {
		if ( root != null) {
			System.out.println(root.val);
			printTree(root.left);
			printTree(root.right);
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		if (root == null)
			return "null";
		String ans = root.val + "," + serialize(root.left) + "," + serialize(root.right);
		// System.out.println(ans);
		return ans;

	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> queue = new LinkedList();
		queue.addAll(Arrays.asList(data.split(",")));
		return deser_util(queue);
	}

	private TreeNode deser_util(Queue<String> queue) {

		String text = queue.poll();
		if (text.equals("null"))
			return null;
		TreeNode node = new TreeNode(Integer.valueOf(text));
		node.left = deser_util(queue);
		node.right = deser_util(queue);
		return node;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));