package com.leetcode.microsoft;
class ReverseAString {
	
	public static void main(String[] args) {
		String s = "Hello World!";
		char[] c = s.toCharArray();
	
		for ( int i=0; i < c.length; i++)
			System.out.print(c[i]+" ");
		System.out.println();
		ReverseAString app = new ReverseAString();
		app.reverseString(c);
		
		System.out.println(" After reverse");
		for ( int i=0; i < c.length; i++)
			System.out.print(c[i]+" ");
		System.out.println();
		
	}
    public void reverseString(char[] s) {
        char temp;
        for ( int i=0, j = s.length-1; i < j; i++, j--){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}