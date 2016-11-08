package rationalnumbers;

import java.util.List;

public class RationalNumberImpl_Moran implements RationalNumber 
{
	private int[] continuedFractionTerms;
	private int denominator;
	private int numerator;
	
	public RationalNumberImpl_Moran(List<Integer> continuedFractionTerms)
	{
		
		int termsLength = continuedFractionTerms.size();
		this.continuedFractionTerms = new int[termsLength];
		
		for (int i = 0; i < termsLength; i++) {
			this.continuedFractionTerms[i] = continuedFractionTerms.get(i);
		}
		
		//Calculate Values flips this number
		numerator   = 1;
		denominator = this.continuedFractionTerms[termsLength - 1];
		
		calculateValues(this.continuedFractionTerms);
		
		// For negative numbers
		if (denominator < 0) {
			numerator = numerator * -1;
			denominator = denominator * -1;
		}
		
		
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public double getValue() {
		return (double) numerator/denominator;
	}
	
	/*
	 * Recursively shortens the array of coefficients to 2 elements, conserving the numerator,
	 * n0 = second to last number of the list
	 * n1 = last number of the list
	 * 
	 * Numerator becomes (n0 * n1) + oldNumerator
	 * Fraction is then flipped 
	 * 
	 * Loop is repeated until the length of the array is < 1:
	 * 		fraction is flipped one last time, 
	 * 		values numerator and denominator are set.
	 */
	
	private void calculateValues(int[] array) {
		
		if (array.length == 1) {
			int tempNumerator = numerator;
			numerator = denominator;
			denominator = tempNumerator;
			
			System.out.println("Value: " + numerator + "/" + denominator);
			return;
		}
		
		int index = array.length - 1;
		int n0 = array[index - 1];
		int n1 = array[index];
		
		//System.out.println("n0 = " + n0);
		//System.out.println("n1 = " + n1);
		
		denominator = n1;
		int newNumerator = (n0 * n1) + numerator;
		
		//flip numerator and denominator
		numerator = denominator;
		denominator = newNumerator;
		//System.out.println("new numerator = " + numerator);
		//System.out.println("new denominator = " + denominator);
		
		int[] newArray = new int[array.length - 1];
		
		for (int i = 0; i < newArray.length; i++) {
			if (i == newArray.length - 1) {
				//make sure the last element is the new denominator
				newArray[i] = denominator;
			}
			else {
				newArray[i] = array[i]; //Add the unused elements to the list
			}
		}
		calculateValues(newArray);
	}
}
