package ccc;

import java.util.Scanner;

public class CCC15J3 {
	public static char[] vowels="aeiou".toCharArray();
	public static char[] key = "aaeeeiiiiooooouuuuuuu".toCharArray();
	public static char[] noV = "bcdfghjklmnpqrstvwxyz".toCharArray();
	
	private static int loc (char let){
		for (int i=0;i<21;i++){
			if (let==noV[i])
				return i;
		}
		return -1;
	}
	private static char next (char let){
		if (let=='z')
			return 'z';
		else{
			for (int i=0;i<21;i++){
				if (let==noV[i])
					return noV[i+1];
			}
		}
		return let;
	}
	private static String rov (char cons){
		String assemble="";
		if (cons=='z')
			return "zuz";
		assemble+=cons;
		assemble+=key[loc(cons)];
		assemble+=next(cons);
		return assemble;
	}
	private static boolean isVowel (char in){
		for (int i=0;i<5;i++){
			if (in==vowels[i])
				return true;
		}
		return false;
	}	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in=scan.nextLine();
		scan.close();
		
		char[] word=in.toCharArray();
		
		String translated="";
		
		for (int i=0;i<word.length;i++){
			if (isVowel(word[i]))
				translated+=word[i];
			else
				translated+=rov(word[i]);
				
		}
		System.out.println(translated);

	}

}
