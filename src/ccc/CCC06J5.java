package ccc;

import java.util.Scanner;
public class CCC06J5 {
	public static int[][] layout = new int[8][8];
	
	private static void display(){
		for(int i=0;i<8;i++){
			for (int j=0;j<8;j++){
				System.out.print(layout[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	private static void tally(){
		int white=0;
		int black=0;
		
		for (int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if (layout[i][j]==1){
					white+=1;
				}else if (layout[i][j]==2){
					black+=1;
				}
			}
		}
		System.out.print(black);
		System.out.println(" "+white);
	}
	
	private static void fill (int ox, int oy, int x, int y, int player, int dir){
		switch(dir){
		case 1: 
			for(int i=1;i<=y-oy;i++){
				layout[x][y+i]=player;
				System.out.println("filled "+i);
			}
			break;
		case 2: 
			for(int i=1;i<=x-ox;i++){
				layout[x+i][y+i]=player;
				System.out.println("filled "+i);
			}
			break;
		case 3: 
			for(int i=1;i<=x-ox;i++){
				layout[x+i][y]=player;
				System.out.println("filled "+i);
			}
			break;
		case 4: 
			for(int i=1;i<=y-oy;i++){
				layout[x+i][y-i]=player;
				System.out.println("filled "+i);
			}
			break;
		case 5: 
			for(int i=1;i<=y-oy;i++){
				layout[x][y-i]=player;
				System.out.println("filled "+i);
			}
			break;
		case 6: 
			for(int i=1;i<=y-oy;i++){
				layout[x-i][y-i]=player;
				System.out.println("filled "+i);
			}
			break;
		case 7: 
			for(int i=1;i<=ox-x;i++){
				layout[x-i][y]=player;
				System.out.println("filled "+i);
			}
			break;
		case 8: 
			for(int i=1;i<=y-oy;i++){
				layout[x-i][y+i]=player;
			}
			break;
		}
	}
	private static void direction(int ox, int oy, int player){
		//begin propagation around the x and y coordinates of the play 
		//8  1  2
		//7  x  3
		//6  5  4
		
		for(int i=0;i<8;i++){
			if (oy+i==8)
				break;
			if (layout[ox][oy+i]==player){
				fill(ox, oy, ox, oy+i, player, 1);
				break;
			}
		}
		for(int i=0;i<8;i++){
			if(ox+i==8 || oy+i==8)
				break;
			if (layout[ox+i][oy+i]==player){
				fill(ox, oy, ox+i, oy+i, player, 2);
				break;
			}
		}
		for(int i=0;i<8;i++){
			if (ox+i==8)
				break;
			if (layout[ox+i][oy]==player){
				fill(ox, oy, ox+i,oy, player, 3);
				break;
			}
		}
		for(int i=0;i<8;i++){
			if(ox+i==9 || oy-i<0)
				break;
			if (layout[ox+i][oy-i]==player){
				fill(ox, oy, ox+i, oy-i, player, 4);
				break;
			}
		}
		//5
		for(int i=0;i<8;i++){
			if(oy-i<0)
				break;
			if (layout[ox][oy-i]==player){
				fill(ox, oy, ox, oy-i, player, 5);
				break;
			}
		}
		for(int i=0;i<8;i++){
			if(ox-i<0 || oy-i==0)
				break;
			if (layout[ox-i][oy-i]==player){
				fill(ox, oy, ox-i, oy-i, player, 6);
				break;
			}
		}
		for(int i=0;i<8;i++){
			if(ox-i<0)
				break;
			if (layout[ox-i][oy]==player){
				fill(ox, oy, ox-i, i, player, 7);
				break;
			}
		}
		for(int i=0;i<8;i++){
			if(ox-i<0 || oy+i==8)
				break;
			if (layout[ox-i][oy+i]==player){
				fill(ox, oy, ox-i, oy+i, player, 8);
				break;
			}
		}
	}
	
	/*
	private static void recur(int x, int y, int player, int dir){
		//player is 1 or 2
		//override is 2 or 1
		//if player is 1 then override is 2
		// black is 2
		//white is 1
		int override=(player%2)+1;
		//8  1  2
		//7  x  3
		//6  5  4


		switch(dir){
			case 1:
				if (y+1<8){
					if(layout[x][y+1]==override){
						//if layout x, y is equal to the enemy then reset it
						layout[x][y+1]=player;
						direction(x, y+1, player, dir);
						break;
					}
				}
				break;
			case 2:
				if (x+1<8 && y+1<8){
					if(layout[x+1][y+1]==override){
						layout[x+1][y+1]=player;
						direction(x+1, y+1, player, dir);
						break;
					}
				}
				break;
			case 3:
				if(x+1<8){
					if(layout[x+1][y]==override){
						layout[x+1][y]=player;
						direction(x+1, y, player, dir);
						break;
					}
				}
				break;
			case 4:
				if(x+1<8 && y-1>=0){
					if(layout[x+1][y-1]==override){
						layout[x+1][y-1]=player;
						direction(x+1, y-1, player, dir);
						break;
					}
				}
				break;
			case 5:
				if(y-1>=0){
					if(layout[x][y-1]==override){
						layout[x][y-1]=player;
						direction(x, y-1, player, dir);
						break;
					}
				}
				break;
			case 6:
				if(x-1>=0 && y-1 >=0){
					if(layout[x-1][y-1]==override){
						layout[x-1][y-1]=player;
						direction(x-1, y-1, player, dir);
						break;
					}
				}
				break;
			case 7:
				if(x-1>=0){
					if(layout[x-1][y]==override){
						layout[x-1][y]=player;
						direction(x-1, y, player, dir);
						break;
					}
				}
				break;
			case 8:
				if(x-1>=0 && y+1<8){
					if(layout[x-1][y+1]==override){
						layout[x-1][y+1]=player;
						direction(x-1, y+1, player, dir);
						break;
					}
				}
				break;
		}		
	}*/
	
	private static void run(int x, int y, int player){
		layout[x][y]=player;
		direction(x, y, player);
	}
	
	public static void main (String[] args){
		
		Scanner scan = new Scanner(System.in);
		char layoutSpec= scan.next(".").charAt(0);
		
		if(layoutSpec=='a'){
			int[][] loadLayout={
					{0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0},
					{0,0,0,1,2,0,0,0},
					{0,0,0,2,1,0,0,0},
					{0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0}};
			layout=loadLayout;
		}
		else if (layoutSpec=='b'){
			int[][] loadLayout={
					{2,0,0,0,0,0,0,1}, //1
					{0,2,0,0,0,0,1,0}, //2 
					{0,0,2,0,0,1,0,0}, //3
					{0,0,0,2,1,0,0,0},
					{0,0,0,1,2,0,0,0},
					{0,0,1,0,0,2,0,0},
					{0,1,0,0,0,0,2,0},
					{1,0,0,0,0,0,0,2}};
			layout=loadLayout;
		}
		else{
			int[][] loadLayout={
					{0,0,2,2,1,1,0,0},
					{0,0,2,2,1,1,0,0},
					{0,0,2,2,1,1,0,0},
					{0,0,2,2,1,1,0,0},
					{0,0,2,2,1,1,0,0},
					{0,0,2,2,1,1,0,0},
					{0,0,2,2,1,1,0,0},
					{0,0,2,2,1,1,0,0}};
			layout=loadLayout;
		}
		display();
		int pairs=scan.nextInt();
		for(int i=1;i<=pairs;i++){
		//for the number of pairs(moves)
			//black goes first(odd)
			//white goes second(even)
			int rows=scan.nextInt()-1;
			int cols=scan.nextInt()-1;
			int player=(i%2)+1;
			//1 mod 2 is 1+1=2 (black)
			//2 mod 2 is 0+1=1 (white)
			run(rows, cols, player);
			display();
			
		}
		scan.close();
		tally();
		
		
		
	}
}
