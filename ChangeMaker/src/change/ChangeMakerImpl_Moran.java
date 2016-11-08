package change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ChangeMakerImpl_Moran implements ChangeMaker {
	
	private List<Integer> denominationsList;
	
	public ChangeMakerImpl_Moran(Set<Integer> denominations) {
		
		assert denominations != null;
		assert denominations.size() != 0;
		
		List<Integer> denominationsList = new ArrayList<Integer>();
		denominationsList.addAll(denominations);
		Collections.sort(denominationsList); //Sort denominations in order
		Collections.reverse(denominationsList); //reverse from largest to smallest
		this.denominationsList = denominationsList;
		
	}

	//pre: denominationsList is not null or empty
	//post: i in [0, rv.size() - 1) ==>
	//		rv.get(i) > rv.get(i + 1)
	//		returns a list of denominations in descending order (greedy)
	
	public List<Integer> getDenominations() {
		
		assert this.denominationsList != null;
		assert this.denominationsList.size() != 0;
		
		return this.denominationsList;
		
	}
	
	//pre: getDenominations().size() != 0	
	//	   
	//post: returns true or false -- based on whether making change is possible
	public boolean canMakeExactChange(int valueInCents) {
		
		int remainder = valueInCents;
		for (int coinValue : denominationsList) {
			
			if (remainder == 0) {
				break;
			}
			remainder = valueInCents % coinValue;
		}
		
		if (remainder == 0) {
			return true;
		}
		return false;
	}
	//must be greedy
		
	//pre: canMakeExactChange(valueInCents)
	//post: calculateValueOfChangeList(rv) == valueInCents
	//post: i in [0, rv.size() - 1) ==> 
	//				rv.get(i + 1) * getDenominations.get(i+1) < getDenominations.get(i)
	public List<Integer> getExactChange(int valueInCents) {
		
		assert canMakeExactChange(valueInCents);
		
		List<Integer> changeList = new ArrayList<Integer>();
		
		int remainder = valueInCents;
		
		for (int coinValue : denominationsList) {
			int coinAmount = remainder / coinValue;
			remainder = remainder % coinValue;
			changeList.add(coinAmount);			
		}
		System.out.println(changeList);
		return changeList;
	}
		
	//pre: changeList.size() == getDenominations().size()
	//pre: SIZE = changeList.size //NOTE: purely for notation
	//pre: Changelist is not 0 or empty
	//post: returns an integer -- generates a cent amount based on change list
	public int calculateValueOfChangeList(List<Integer> changeList) {
		
		assert changeList.size() == getDenominations().size();
		assert changeList.size() != 0;
		assert getDenominations().size() != 0;
		
		int index = 0;
		int finalAmount = 0;
		
		for (int coinCount : changeList) {
			
			finalAmount += (coinCount * denominationsList.get(index));
			index++;
		}
		return finalAmount;
	}
}