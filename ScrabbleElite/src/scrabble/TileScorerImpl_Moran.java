package scrabble;

import java.util.Map;
import java.util.Set;

public class TileScorerImpl_Moran implements TileScorer
{
	private Map<String, Integer> tileToPointsMap;
	
	public TileScorerImpl_Moran(Map<String, Integer> tileToPointsMap)
	{
		this.tileToPointsMap = tileToPointsMap;
	}

	@Override
	public Set<String> getTiles()
	{
		//return ScrabbleEliteConfiguration_Moran.getEliteTileSet();
		return tileToPointsMap.keySet();
	}

	@Override
	public int getPoints(String tile)
	{
		assert tile != null : "tile is null!";
		assert tile.codePointCount(0, tile.length()) == 1 : "tile.codePointCount(0, tile.length()) = " + tile.codePointCount(0, tile.length()) + " <> 1!";
		assert getTiles().contains(tile) : "tile = " + tile + " is not a tile! getTiles() = " + getTiles();

		return tileToPointsMap.get(tile);
	}
}
