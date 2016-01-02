package dev;

public class Utils {
	public static int factorial(int number){
		int factorial=1;
		if(number==0){
			return factorial;
		}
		else{
			int tempNumber=number;
			while(tempNumber!=0){
				factorial=factorial*tempNumber--;
			}
			
			return factorial;
		}
	}
}
