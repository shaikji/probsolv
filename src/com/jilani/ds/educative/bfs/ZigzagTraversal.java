package com.jilani.ds.educative.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigzagTraversal {
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);
		int levelsize = 0;
		boolean leftToRight = true;

		while (!queue.isEmpty()) {
			levelsize = queue.size();
			LinkedList<Integer> currentrow = new LinkedList();

			for (int i = 0; i < levelsize; i++) {
				TreeNode curr = queue.poll();
				if (leftToRight)
					currentrow.add(curr.val);
				else
					currentrow.add(0, curr.val);

				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}

			result.add(currentrow);
			leftToRight = !leftToRight;
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = ZigzagTraversal.traverse(root);
		System.out.println("Zigzag traversal: " + result);
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
