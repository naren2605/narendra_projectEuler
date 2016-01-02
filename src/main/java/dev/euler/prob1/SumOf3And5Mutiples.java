package dev.euler.prob1;

public class SumOf3And5Mutiples {
public static void main(String[] args) {
	int number=1000;
	int sum=0;
	for(int i=1;i<number;i++){
		if(i%3==0||i%5==0){
			sum=sum+i;
		}
	}
	System.out.println(sum);
}
}
