package scrabble;


import java.util.Set;

public class ScrabbleWordScorerImpl_Moran implements ScrabbleWordScorer
{
	private TileScorer tileScorer;
	private TileTranslator tileTranslator;
	private Dictionary dictionary;
	//DO NOT ADD ANY OTHER INSTANCE VARIABLES
	
	public ScrabbleWordScorerImpl_Moran(TileScorer tilePoints, TileTranslator tileTranslator, Dictionary dictionary)
	{
		assert tilePoints != null : "tilePoints is null!";
		assert tileTranslator != null : "tileTranslator is null!";
		assert dictionary != null : "dictionary is null!";
		
		this.tileScorer = tilePoints;
		this.tileTranslator = tileTranslator;
		this.dictionary = dictionary;
	}


	public Set<String> getTiles() {
		
		return ScrabbleEliteConfiguration_Moran.getEliteTileSet();
	}
	

	public boolean dictionaryContains(String string) {
		
		System.out.println("Ho");
		return dictionary.contains(string);
	}


	public boolean isLegalTransformation(String tileSequence, String target) {
		
		assert tileSequence != null : "tileSequence is null!";
		assert target != null : "target is null!";
		
		final int TILE_COUNT = tileSequence.codePointCount(0, tileSequence.length());
		final int TARGET_CODEPOINT_COUNT = target.codePointCount(0, target.length());
		
		boolean isLegalTransformation = true;
		
		if(TILE_COUNT != TARGET_CODEPOINT_COUNT)
		{
			isLegalTransformation = false;
		}
		else {
			
			for (int i = 0; i < TILE_COUNT; i++) {
				
				int charIndexOfCodePointi = tileSequence.offsetByCodePoints(0, i);
				int codePoint = tileSequence.codePointAt(charIndexOfCodePointi);
				
				String tile = getStringWithSingleCodePoint(codePoint);
				String targetLetter = Character.toString(target.charAt(i));
				
				Set <String> translationsSet = tileTranslator.getTranslationSet(tile);
				//System.out.println("CHECKING FOR TILE: " + tile + " IN: " + translationsSet + " CODEPOINT: " + codePoint);
				if (!translationsSet.contains(targetLetter)) {
					isLegalTransformation = false;
					break;
				}
			}
		}
		return isLegalTransformation;
	}


	public int getScore(String tileSequence, int[] tilePointsMultipliers)
	{
		assert tileSequence != null : "tileSequence is null!";
		final int CODE_POINT_COUNT = tileSequence.codePointCount(0, tileSequence.length());
		assert CODE_POINT_COUNT == tilePointsMultipliers.length : "CODE_POINT_COUNT = " + CODE_POINT_COUNT + " <> " + tilePointsMultipliers.length + " = tilePointsMultipliers.length! : tileSequence = " + tileSequence;
	
	
		int scoreSum = 0;
		for (int i = 0; i < CODE_POINT_COUNT; i++) {
			
			int charIndexOfCodePointi = tileSequence.offsetByCodePoints(0, i);
			
			int codePoint = tileSequence.codePointAt(charIndexOfCodePointi);
			//String tile = new String(new int[] {codePoint}, 0, 1);
			String tile = getStringWithSingleCodePoint(codePoint);
		
			int scoreForTile = getPoints(tile) * tilePointsMultipliers[i];
			scoreSum += scoreForTile;
			
		}
		
		return scoreSum;
	}

	public int getPoints(String tile)
	{
		assert tile != null : "tile is null";
		assert tile.codePointCount(0, tile.length()) == 1 : "String tile doesn't have exactly one code point! : tile.codePointCount(0, tile.length()) = " + tile.codePointCount(0, tile.length());

		return tileScorer.getPoints(tile);
	}
	
	
	private static String getStringWithSingleCodePoint(int codePoint)
	{
		final int MINIMUM_CODEPOINT = 0x10FFFF;
		assert codePoint >= 0 : "codePoint = " + codePoint + " < " + MINIMUM_CODEPOINT + " = MINIMUM_CODEPOINT!";
		final int MAXIMUM_CODEPOINT = 0x10FFFF;
		assert codePoint <= 0x10FFFF : "codePoint = " + codePoint + " > " + MAXIMUM_CODEPOINT + " = MAXIMUM_CODEPOINT!";
		
		String stringFromCodePoint = new String(new int[] {codePoint}, 0, 1);
		return stringFromCodePoint;
	}
	
}