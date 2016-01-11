package dev.euler.prob19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountingSundays {
	
	private static class DayMap{
		HashMap<Integer, String> days=new HashMap<Integer, String>();
		HashMap<String, Integer> daysInteger=new HashMap<String, Integer>();
		HashMap<Integer, String> months=new HashMap<Integer, String>();
		private  Set<Integer> monthsWith31Days=new  HashSet<Integer>();
	
		public DayMap setDay(int i,String day){
			this.days.put(i, day);
			this.daysInteger.put(day, i);
			return this;
		}
		public DayMap setMonth(int i,String month){
			this.months.put(i, month);
			return this;
		}
		
		public  DayMap add31stMonth(int month){
			monthsWith31Days.add(month);
			return this;
		}
		
		public int daysOfMonth(int month,int year){
			if(month==2){
				if(year %400 ==0){
					return 29;
				}
				else if(year %100 ==0){
					return 28;
				}
				else if(year%4==0){
					return 29;
				}
				else{
					return 28;
				}
			}
			else{
				if(monthsWith31Days.contains(month)){
					return 31;
				}
				else{
					return 30;
				}
			}
			
			
			
		}
	}
	
	public static class Date{
		int day_month;
		int day;
		int month;
		int year;
		public Date(int day_month,int month,int year,int day) {
			this.day_month=day_month;
			this.month=month;
			this.year=year;
			this.day=day;
		}
		public Date(int day_month,int month,int year) {
			this.day_month=day_month;
			this.month=month;
			this.year=year;
		}
	}
	
	public static DayMap dayInfo=new DayMap();
	static{
		dayInfo.setDay(1, "MONDAY")
		.setDay(2, "TUESDAY")
		.setDay(3, "WEDNESDAY")
		.setDay(4, "THURSDAY")
		.setDay(5, "FRIDAY")
		.setDay(6, "SATURDAY")
		.setDay(7, "SUNDAY")
		.setMonth(1, "JAN")
		.setMonth(2, "FEB")
		.setMonth(3, "MAR")
		.setMonth(4, "APR")
		.setMonth(5, "MAY")
		.setMonth(6, "JUN")
		.setMonth(7, "JUL")
		.setMonth(8, "AUG")
		.setMonth(9, "SEP")
		.setMonth(10, "OCT")
		.setMonth(11, "NOV")
		.setMonth(12, "DEC")
		.add31stMonth(1).add31stMonth(3).add31stMonth(5)
		.add31stMonth(7).add31stMonth(8).add31stMonth(10).add31stMonth(12);
		
		
		;
	}
	
public static void main(String[] args) {
	
	Date startDate1=new Date(1, 1, 1900,1);
	Date endDate2=new Date(13,1,1999);//2
	

	//System.out.println((effectiveDays(startDate1, endDate2)/7)-((effectiveDays(startDate1, endDate1)/7)));
System.out.println(getFutureDayFromPastDay(startDate1, endDate2));
	int count=0;
	for(int i=1901;i<=2000;i++){
		
		for(int month=1;month<=12;month++){
			Date endDate1=new Date(1,month,i);
			String day=getFutureDayFromPastDay(startDate1, endDate1);
			System.out.println("day.."+day);
			if(dayInfo.daysInteger.get(day)==7){
				System.out.println("year = "+endDate1.year+"month = "+endDate1.month+"day = "+endDate1.day_month);
				count++;
			}
			
			//startDate1=new Date(1, month, i, dayInfo.daysInteger.get(day));
		}
	}
	System.out.println(count+" sundays");
}

public static String getFutureDayFromPastDay(Date past,Date future){
	
	if(past.day!=0){

		int days=effectiveDays(past, future);
	
		System.out.println("days=="+days+"===="+(days%7));
	    if(days%7!=0){
	    	int day=0;
	    	
	    	//	int diff=future.day_month-(days%7);
	    		for(int i=1 ,k=past.day;i<=((days%7));i++){
	    		//	System.out.println(i);
	    			
	    			
	    				k++;
	    				day=k%7;
		    			
		    			if(day==0){
		    				k=7;
		    				day=7;
		    			}
	    			
	    			
	    		}
	    		System.out.println(day+"da....");
	    		return dayInfo.days.get((day)%7==0?7:(day)%7);
	    	
	    }
	    else{
	    	return dayInfo.days.get(past.day);
	    }
	}
	return "";
}



public static int effectiveDays(Date start,Date end){
	
	
	int totaldays=0;
	
	for(int year=start.year;year<=end.year;year++){
        if(start.year==end.year){
        	int days=0;
        	for(int  month=start.month;month<=end.month;month++){
        		if(month==start.month&&month==end.month){
        			days=days+(end.day_month-start.day_month);
        			System.out.println(days);
        		}
        		else if(month==start.month){
        			days=days+dayInfo.daysOfMonth(month, year)-start.day_month;
        			System.out.println(days);
        		}
        		else if(month==end.month){
        			
        			days=days+end.day_month;
        			//System.out.println(days);
        		}
        		else{
        			days=days+dayInfo.daysOfMonth(month, year);
        		}
				
			}
			totaldays=totaldays+days;
        } 
        else if(year==start.year){
			int days=0;
			for(int  month=start.month;month<=12;month++){
				days=days+dayInfo.daysOfMonth(month, year);
				//System.out.println(dayInfo.daysOfMonth(month, year));
			}
			days=days-start.day_month;
			totaldays=totaldays+days;
			
		}
		else if(year==end.year){
			int days=0;
			for(int  month=1;month<end.month;month++){
				days=days+dayInfo.daysOfMonth(month, year);
				//System.out.println(dayInfo.daysOfMonth(month, year));
				
			}
			days=days+end.day_month;
			totaldays=totaldays+days;
		}
		else{
			if(year%400==0){
				totaldays=totaldays+366;
				
			}else if(year%100==0){
				totaldays=totaldays+365;
			}
			else if(year%4==0){
				totaldays=totaldays+366;
			}
			else{
				totaldays=totaldays+365;
			}
		}
	}
	
	
	return totaldays;
	
}

}
