package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import scrabble.ScrabbleEliteTileConstants;
import extension.Points;

public class ScrabbleTestsSubsetForStudents_3_INTERMEDIATE extends ScrabbleTestsSubsetForStudents_2_BASIC
{
	@Points(value = 5)
	@Test
	public void scorebird()
	{
		TEST_GOAL_MESSAGE = "Test the scoring functionality of the student's ScrabbleWordScorer";
		String tileSequence = "ⒷⒾⓇⒹ";
		int[] tilePointsMultipliers = new int[]{1, 1, 1, 1};
		int expectedScore = 3 + 1 + 1 + 2;
		assertEquals(expectedScore, scrabbleWordScorer_STUDENT.getScore(tileSequence, tilePointsMultipliers));
	}
	
	@Points(value = 5)
	@Test
	public void score5cr4bb13()
	{
		TEST_GOAL_MESSAGE = "Test the scoring functionality of the student's ScrabbleWordScorer";
		String tileSequence = "⑤ⒸⓇ④ⒷⒷ①③";
		int[] tilePointsMultipliers = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
		int expectedScore = 14;
		assertEquals(expectedScore, scrabbleWordScorer_STUDENT.getScore(tileSequence, tilePointsMultipliers));
	}
	
	@Points(value = 5)
	@Test
	public void score5cr4bb13Multiplier0()
	{
		TEST_GOAL_MESSAGE = "Test the scoring functionality of the student's ScrabbleWordScorer";
		String tileSequence = "⑤ⒸⓇ④ⒷⒷ①③";
		int[] tilePointsMultipliers = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		int expectedScore = 0;
		assertEquals(expectedScore, scrabbleWordScorer_STUDENT.getScore(tileSequence, tilePointsMultipliers));
	}
	
	@Points(value = 5)
	@Test
	public void score5cr4bb13Multipliers()
	{
		TEST_GOAL_MESSAGE = "Test the scoring functionality of the student's ScrabbleWordScorer";
		String tileSequence = "⑤ⒸⓇ④ⒷⒷ①③";
		int[] tilePointsMultipliers = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		int expectedScore = 62;
		assertEquals(expectedScore, scrabbleWordScorer_STUDENT.getScore(tileSequence, tilePointsMultipliers));
	}

	@Points(value = 5)
	@Test(expected=AssertionError.class)
	public void score5crVb_1D_FirstVersion()
	{
		TEST_GOAL_MESSAGE = "Test that preconditions of the student's ScrabbleWordScorer.getScore() method are executable";
		String tileSequence = "⑤ⒸⓇṾⒷ⊙①(d)";
		int[] tilePointsMultipliers = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
		scrabbleWordScorer_STUDENT.getScore(tileSequence, tilePointsMultipliers);
	}
	
	@Points(value = 5)
	@Test(expected=AssertionError.class)
	public void score5crVb_1D_SecondVersion()
	{
		TEST_GOAL_MESSAGE = "Test that preconditions of the student's ScrabbleWordScorer.getScore() method are executable";
		String tileSequence = "⑤ⒸⓇṾⒷ⊙①" + ScrabbleEliteTileConstants.PARENTHESIZED_D;
		int[] tilePointsMultipliers = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
		scrabbleWordScorer_STUDENT.getScore(tileSequence, tilePointsMultipliers);
	}
	
	@Points(value = 5)
	@Test
	public void score5crVb_1D_ThirdVersion()
	{
		TEST_GOAL_MESSAGE = "Test the scoring functionality of the student's ScrabbleWordScorer";
		String tileSequence = "⑤ⒸⓇ" + ScrabbleEliteTileConstants.V_DOT + "Ⓑ⊙①" + ScrabbleEliteTileConstants.PARENTHESIZED_D;
		int[] tilePointsMultipliers = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
		int expectedScore = 9;
		assertEquals(expectedScore, scrabbleWordScorer_STUDENT.getScore(tileSequence, tilePointsMultipliers));
	}
	
	@Points(value = 5)
	@Test
	public void score5crVb_1D_FourthVersion()
	{
		TEST_GOAL_MESSAGE = "Test the scoring functionality of the student's ScrabbleWordScorer";
		String tileSequence = "⑤ⒸⓇṾⒷ⊙①⒟";
		int[] tilePointsMultipliers = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
		int expectedScore = 9;
		assertEquals(expectedScore, scrabbleWordScorer_STUDENT.getScore(tileSequence, tilePointsMultipliers));
	}
}
