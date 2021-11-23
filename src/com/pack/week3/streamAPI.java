package com.pack.week3;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/*
 *lambda function
 *Stream API
 *Functional Interface
 *Local Date & Time 
 */

interface MaxFinder{
	public int max(int num1, int num2);
}

public class streamAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Lambda Function");
		MaxFinder mf = (a,b) -> {return a>b ? a : b;};
//		MaxFinder mf1 = (a,b) -> a>b?a:b;
		System.out.println("Greatest Number is: " + mf.max(85,60));
		System.out.println();
//		BiFunction
		System.out.println("BiFunction Operations");
		BiFunction<Integer, Integer, Integer> add = (a,b) -> a + b;
		System.out.println("Addition = "+ add.apply(20, 5));
		BiFunction<Integer, Integer, Integer> multiply = (a,b) -> a * b;
		System.out.println("Product = "+ multiply.apply(20, 5));
		BiFunction<Integer, Integer, Integer> greatest = (a,b) -> {return a>b ? a : b;};
		System.out.println("Greatest No = " + greatest.apply(80, 81));
		System.out.println();
//		Stream API
		System.out.println("Stream API");
		List<Integer> numList = Arrays.asList(78,14,14,10,5,50,45,65);
		System.out.println("Actual List:"+numList);
		System.out.println("Addition = " + numList.stream().reduce((a, b) -> a+b).get());
		System.out.println("Count of Distinct Entry = " + numList.stream().distinct().count());
		System.out.println("Printing Distinct Entry ");  
		numList.stream().distinct().forEach(System.out::println);
		System.out.println("Printing distinct first four entries from array");
		numList.stream().distinct().limit(4).forEach(System.out::println);
		
		System.out.println("length of the name ");
		List<String> nameList = Arrays.asList("Hem","Sam","Pete","Rook","");
		nameList.stream().map((name) -> {return "Name:"+name+" Length:"+name.length();}).forEach(System.out::println);
		
		System.out.println("No of blank names: ");
		System.out.print(nameList.stream().filter((name) -> name.isEmpty()).count());
	}

}
