package com.jilani.ds.avp.binarysearch;

public class RotationCount {

	public static void main(String[] args) {

		RotationCount app = new RotationCount();
		//int[] arr = { 4,5,6,7,1,2,3};
		//int[] arr = { 5,6,7,1,2,3,4};
		//int[] arr = { 6,7,1,2,3,4,5};
		//int[] arr = { 7,1,2,3,4,5,6};
		int[] arr = { 1,2,3,4,5,6,7};
		System.out.println(app.rotationCount(arr));
	}
	
	int rotationCount(int[] arr) {
		
		if ( arr == null || arr.length < 2)
			return 0;
		
		int index = rotationcountutil(arr, 0, arr.length-1);
		System.out.println(" index = " + index);
		return arr.length - index;
	}
	
	int rotationcountutil(int[] arr, int l, int r) {
		

		// If array is not rotated
		if ( arr[l] <= arr[r])
			return arr.length;
		
		while ( l < r) {
			
			int mid = l + (r-l)/2;
			
			if ( arr[mid] > arr[mid+1])
				return mid+1;
			else if ( arr[0] <= arr[mid])
				l = mid +1;
			else
				r = mid;
		}
		return l;
	}

}
