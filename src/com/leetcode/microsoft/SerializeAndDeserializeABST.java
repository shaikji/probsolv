package com.leetcode.microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeABST {

	public static void main(String[] args) {
		SerializeAndDeserializeABST app = new SerializeAndDeserializeABST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		System.out.println(" Original Tree");
		printTree(root);
		StringBuffer sbr = new StringBuffer();
		app.serialize(root, sbr);
		TreeNode decoded = app.deserialize(sbr.toString());
		System.out.println(" Decoded Tree");
		printTree(decoded);
	}

	public static void printTree(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			printTree(root.left);
			printTree(root.right);
		}
	}

	// Encodes a tree to a single string.
	public void serialize(TreeNode root, StringBuffer sbr) {

		if (root != null) {
			sbr.append(root.val);
			sbr.append(" ");
			serialize(root.left, sbr);
			serialize(root.right, sbr);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<Integer> queue = new LinkedList();

		String[] arr = data.split("\\s+");
		for (String s : arr) {
			queue.add(Integer.parseInt(s));
		}
		return deser_util(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private TreeNode deser_util(Queue<Integer> queue, int min, int max) {

		if ( queue.isEmpty())
			return null;
		int val = queue.peek();
		if (val < min && val > max) {
			return null;
		}
		queue.poll();
		TreeNode node = new TreeNode(val);
		node.left = deser_util(queue, min, node.val);
		node.right = deser_util(queue, node.val, max);
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