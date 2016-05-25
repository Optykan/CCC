package ccc;

import java.util.Scanner;
public class CCC14J5 {
	private static int search(String arr[], String needle){
		int upper = arr.length;
		for (int i=0;i<upper;i++){
			if (arr[i].equals(needle))
				return i;
		}
		return -1;
	}
	public static void main(String[] args){
		boolean good=true;
		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();
		if (max % 2 >0 ){
			System.out.println("bad");
			System.exit(0);
		}
		String[] a, b= new String[max];
		String wait = scan.nextLine();
		a=scan.nextLine().split(" ");
		b=scan.nextLine().split(" ");
		scan.close();
		
		for (int j=0;j<max;j++){
			int compare = search(a, b[j]);
			if (compare <0){
				System.out.println("bad");
				System.exit(0);
			}
			if(!a[j].equals(b[compare])||a[j].equals(b[j])){
				good= false;
				break;
			}
		}
		if (good)
			System.out.println("good");
		else
			System.out.println("bad");
	}

}
