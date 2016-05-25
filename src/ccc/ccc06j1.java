package ccc;

import java.util.Scanner;

public class ccc06j1 {


	public static void main(String[] args) {
		int[][] cost={
				{461,431,420,0},
				{100, 57, 70, 0},
				{130, 160, 118, 0},
				{167, 266, 75, 0}
		};
		Scanner scan=new Scanner(System.in);
		int total=0;
		for(int i=0;i<4;i++){
			total+=cost[i][scan.nextInt()-1];
		}
		scan.close();
		System.out.println("Your total Calorie count is "+total+".");
		
	}

}
