package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import scrabble.ScrabbleEliteTileConstants;
import extension.Points;

public class ScrabbleTestsSubsetForStudents_1_ENVIRONMENT
{
	protected boolean studentHasVerifiedThatTheFileDecodingImageInResourcesMatchesWhatTheySeeInTheirEclipse = true;
	protected String TEST_GOAL_MESSAGE;
	
	@Points(value=0)
	@Test(expected=AssertionError.class)
	public void assertionsEnabledTest()
	{
		TEST_GOAL_MESSAGE = "Check whether assertions are enabled";
		assert false;
		throw new RuntimeException("ENABLE ASSERTIONS IN RUN CONFIGURATION!");
	}
	
	@Points(value=0)
	@Test
	public void fileDecodingImageTest()
	{
		TEST_GOAL_MESSAGE = "Check that the fileDecodingTest().png image matches how the fileDecodingTest() appears in the student's Eclipse";
		assertTrue(studentHasVerifiedThatTheFileDecodingImageInResourcesMatchesWhatTheySeeInTheirEclipse);
	}
	
	@Points(value = 0)
	@Test
	public void fileDecodingTest()
	{
		TEST_GOAL_MESSAGE = "Check that the student's Eclipse is using UTF-8 to decode this test file";
		String allTilesString = "④ⒷⒸⒹ③Ⓕ⑥ⒽⒾⒿⓀ①ⓂⓃ⓪ⓅⓆⓇ⑤⑦ⓊⓋⓌⓍⓎ②⊙⒟Ṿ𝞍";
		int allTilesStringLength = 1*26 					//each of the letters/numbers require 1 char;
									+ 1 + 1 + 1			//DOT, PARENTHESIZED_D, V_DOT require 1 char;
									+ 2;					//PHI requires 2 chars
		assertEquals(allTilesStringLength, allTilesString.length());
	}
	
	@Points(value = 0)
	@Test
	public void fileDecodingTest2()
	{
		TEST_GOAL_MESSAGE = "Check that the student's Eclipse is using UTF-8 to decode this test file";
		String allTilesString = "④ⒷⒸⒹ③Ⓕ⑥ⒽⒾⒿⓀ①ⓂⓃ⓪ⓅⓆⓇ⑤⑦ⓊⓋⓌⓍⓎ②⊙⒟Ṿ𝞍";
		String allTilesString2 = ScrabbleEliteTileConstants.FOUR + ScrabbleEliteTileConstants.B + ScrabbleEliteTileConstants.C + ScrabbleEliteTileConstants.D + ScrabbleEliteTileConstants.THREE + ScrabbleEliteTileConstants.F + ScrabbleEliteTileConstants.SIX + ScrabbleEliteTileConstants.H + ScrabbleEliteTileConstants.I +//
								ScrabbleEliteTileConstants.J + ScrabbleEliteTileConstants.K + ScrabbleEliteTileConstants.ONE + ScrabbleEliteTileConstants.M + ScrabbleEliteTileConstants.N + ScrabbleEliteTileConstants.ZERO + ScrabbleEliteTileConstants.P + ScrabbleEliteTileConstants.Q +//
								ScrabbleEliteTileConstants.R + ScrabbleEliteTileConstants.FIVE + ScrabbleEliteTileConstants.SEVEN + ScrabbleEliteTileConstants.U + ScrabbleEliteTileConstants.V + ScrabbleEliteTileConstants.W + ScrabbleEliteTileConstants.X + ScrabbleEliteTileConstants.Y + ScrabbleEliteTileConstants.TWO +//
								ScrabbleEliteTileConstants.DOT + ScrabbleEliteTileConstants.PARENTHESIZED_D + ScrabbleEliteTileConstants.V_DOT + ScrabbleEliteTileConstants.PHI;
				
		int allTilesStringLength = 1*26 					//each of the letters/numbers require 1 char;
									+ 1 + 1 + 1			//DOT, PARENTHESIZED_D, V_DOT require 1 char;
									+ 2;					//PHI requires 2 chars
		assertEquals(allTilesStringLength, allTilesString2.length());
		assertEquals(allTilesString, allTilesString2);
	}
}
