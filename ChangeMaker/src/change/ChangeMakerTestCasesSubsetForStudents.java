package change;

import static org.junit.Assert.*;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import change.ChangeMaker;
import change.ChangeMakerImpl_Moran;

public class ChangeMakerTestCasesSubsetForStudents
{
	@Retention(value=RUNTIME)
	@Target(value=METHOD)
	public @interface Points {
		int value();
	}
	
	private static Set<Integer> getUSCoinDenominationSet()
	{
		return getDenominationSet(new Integer[]{1, 5, 10, 25, 100});
	}
	
	private static String toString(Integer[] integerArray)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i < integerArray.length; i++)
		{
			sb.append(integerArray[i]);
			if(i < integerArray.length - 1)
			{
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	private static Set<Integer> getDenominationSet(Integer[] values)
	{
		Set<Integer> denominationSet = new HashSet<Integer>(Arrays.asList(values));
		assert denominationSet.size() == values.length : "The Integer array values has duplicates! : values = " + toString(values);
		//STUDENT: add check for null
		
		return denominationSet;
	}
	
	private static ChangeMaker getChangeMaker(Set<Integer> denominations)
	{
		return new ChangeMakerImpl_Moran(denominations);
	}
	
	@Points(value=5)
	@Test(timeout=3000)
	public void canMakeChangeTest() {
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		ChangeMaker changeMaker = getChangeMaker(usCoinDenominationSet);
		
		assertTrue(changeMaker.canMakeExactChange(55));
		assertTrue(changeMaker.canMakeExactChange(10));
		assertTrue(changeMaker.canMakeExactChange(11));
		assertTrue(changeMaker.canMakeExactChange(180004));
		
		changeFor58Cents();
		
	}
	
	
	@Test(timeout=3000)
	public void changeFor58Cents() {
		
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet(); ChangeMaker changeMaker = getChangeMaker(usCoinDenominationSet);
		int valueInCents = 58; assertTrue(changeMaker.canMakeExactChange(valueInCents)); List<Integer> changeList = changeMaker.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0, 2, 0, 1,
		3});
		assertEquals("Calculated changeList disagrees with expected!",
		correctChangeList, changeList); }
}
