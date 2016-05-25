package ccc;

import java.util.Scanner;

public class mockccc14s1 {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input=scan.nextLine();
		String needle=scan.nextLine();
		scan.close();
		
		input=new StringBuilder(input).reverse().toString();
		
		int index=input.indexOf(needle);
		
		System.out.println(index!=-1? input.length()-index : "-1");
	}

}
