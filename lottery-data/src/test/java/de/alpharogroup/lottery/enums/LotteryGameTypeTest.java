package de.alpharogroup.lottery.enums;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * The unit test class for the class {@link LotteryGameType}
 */
public class LotteryGameTypeTest
{

	/**
	 * Test method for the constant values of {@link LotteryGameType}
	 */
	@Test
	public void testValues() {
		String actual;
		String expected;

		actual = LotteryGameType.SIX_OF_FOURTYNINE_FULL_SYSTEM.name();
		expected = "SIX_OF_FOURTYNINE_FULL_SYSTEM";
		assertEquals(actual, expected);

		actual = LotteryGameType.SIX_OF_FOURTYNINE_NORMAL.name();
		expected = "SIX_OF_FOURTYNINE_NORMAL";
		assertEquals(actual, expected);

	}
}
