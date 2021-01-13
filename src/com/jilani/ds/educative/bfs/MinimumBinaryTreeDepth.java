package com.jilani.ds.educative.bfs;

import java.util.LinkedList;
import java.util.Queue;

class MinimumBinaryTreeDepth {
	public static int findDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int levelsize = queue.size();
			level++;
			for (int i = 0; i < levelsize; i++) {
				TreeNode curr = queue.poll();
				if (curr.left == null && curr.right == null) {
					return level;
				}
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}
		}
		return level;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
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
