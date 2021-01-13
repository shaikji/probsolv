package com.jilani.ds.educative.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LevelOrderTraversal {

	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (null == root)
			return result;

		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();

			ArrayList<Integer> currentlevel = new ArrayList();

			for (int i = 0; i < levelSize; i++) {
				TreeNode curr = queue.poll();
				currentlevel.add(curr.val);
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}
			result.add(currentlevel);
		}

		return result;
	}

	public static List<List<Integer>> traverse2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (null == root)
			return result;

		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		queue.add(null);
		ArrayList<Integer> row = new ArrayList();
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();

			if (curr == null) {
				if (!queue.isEmpty()) {
					queue.add(null);
				}
				result.add(new ArrayList(row));
				row.clear();
			} else {
				row.add(curr.val);
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}

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
		List<List<Integer>> result = LevelOrderTraversal.traverse(root);
		System.out.println("Level order traversal: " + result);
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
