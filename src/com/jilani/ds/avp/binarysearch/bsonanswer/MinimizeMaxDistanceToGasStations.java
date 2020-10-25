package com.jilani.ds.avp.binarysearch.bsonanswer;

public class MinimizeMaxDistanceToGasStations {

	public static void main(String[] args) {
		
		int[] stations = { 1,2,3,4,5,6,7,8,8,9};
		MinimizeMaxDistanceToGasStations app = new MinimizeMaxDistanceToGasStations();
		double maxDist = app.minmaxGasDist(stations, 9);

	}
	
	 public double minmaxGasDist(int[] stations, int K) {
	        
	        if ( stations == null || stations.length == 0 || K <= 0)
	            return -1;
	        
	        int min = 0;
	        int max = stations[stations.length-1] - stations[0];
	        double l = min;
	        double r = max;
	        double best = 0.0;
	        while ( l < r ){
	            
	            double mid = l + (r-l)/2.0;
	            
	            if (isPossible(stations, mid, K)){
	                best = mid;
	                r = mid;
	            } else {
	                l = mid;
	            }
	        }
	        
	        return best;
	        
	    }
	    
	    public boolean isPossible(int[] stations, double dist, int K) {
	        
	        int num_needed=0;
	        
	        for ( int i=1; i < stations.length-1; i++){
	            num_needed += Math.floor((stations[i] - stations[i-1])/dist);
	        }
	        
	        return num_needed <= K;
	    }

}

/*
 * 
 * On a horizontal number line, we have gas stations at positions stations[0],
 * stations[1], ..., stations[N-1], where N = stations.length.
 * 
 * Now, we add K more gas stations so that D, the maximum distance between
 * adjacent gas stations, is minimized.
 * 
 * Return the smallest possible value of D.
 * 
 * Example:
 * 
 * Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9 Output: 0.500000
 * Note:
 * 
 * stations.length will be an integer in range [10, 2000]. stations[i] will be
 * an integer in range [0, 10^8]. K will be an integer in range [1, 10^6].
 * Answers within 10^-6 of the true value will be accepted as correct.
 */
