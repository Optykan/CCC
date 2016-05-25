package ccc;

import java.util.Scanner;

public class mockccc14j4 {
	
	private static int calculateOvernight(String start, String end){
		String[] startTime=start.split(":");
		String[] endTime=start.split(":");
		int startMinutes=Integer.parseInt(startTime[0]+12)*60+Integer.parseInt(startTime[1]);
		//this is a PM time
		int endMinutes=Integer.parseInt(endTime[0])*60+Integer.parseInt(endTime[1]);
		//is is an AM time
		return (1440-startMinutes)+endMinutes;
	}
	private static boolean overnight(String start, String end){
		if(start.substring(start.length()-2).equals("PM") && end.substring(end.length()-2).equals("AM")){
			return true;
		}
		return false;
	}
	private static boolean isPM(String time){
		if(time.substring(time.length()-2).equals("PM")){
			return true;
		}
		return false;
	}
	private static int toMinutes(String time){
		String[] shift=time.split(":");
		int total=0;
		if(isPM(time)){
			total=(Integer.parseInt(shift[0])+12)*60+Integer.parseInt(shift[1].substring(0, shift[1].length()-2));
		}else{
			total=Integer.parseInt(shift[0])*60+Integer.parseInt(shift[1].substring(0, shift[1].length()-2));
		}
		return total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String[] bobShiftTime=scan.nextLine().split(" ");
		int[] bobShift={
			toMinutes(bobShiftTime[0]),
			toMinutes(bobShiftTime[1])
		};
		int time=0;
		int shiftId=0;
		
		int numShifts=Integer.parseInt(scan.nextLine());
		String[] shifts=new String[numShifts];
		int[][] shiftTime=new int[numShifts][2];
		for(int i=0;i<numShifts;i++){
			shifts[i]=scan.nextLine();
			shiftTime[i][0]=toMinutes(shifts[i].split(" ")[0]);
			shiftTime[i][1]=toMinutes(shifts[i].split(" ")[1]);
		}
		for(int i=0;i<numShifts;i++){
			int aliceStart=shiftTime[i][0];
			int aliceEnd=shiftTime[i][1];
			int compareTime=0;
			if(bobShift[0]<= aliceStart && bobShift[1]>=aliceEnd){
				compareTime=aliceEnd-aliceStart;
				if(compareTime<0){
					System.out.println(compareTime);
					compareTime=(1440-aliceStart)+aliceEnd;
				}
			}else if(bobShift[0]>=aliceStart && aliceEnd<=bobShift[1]){
				compareTime=aliceEnd-bobShift[0];
				if(compareTime<0){
					System.out.println(compareTime);
					compareTime=(1440-bobShift[0])+aliceEnd;
				}
			}else if(bobShift[0]>=aliceStart && bobShift[1]<=aliceEnd){
				compareTime=bobShift[1]-bobShift[0];
				if(compareTime<0){
					System.out.println(compareTime);
					compareTime=(1440-bobShift[0])+bobShift[1];
				}
			}
			else if(bobShift[0]<=aliceStart && bobShift[1]<=aliceEnd){
				compareTime=bobShift[1]-aliceStart;
				if(compareTime<0){
					System.out.println(compareTime);
					compareTime=(1440-aliceStart)+bobShift[1];
				}
			}else{
				System.out.println("something went really wrong");
				assert(false);
			}
			if(compareTime>time){
				shiftId=i;
				time=compareTime;
			}
				// --b--a--a--b-- > calculate length of alice shift
				// --a--b--a--b-- > calculate aliceEnd-bobStart
				// --a--b--b--a-- > calculate length of bob shift
				// --b--a--b--a-- > calculate bobEnd-aliceStart
		}
		if(time==0){
			System.out.println("Call in a sick day.");
		}else{
			System.out.println(shifts[shiftId]);
		}
		
	}

}
