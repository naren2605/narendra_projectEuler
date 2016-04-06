package dev;

import edu.naren.StackList;

public class RecursionToStackTests {

	
	
	public static void main(String[] args) {
		System.out.println(sumOfNumbersStack(4));
	}
	
	private static int sumOfNumbers(int number){
		if(number==0)return 0;
		return number+sumOfNumbers(number-1);
	}
	
	private static int fibnocii(int number){
    	if(number==0||number==1){
    		return 1;
    	}
    	else{
    		return fibnocii(number-2)+fibnocii(number-1);	
    	}
    	
    	
    }
	
	
	private static int fibnociiStack(int number){
    	StackList<Integer> stack= new StackList<Integer>();
    	
    	while(number!=0&&number!=1){
    		stack.push(number=number-2);
    	}
    	while(!stack.isEmpty()){
    		int number2=stack.pop();

    	}
    	
    	return 0;
    }
	
	
	
	private static int sumOfNumbersStack(int number){
		StackList<Integer> stack=new StackList<Integer>();
		stack.push(number);
		while(number!=0){
			stack.push(number=number-1);
		}
		while(!stack.isEmpty()){
			
		number=number+stack.pop();	
		}
		
		return number;
	}
	
}
