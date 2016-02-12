package dev.euler.prob29;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import dev.Utils;

public class DistinctPowers {
public static void main(String[] args) {
	System.out.println(new Date());
	int a=100;
	int b=100;
	Set<String> set= new HashSet<String>();
	for(int i=2;i<=a;i++){
	
		for(int j=2;j<=b;j++){
			set.add(Utils.power(i+"", j));
		}
		
	}
	
	System.out.println(set.size());
	System.out.println(new Date());
}
}
