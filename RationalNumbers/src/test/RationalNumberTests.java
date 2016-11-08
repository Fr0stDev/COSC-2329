package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import rationalnumbers.ContinuedFractionUtils_Moran;
import rationalnumbers.RationalNumber;
import rationalnumbers.RationalNumberImpl_Moran;
import rationalnumbers.RationalNumberUtils_Moran;

public class RationalNumberTests
{
	
	@Test
	public void conversionFromCFToRN_112()
	{
		List<Integer> continuedFractionTerms = Arrays.asList(new Integer[]{1, 1, 2});
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		assertEquals(5, rationalNumber.getNumerator());
		assertEquals(3, rationalNumber.getDenominator());
	}
	
	@Test
	public void conversionFromCFToRN_248()
	{
		List<Integer> continuedFractionTerms = Arrays.asList(new Integer[]{2, 4, 8});
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		assertEquals(74, rationalNumber.getNumerator());
		assertEquals(33, rationalNumber.getDenominator());
	}
	
	@Test
	public void conversionFromCFToRN_358()
	{
		List<Integer> continuedFractionTerms = Arrays.asList(new Integer[]{3, 5, 8});
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		assertEquals(131, rationalNumber.getNumerator());
		assertEquals(41, rationalNumber.getDenominator());
	}
	
	@Test
	public void conversionFromCFToRN_2222222()
	{
		List<Integer> continuedFractionTerms = Arrays.asList(new Integer[]{2, 2, 2, 2, 2, 2, 2});
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		assertEquals(408, rationalNumber.getNumerator());
		assertEquals(169, rationalNumber.getDenominator());
	}
	
	
	@Test
	public void conversionFromRNToCF_5_3()
	{
		int numerator = 5;
		int denominator = 3;
		int[] continuedFractionTerms = ContinuedFractionUtils_Moran.computeCoefficients(numerator, denominator);
		assertEquals(3, continuedFractionTerms.length);
		assertEquals(1, continuedFractionTerms[0]);
		assertEquals(1, continuedFractionTerms[1]);
		assertEquals(2, continuedFractionTerms[2]);
	}
	
	@Test
	public void conversionFromRNToCF_408_169()
	{
		int numerator = 408;
		int denominator = 169;
		int[] continuedFractionTerms = ContinuedFractionUtils_Moran.computeCoefficients(numerator, denominator);
		assertEquals(7, continuedFractionTerms.length);
		for(int i = 0; i < continuedFractionTerms.length; i++)
		{
			assertEquals(2, continuedFractionTerms[i]);
		}
	}
	
	@Test
	public void singleNumber3() {
		List<Integer> continuedFractionTerms = Arrays.asList(new Integer[]{3});
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		assertEquals(3, rationalNumber.getNumerator());
		assertEquals(1, rationalNumber.getDenominator());
	}
	
	@Test
	public void singleNumberHalf() {
		int numerator =  4;
		int denominator = 8;
		int[] continuedFractionTerms = ContinuedFractionUtils_Moran.computeCoefficients(numerator, denominator);
		assertEquals(2, continuedFractionTerms.length);
		assertEquals(0, continuedFractionTerms[0]);
		assertEquals(2, continuedFractionTerms[1]);	
	}
	
	@Test
	public void additionTest() {
		List<Integer> continuedFractionTerms = Arrays.asList(new Integer[]{0,2});
		RationalNumber r1 = new RationalNumberImpl_Moran(continuedFractionTerms);
		
		List<Integer> continuedFractionTerms1 = Arrays.asList(new Integer[]{0,4});
		RationalNumber r2 = new RationalNumberImpl_Moran(continuedFractionTerms1);
		
		RationalNumber returnValue = RationalNumberUtils_Moran.add(r1, r2);
		int[] continuedFractionTerms2 = ContinuedFractionUtils_Moran.computeCoefficients(returnValue.getNumerator(), returnValue.getDenominator());
		
		assertEquals(0, continuedFractionTerms2[0]);
		assertEquals(1, continuedFractionTerms2[1]);
		assertEquals(3, continuedFractionTerms2[2]);
		// assertEquals(1.0, returnValue.getValue());
	}
	
	@Test
	public void negativeFractionToList() {
		int numerator = -17;
		int denominator = 10;
		int[] continuedFractionTerms = ContinuedFractionUtils_Moran.computeCoefficients(numerator, denominator);
		assertEquals(3, continuedFractionTerms.length);
		assertEquals(-2, continuedFractionTerms[0]);
		assertEquals(3, continuedFractionTerms[1]);	
		assertEquals(3, continuedFractionTerms[2]);	
	}
	
	@Test
	public void negativeListToFraction() {
		List<Integer> continuedFractionTerms = Arrays.asList(new Integer[]{-4,2});
		RationalNumber rationalNumber = new RationalNumberImpl_Moran(continuedFractionTerms);
		assertEquals(-7, rationalNumber.getNumerator());
		assertEquals(2, rationalNumber.getDenominator());
	}
	
}
