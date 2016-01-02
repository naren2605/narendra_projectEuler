package dev.euler.prob23;

import java.util.ArrayList;
import java.util.Map;

public class NumberCategory {

	public Map<Integer,ArrayList<Integer>> perfectNumbers;
	public Map<Integer,ArrayList<Integer>> deficientNumbers;
    public Map<Integer,ArrayList<Integer>> abundantNumbers;
    public NumberCategory() {
		
	}
    
	public NumberCategory(Map<Integer, ArrayList<Integer>> perfectNumbers,
			Map<Integer, ArrayList<Integer>> deficientNumbers,
			Map<Integer, ArrayList<Integer>> abundantNumbers) {
		super();
		this.perfectNumbers = perfectNumbers;
		this.deficientNumbers = deficientNumbers;
		this.abundantNumbers = abundantNumbers;
	}

	public Map<Integer, ArrayList<Integer>> getPerfectNumbers() {
		return perfectNumbers;
	}
	public void setPerfectNumbers(Map<Integer, ArrayList<Integer>> perfectNumbers) {
		this.perfectNumbers = perfectNumbers;
	}
	public Map<Integer, ArrayList<Integer>> getDeficientNumbers() {
		return deficientNumbers;
	}
	public void setDeficientNumbers(
			Map<Integer, ArrayList<Integer>> deficientNumbers) {
		this.deficientNumbers = deficientNumbers;
	}
	public Map<Integer, ArrayList<Integer>> getAbundantNumbers() {
		return abundantNumbers;
	}
	public void setAbundantNumbers(Map<Integer, ArrayList<Integer>> abundantNumbers) {
		this.abundantNumbers = abundantNumbers;
	}
    
}
