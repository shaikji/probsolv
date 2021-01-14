package com.leetcode.microsoft;

public class NumberToEnglishWords {

	public static void main(String[] args) {
		NumberToEnglishWords app = new NumberToEnglishWords();
		System.out.println(app.numberToWords(1234));
	}

	public String numberToWords(int num) {
		String result = "";
		if (num == 0)
			return "Zero";
		int billions_part = num / 1000000000;
		num = num % 1000000000;
		int millions_part = num / 1000000;
		num = num % 1000000;
		int thousands_part = num / 1000;
		num = num % 1000;
		int rest = num;
		if (billions_part != 0)
			result = three(billions_part) + " Billion ";
		if (millions_part != 0)
			result += three(millions_part) + " Million ";
		if (thousands_part != 0)
			result += three(thousands_part) + " Thousand ";
		result += three(rest);
		return result.trim();
	}

	private String three(int num) {
		String result = "";
		if (num == 0)
			return result;
		int hundreds_part = num / 100;
		int rest = num % 100;
		if (hundreds_part != 0 && rest != 0)
			result += one(hundreds_part) + " Hundred " + two(rest);
		else if (hundreds_part != 0 && rest == 0)
			result += one(hundreds_part) + " Hundred";
		else if (hundreds_part == 0 && rest != 0)
			result += two(rest);
		return result;
	}

	private String two(int num) {
		String res = "";

		if (num == 0)
			return res;
		if (num < 10)
			res += one(num);
		else if (num < 20)
			res += lessThan20(num);
		else {
			int tens_part = num / 10;
			int rest = num % 10;

			res += tens(tens_part);
			if (rest != 0)
				res += (" " + one(rest));
		}
		return res;
	}

	private String one(int num) {
		String res = "";
		switch (num) {
		case 1:
			res = "One";
			break;
		case 2:
			res = "Two";
			break;
		case 3:
			res = "Three";
			break;
		case 4:
			res = "Four";
			break;
		case 5:
			res = "Five";
			break;
		case 6:
			res = "Six";
			break;
		case 7:
			res = "Seven";
			break;
		case 8:
			res = "Eight";
			break;
		case 9:
			res = "Nine";
			break;
		default:
			break;
		}
		return res;
	}

	private String tens(int num) {
		String res = "";
		switch (num) {
		case 1:
			res = "Ten";
			break;
		case 2:
			res = "Twenty";
			break;
		case 3:
			res = "Thirty";
			break;
		case 4:
			res = "Forty";
			break;
		case 5:
			res = "Fifty";
			break;
		case 6:
			res = "Sixty";
			break;
		case 7:
			res = "Seventy";
			break;
		case 8:
			res = "Eighty";
			break;
		case 9:
			res = "Ninety";
			break;
		default:
			break;
		}
		return res;
	}

	private String lessThan20(int num) {
		String res = "";
		switch (num) {
		case 10:
			res = "Ten";
			break;
		case 11:
			res = "Eleven";
			break;
		case 12:
			res = "Twelve";
			break;
		case 13:
			res = "Thirteen";
			break;
		case 14:
			res = "Fourteen";
			break;
		case 15:
			res = "Fifteen";
			break;
		case 16:
			res = "Sixteen";
			break;
		case 17:
			res = "Seventeen";
			break;
		case 18:
			res = "Eighteen";
			break;
		case 19:
			res = "Nineteen";
			break;
		default:
			break;
		}
		return res;
	}

}
