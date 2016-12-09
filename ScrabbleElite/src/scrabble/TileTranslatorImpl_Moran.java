package scrabble;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TileTranslatorImpl_Moran implements TileTranslator
{
	private Map<String, Set<String>> tileToTranslationSetMap;
	
	public TileTranslatorImpl_Moran(Map<String, Set<String>> tileToTranslationSetMap)
	{
		this.tileToTranslationSetMap = tileToTranslationSetMap;
	}
	

	public Set<String> getTileSet()
	{
		
		return tileToTranslationSetMap.keySet();
	}

	
	public Set<String> getTranslationSet(String tile)
	{
		return tileToTranslationSetMap.get(tile);
	}


	public Set<String> getTranslationUniverse()
	{
		Set<String> universeSet = new HashSet<String>();
		universeSet.addAll(getTileSet());
		
		for (String tile: getTileSet())  {
			
			Set<String> translationSet = tileToTranslationSetMap.get(tile);
			universeSet.addAll(translationSet);
			
		}
	
		return universeSet;
		
	}
}