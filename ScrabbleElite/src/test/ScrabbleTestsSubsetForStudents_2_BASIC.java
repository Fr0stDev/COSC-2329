package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import scrabble.Dictionary;
import scrabble.DictionaryImpl_Moran;
import scrabble.ScrabbleEliteConfiguration_Moran;
import scrabble.ScrabbleWordScorer;
import scrabble.ScrabbleWordScorerImpl_Moran;
import scrabble.TileScorer;
import scrabble.TileScorerImpl_Moran;
import scrabble.TileTranslator;
import scrabble.TileTranslatorImpl_Moran;
import extension.Points;

public class ScrabbleTestsSubsetForStudents_2_BASIC extends ScrabbleTestsSubsetForStudents_1_ENVIRONMENT
{
	protected TileScorer tileScorer_STUDENT;
	protected TileTranslator tileTranslator_STUDENT;
	protected Dictionary dictionary_STUDENT;
	protected ScrabbleWordScorer scrabbleWordScorer_STUDENT;
	
	@Before
	public void initBeforeEachTestMethod()
	{
		//Student should edit this method:
		//TileScorerImpl_Skeleton should be replaced with TileScorerImpl_LastName
		//TileTranslatorImpl_Skeleton should be replaced with TileTranslatorImpl_LastName
		//DictionaryImpl_Skeleton should be replaced with DictionaryImpl_LastName
		//ScrabbleWordScorerImpl_Skeleton should be replaced with ScrabbleWordScorerImpl_LastName
		//ScrabbleEliteConfiguration_Skeleton should be replaced with ScrabbleEliteConfiguration_LastName
		tileScorer_STUDENT = new TileScorerImpl_Moran(ScrabbleEliteConfiguration_Moran.getEliteTileToPointsMap());
		tileTranslator_STUDENT = new TileTranslatorImpl_Moran(ScrabbleEliteConfiguration_Moran.getEliteTileToTranslationSetMap());
		dictionary_STUDENT = new DictionaryImpl_Moran(ScrabbleEliteConfiguration_Moran.getEliteWordList());
		scrabbleWordScorer_STUDENT = new ScrabbleWordScorerImpl_Moran(tileScorer_STUDENT, tileTranslator_STUDENT, dictionary_STUDENT);
	}
	
	@Points(value = 5)
	@Test
	public void dictionaryTest()
	{
		TEST_GOAL_MESSAGE = "Test the dictionary functionality of the student's ScrabbleWordScorer";
		assertTrue(scrabbleWordScorer_STUDENT.dictionaryContains("aa"));
		assertTrue(scrabbleWordScorer_STUDENT.dictionaryContains("abbreviations"));
		assertTrue(scrabbleWordScorer_STUDENT.dictionaryContains("apple"));
		assertTrue(scrabbleWordScorer_STUDENT.dictionaryContains("bird"));
		assertTrue(scrabbleWordScorer_STUDENT.dictionaryContains("panda"));
		assertTrue(scrabbleWordScorer_STUDENT.dictionaryContains("scrabble"));
		assertTrue(scrabbleWordScorer_STUDENT.dictionaryContains("why"));
	}
	
	@Points(value = 5)
	@Test
	public void dictionaryTest2()
	{
		TEST_GOAL_MESSAGE = "Test the dictionary functionality of the student's ScrabbleWordScorer";
		assertTrue(!scrabbleWordScorer_STUDENT.dictionaryContains("ⒷⒾⓇⒹ"));
		assertTrue(!scrabbleWordScorer_STUDENT.dictionaryContains("hexadecimal"));
	}
	
	@Points(value = 5)
	@Test
	public void dictionaryTest3()
	{
		TEST_GOAL_MESSAGE = "Test the dictionary functionality of the student's ScrabbleWordScorer";
		assertTrue(scrabbleWordScorer_STUDENT.dictionaryContains("null"));
		
		assertTrue(!scrabbleWordScorer_STUDENT.dictionaryContains(null));
	}
	
	@Points(value = 5)
	@Test
	public void tileScorerTest()
	{
		TEST_GOAL_MESSAGE = "Test the tile scoring functionality of the student's TileScorer";
		assertEquals(3, tileScorer_STUDENT.getPoints("Ⓑ"));
		assertEquals(2, tileScorer_STUDENT.getPoints("Ⓓ"));
		assertEquals(1, tileScorer_STUDENT.getPoints("Ⓘ"));
		assertEquals(1, tileScorer_STUDENT.getPoints("Ⓡ"));
	}
	
	private static Set<String> asSet(String... strings)
	{
		return new HashSet<String>(Arrays.asList(strings));
	}
	
	@Points(value = 5)
	@Test
	public void tileTranslatorTest()
	{
		TEST_GOAL_MESSAGE = "Test the translation functionality of the student's TileTranslator";
		assertEquals(asSet("b"), tileTranslator_STUDENT.getTranslationSet("Ⓑ"));
		assertEquals(asSet("d"), tileTranslator_STUDENT.getTranslationSet("Ⓓ"));
		assertEquals(asSet("i"), tileTranslator_STUDENT.getTranslationSet("Ⓘ"));
		assertEquals(asSet("r"), tileTranslator_STUDENT.getTranslationSet("Ⓡ"));
	}
	
	@Points(value = 5)
	@Test
	public void tileTranslatorTest2()
	{
		TEST_GOAL_MESSAGE = "Test the translation functionality of the student's TileTranslator";
		assertEquals(asSet("a", "e", "i", "o", "u"), tileTranslator_STUDENT.getTranslationSet("Ṿ"));
		assertEquals(asSet("p", "f"), tileTranslator_STUDENT.getTranslationSet("𝞍"));
	}
}
