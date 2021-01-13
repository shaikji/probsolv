package com.jilani.ds.educative.bfs;

import java.util.LinkedList;
import java.util.Queue;

class LevelOrderSuccessor {
	public static TreeNode findSuccessor(TreeNode root, int key) {
		if (root == null)
			return root;
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();

			if (curr.left != null)
				queue.add(curr.left);
			if (curr.right != null)
				queue.add(curr.right);

			if (curr.val == key) {
				break;
			}
		}
		return queue.peek();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
		if (result != null)
			System.out.println(result.val + " ");
		result = LevelOrderSuccessor.findSuccessor(root, 9);
		if (result != null)
			System.out.println(result.val + " ");
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
