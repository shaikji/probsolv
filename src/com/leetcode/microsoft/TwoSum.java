package com.leetcode.microsoft;

import java.util.HashMap;

class TwoSum {
	
	public static void main(String[] args) {
		TwoSum app = new TwoSum();
		int[] res = app.twoSum(new int[] {2,7,11,15}, 9);
		System.out.println(res[0] + " " + res[1]);
	}
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap();
        int complement;
        
        for ( int i=0; i < nums.length; i++){
            complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{-1,-1};
        
    }
}