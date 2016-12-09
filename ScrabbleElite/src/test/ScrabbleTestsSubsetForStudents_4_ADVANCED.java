package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import extension.Points;

public class ScrabbleTestsSubsetForStudents_4_ADVANCED extends ScrabbleTestsSubsetForStudents_3_INTERMEDIATE
{
	@Points(value = 5)
	@Test
	public void legalTransformation_bird()
	{
		TEST_GOAL_MESSAGE = "Test the isLegalTransformation() method of the student's ScrabbleWordScorer";
		String tileSequence = "ⒷⒾⓇⒹ";
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "bird"));
	}

	@Points(value = 5)
	@Test
	public void legalTransformationFrom_why()
	{
		TEST_GOAL_MESSAGE = "Test the isLegalTransformation() method of the student's ScrabbleWordScorer";
		String tileSequence = "ⓌⒽⓎ";
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "why"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "whynot"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "wha"));
	}

	@Points(value = 5)
	@Test
	public void legalTransformationFrom_pVt()
	{
		TEST_GOAL_MESSAGE = "Test the isLegalTransformation() method of the student's ScrabbleWordScorer";
		String tileSequence = "ⓅṾ⑦";
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pat"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pet"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pit"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pot"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "put"));

		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pbt"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pct"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pdt"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pft"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pgt"));
	}

	@Points(value = 5)
	@Test
	public void legalTransformationFrom_PVD()
	{
		TEST_GOAL_MESSAGE = "Test the isLegalTransformation() method of the student's ScrabbleWordScorer";
		String tileSequence = "𝞍Ṿ⊙";
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pat"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pet"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pit"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pot"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "put"));

		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pbt"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pct"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pdt"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pft"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "pgt"));
		
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fat"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fet"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fit"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fot"));
		assertTrue(scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fut"));

		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fbt"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fct"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fdt"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fft"));
		assertTrue(!scrabbleWordScorer_STUDENT.isLegalTransformation(tileSequence, "fgt"));
	}
}
