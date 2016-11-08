package rationalnumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RationalNumberUtils_Moran {
	
	public static boolean equal (RationalNumber r1, RationalNumber r2) {
		if (r1.getValue() == r2.getValue()) {
			return true;
		}
		return false;
	}
	
	// a/b + c/d = (ad + bc)/bd
	public static RationalNumber add(RationalNumber r1, RationalNumber r2) {
		
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		int c = r2.getNumerator();
		int d = r2.getDenominator();
		
		int numerator   = (a*d) + (b*c); 
		int denominator = (b*d);
		
		int[] numArray = ContinuedFractionUtils_Moran.computeCoefficients(numerator, denominator);
		List<Integer> continuedFractionTerms = new ArrayList<Integer>();
		
		for (int integer : numArray) {
			continuedFractionTerms.add(integer);
		}
		
		
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		System.out.println("Addition Result:" + rationalNumber.getValue());
		return rationalNumber;
		
	}

	// a/b - c/d = (ad - bc) / bd
	public static RationalNumber subtract(RationalNumber r1, RationalNumber r2) {
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		int c = r2.getNumerator();
		int d = r2.getDenominator();
		
		int numerator   = (a*d) - (b*c); 
		int denominator = (b*d);
		
		int[] numArray = ContinuedFractionUtils_Moran.computeCoefficients(numerator, denominator);
		List<Integer> continuedFractionTerms = new ArrayList<Integer>();
		
		for (int integer : numArray) {
			continuedFractionTerms.add(integer);
		}
		
		
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		System.out.println("Subtract Result:" + rationalNumber.getValue());
		return rationalNumber;
	}
	
	// (a/b)(c/d) = (ac/bd)
	public static RationalNumber multiply(RationalNumber r1, RationalNumber r2) {
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		int c = r2.getNumerator();
		int d = r2.getDenominator();
		
		int numerator   = (a*c); 
		int denominator = (b*d);
		
		int[] numArray = ContinuedFractionUtils_Moran.computeCoefficients(numerator, denominator);
		List<Integer> continuedFractionTerms = new ArrayList<Integer>();
		
		for (int integer : numArray) {
			continuedFractionTerms.add(integer);
		}
		
		
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		System.out.println("Multiply Result:" + rationalNumber.getValue());
		return rationalNumber;
	}
	
	// (a/b) / (c/d) = (ad/bc)
	public static RationalNumber divide(RationalNumber r1, RationalNumber r2) {
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		int c = r2.getNumerator();
		int d = r2.getDenominator();
		
		int numerator   = (a*d); 
		int denominator = (b*c);
		
		int[] numArray = ContinuedFractionUtils_Moran.computeCoefficients(numerator, denominator);
		List<Integer> continuedFractionTerms = new ArrayList<Integer>();
		
		for (int integer : numArray) {
			continuedFractionTerms.add(integer);
		}
		
		
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		System.out.println("Divide Result:" + rationalNumber.getValue());
		return rationalNumber;
	}
	
	// -(a/b) = (-a/b)
	public static RationalNumber negate(RationalNumber r1) {
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		
		int numerator = a * -1;
		int denominator = b;
		
		int[] numArray = ContinuedFractionUtils_Moran.computeCoefficients(numerator, denominator);
		List<Integer> continuedFractionTerms = new ArrayList<Integer>();
		
		for (int integer : numArray) {
			continuedFractionTerms.add(integer);
		}
		
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		System.out.println("Negation Result:" + rationalNumber.getValue());
		return rationalNumber;
	}

}
