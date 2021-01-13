package com.leetcode.microsoft;
class IntegerToRoman {
	
	public static void main(String[] args) {
		
		System.out.println(intToRoman(1234));
	}
    static public String intToRoman(int n) {
        
    	String[] thousands = { "", "M","MM","MMM"};
    	String[] hundreds = { "", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    	String[] tens = { "", "X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    	String[] units = { "", "I","II","III","IV","V","VI","VII","VIII","IX"};
    	
    	return thousands[n/1000]+
    			hundreds[(n%1000)/100]+
    			tens[(n%100)/10] +
    			units[n%10];
    }
}