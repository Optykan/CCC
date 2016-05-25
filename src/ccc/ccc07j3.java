package ccc;

import java.util.Scanner;

public class ccc07j3 {


	public static void main(String[] args) {
		int[] cases={100,500,1000,5000,10000,25000,50000,100000,500000,1000000};
		Scanner scan = new Scanner(System.in);
		int opened=scan.nextInt();
		double average=0;
		for(int i=0;i<opened;i++){
			cases[scan.nextInt()-1]=0;
		}
		for(int i=0;i<cases.length;i++){
			average+=cases[i];
		}
		average/=10-opened;
		if(scan.nextInt()>average){
			System.out.println("deal");
		}else{
			System.out.println("no deal");
		}
	}

}
