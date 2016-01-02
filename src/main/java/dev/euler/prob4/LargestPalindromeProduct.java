package dev.euler.prob4;

public class LargestPalindromeProduct {
	
	
	public static void main(String[] args) {

	   int largestPalindrome=0;
		for(int i=(999);i>=(100);i--){
			for(int j=(999);j>=(100);j--){
				int temp=i*j;
				if(isPalindrome(temp)){
					if(temp>largestPalindrome){
						largestPalindrome=temp;
					}
				}
			}
			
		}
		
	   System.out.println("largest:"+largestPalindrome);
	}
	
	public static boolean isPalindrome(int number){
		boolean palindrom=false;
		int palindrome=0;
		int actualnumber=number;
		
		for(;number>0;){
			int temp=number%10;
			palindrome=palindrome*10+(temp);
			number=number/10;
		}
		number=actualnumber;
		if(palindrome==number){
			palindrom=true;
		}
		return palindrom;
	}
}
