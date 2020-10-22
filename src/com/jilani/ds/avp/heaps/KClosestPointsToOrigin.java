package com.jilani.ds.avp.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		
		int[][] points = {
				{1,3},
				{-2,2},
				{5,8},
				{0,1}
		};
		
		int k = 2;
		
		KClosestPointsToOrigin app = new KClosestPointsToOrigin();
		
		int[][] closest = app.kclosestToOrigin(points, k);

		for ( int i=0; i < closest.length; i++) {
			System.out.println("("+ closest[i][0] + "," + closest[i][1]+")");
		}
		
	}
	
	int[][] kclosestToOrigin(int[][] points, int k){
		List<Point> list = new ArrayList();
		
		PriorityQueue<Point> maxHeap = new PriorityQueue(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				return (int) (p2.dist-p1.dist);
			}
			
		});
		
		for ( int i=0; i < points.length; i++) {
			maxHeap.add(new Point(points[i][0], points[i][1]));
			if ( maxHeap.size() > k)
				maxHeap.poll();
		}
		
		int[][] res = new int[maxHeap.size()][2];
		
		int i = 0;
		while ( maxHeap.size() > 0 ) {
			Point p = maxHeap.poll();
			res[i][0] = p.x;
			res[i][1] = p.y;
			i++;
		}
		return res;
	}
	
	static class Point{
		int x;
		int y;
		long dist;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
			this.dist = x * x + y * y;
		}
	}

}
