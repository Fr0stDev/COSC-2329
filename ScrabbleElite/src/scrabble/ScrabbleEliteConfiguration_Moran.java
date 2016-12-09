package scrabble;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static scrabble.ScrabbleEliteTileConstants.*;

public class ScrabbleEliteConfiguration_Moran
{
	private ScrabbleEliteConfiguration_Moran()
	{
		throw new RuntimeException("DO NOT INSTANTIATE!");
	}
	
	public final static String[] ELITE_TILES = new String[]{FOUR, B, C, D, THREE, F, SIX, H, I, J, K, ONE, M, N, ZERO, P, Q, R, FIVE, SEVEN, U, V, W, X, Y, TWO, DOT, PARENTHESIZED_D, V_DOT, PHI};
	
	public static Set<String> getEliteTileSet()
	{
		Set<String> classicTileSet = new HashSet<String>(Arrays.asList(ELITE_TILES));
		return classicTileSet;
	}
	
	private static Map<String, Integer> eliteTileToPointsMap = new HashMap<String, Integer>();
	static
	{
		Integer[] points_Array = new Integer[] {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10,0,0,0,2};
		
		for (int i = 0; i < ELITE_TILES.length; i++) {
			eliteTileToPointsMap.put(ELITE_TILES[i], points_Array[i]);
		}
		
	}
	
	public static Map<String, Integer> getEliteTileToPointsMap()
	{
		return eliteTileToPointsMap;
	}
	
	private static Map<String, Set<String>> eliteTileToTranslationSetMap = new HashMap<String, Set<String>>();
	static
	{
		String[] alphabet_array = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String[] parenthesisD_Array = new String[] {"a","g","l","o","s","t","z"};
		String[] vowels_Array = new String[] {"a","e","i","o","u"};
		String[] phi_Array = new String[] {"p","f"};
		
		int index = 0;
		while (index < alphabet_array.length) {
			eliteTileToTranslationSetMap.put(ELITE_TILES[index], new HashSet<String>(Arrays.asList(new String[] {alphabet_array[index]})));
			index++;
		}
		
		eliteTileToTranslationSetMap.put(DOT, new HashSet<String>(Arrays.asList(alphabet_array)));
		index++;
		
		eliteTileToTranslationSetMap.put(PARENTHESIZED_D, new HashSet<String>(Arrays.asList(parenthesisD_Array)));
		index++;
		
		
		eliteTileToTranslationSetMap.put(V_DOT, new HashSet<String>(Arrays.asList(vowels_Array)));
		index++;
		
		eliteTileToTranslationSetMap.put(PHI, new HashSet<String>(Arrays.asList(phi_Array)));
		index++;				
	}
	
	public static Map<String, Set<String>> getEliteTileToTranslationSetMap()
	{
		return eliteTileToTranslationSetMap;
	}
	
	private static List<String> readFile(File filename)
	{
		try
		{
			List<String> wordList = new ArrayList<String>();

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("resources/" + filename.getName());
			assert input != null : "input is null! : Check that the resources folder is on the classpath, the file name is correct, and the file is in the resources folder";
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
			String str;
			do
			{
				str = bufferedReader.readLine();
				if(str != null)
				{
					wordList.add(str);
				}
			}while(str != null);
			return wordList;
		}catch(IOException ioException)
		{
			throw new RuntimeException(ioException.getMessage());
		}
	}
	
	public static List<String> getEliteWordList()
	{
		List<String> wordList = readFile(new File("words.txt"));
		final int EXPECTED_SIZE = 113809;
		assert wordList.get(0).equals("aa");
		assert wordList.size() == EXPECTED_SIZE : "wordList.size() = " + wordList.size() + " <> " + EXPECTED_SIZE + " = expected size!";
		assert wordList.get(EXPECTED_SIZE - 1).equals("zymurgy");
		return wordList;
	}
}