package com.jilani.ds.educative.twopointer;
import java.util.*;

class TripletSumCloseToTarget {
	
	public static void main(String[] args) {

		System.out.println(" Triplet sum close to target "  + searchTriplet(new int[] {-2, 0, 1, 2}, 2));
		System.out.println(" Triplet sum close to target "  + searchTriplet(new int[] {-3, -1, 1, 2}, 1));
		System.out.println(" Triplet sum close to target "  + searchTriplet(new int[] {1, 0, 1, 1}, 100));


	}

  public static int searchTriplet(int[] arr, int targetSum) {

    if ( arr == null || arr.length < 3)
      return -1;

    Arrays.parallelSort(arr);
    int targetDiff = 0;
    int smallestDiff = Integer.MAX_VALUE;
    int left =0;
    int right = 0;

    for ( int i=0; i < arr.length-2; i++){

      left = i+1;
      right = arr.length-1;

      while ( left < right){
        targetDiff = targetSum - arr[i] - arr[left]- arr[right];

        // If targetDiff == 0, this means, targetSum == triplet, we need to return this triplet 
        // This means that there is one triplet whose sum is equal to targetSum
        // So the difference is zero. Return the triplet sum.
        if ( targetDiff == 0 )
          return targetSum;

        if (Math.abs(targetDiff) == Math.abs(smallestDiff)) {
          // You have two triplets that qualify for the closest triplet.
          // We need to choose a triplet whose sum is smallest.
          // Triplet sum will be smaller if the targetDiff is higher.
          if ( targetDiff > smallestDiff){
            smallestDiff = targetDiff;
          }
        } else if ( Math.abs(targetDiff) < Math.abs(smallestDiff)){
          smallestDiff = targetDiff;
        } 
        // else, target diff is higher, ignore. Now move to left or right.

        if ( targetDiff > 0 )
          left++;
        else
          right--;
      }
    }
    return targetSum - smallestDiff;
  }
}