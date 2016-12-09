package scrabble;

import java.util.ArrayList;
import java.util.List;


public class DictionaryImpl_Moran implements Dictionary {

	List<String> wordList;

	public DictionaryImpl_Moran(List<String> wordList) {
		this.wordList = new ArrayList<String>();
		this.wordList = wordList;
	}
	
	@Override
	public boolean contains(String string) {
		System.out.println(string);
		return wordList.contains(string);
	}
}
