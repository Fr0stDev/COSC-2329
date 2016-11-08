package rationalnumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// I am so sorry you have to read through this.

public class ContinuedFractionUtils_Moran
{
		
	private ContinuedFractionUtils_Moran()
	{
		throw new RuntimeException("DO NOT INSTANTIATE!");
		//ok.
	}
	
	public static int[] computeCoefficients(int numerator, int denominator)
	{
		List<Integer> tempList = new ArrayList<Integer>();
		
		System.out.println(numerator + "/" + denominator);
		
		//Make sure the negative number is always the numerator
		if (denominator < 0) {
			numerator = numerator * -1;
			denominator = denominator * -1;
		}
		
		assert denominator > 0;
		
		//reduce the fraction 
		
		//gcd for positive numbers
		if (numerator > 0) {
			int gcd = gcd(numerator, denominator);
			numerator = numerator/gcd;
			denominator = denominator/gcd;
		}
		// gcd for negative numbers
		if (numerator < 0) {
			int gcd = gcd(numerator, denominator);
			numerator = numerator/(gcd * -1);
			denominator = denominator/(gcd * -1);
		}
		
		
		
		//return the numerator if n/1
		if (denominator == 1) {
			int[] rv = {numerator};
			System.out.println(Arrays.toString(rv));
			return rv;
		}
		
		
		
		//return [0, denominator] if numerator is 1 -- 0 + 1/n
		if (numerator == 1) {
			int[] rv = {0, denominator};
			
			System.out.println(Arrays.toString(rv));
			return rv;
		}
		

		//For negative numbers
		if (numerator < 0) {
			int firstCoefficient = (numerator / denominator) - 1;
			tempList.add(firstCoefficient);
			
			System.out.println(numerator);
							
			int newNumerator = numerator   + denominator;
			
			if (numerator < -1) {
				newNumerator     = denominator + newNumerator;
			}
						
			numerator = newNumerator;
			System.out.println(denominator);
			
			
			
			if (numerator == 1) {
				tempList.add(denominator);
			}
			
			
			while (numerator > 1) {
				
				int temp;
				temp = numerator/denominator;
				numerator = numerator % denominator;
				
				if (temp != 0) {
					tempList.add(temp);
				}
				
				
				int tempNumerator = numerator;
				numerator = denominator;
				denominator = tempNumerator;
			}
							
		}
		
		//For positive numbers
		else if (numerator > 0) {
			while (numerator > 1) {
				
				int temp;
				temp = numerator/denominator;
				numerator = numerator % denominator;
				
				tempList.add(temp);
				
				int tempNumerator = numerator;
				numerator = denominator;
				denominator = tempNumerator;
			}
		}
		
		int size = tempList.size();
		
		int[] coefficientsArray = new int[size];
		
		for (int i = 0; i < size; i++) {
			coefficientsArray[i] = tempList.get(i);
		}
		
		System.out.println(Arrays.toString(coefficientsArray));
		return coefficientsArray;
		
	}
	
	public static int gcd(int a, int b) {
	
		if (b==0) 
			return a;
		else
			return gcd(b, a % b);
	}
}
