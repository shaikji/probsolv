package com.jilani.ds.educative.bfs;
import java.util.*;

class LevelAverage {
  public static List<Double> findLevelAverages(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null)
    	return result;
    
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    while ( !queue.isEmpty()) {
    	int levelsize = queue.size();
    	int levelsum = 0;
    	
    	for ( int i=0; i < levelsize; i++) {
    		TreeNode curr = queue.poll();
    		levelsum += curr.val;
    		if ( curr.left != null)
    			queue.add(curr.left);
    		if (curr.right != null)
    			queue.add(curr.right);
    	}
    	
    	result.add((double)levelsum / levelsize);
    }
    
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<Double> result = LevelAverage.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
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
