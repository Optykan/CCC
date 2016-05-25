package ccc;

import java.util.Scanner;
public class CCC14S3 {

	public static void main(String[] args) {
		boolean modified=true;
		
		Scanner scan = new Scanner(System.in);
		int rows=scan.nextInt();
		int cols =scan.nextInt();
		
		int[][] input = new int[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				input[i][j]=scan.nextInt();
			}
		}
		int[] sort= new int[scan.nextInt()];
		for (int i=0;i<sort.length;i++){
			sort[i]=scan.nextInt();
		}
		scan.close();
		for (int i=0;i<sort.length;i++){
			//sort command #
			modified=true;
			while(modified){
				modified=false;
				for (int j = 0; j < rows - 1; j++) {
					if (input[j][sort[i]-1] > input[j + 1][sort[i]-1]) {
						for(int k=0;k<cols;k++){
							int temp=input[j][k];
							input[j][k]=input[j + 1][k];
							input[j + 1][k]=temp;
						}
						modified=true;
					}
				}
				if (!modified)
					break;
			}
		}
		for(int l=0;l<rows;l++){
			for(int j=0;j<cols;j++){
				System.out.print(input[l][j]+" ");
			}
			System.out.print("\n");
		}

	}

}
