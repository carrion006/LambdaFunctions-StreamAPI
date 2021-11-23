package com.pack.week3;

interface Max{
	public int findGreatestNum(int num1, int num2);
}

public class Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Max maxFinder = (num1, num2) -> (num1>num2)?num1:num2;
		int result = maxFinder.findGreatestNum(50, 120);
		System.out.println("The greatest no is " + result);
	}

}
