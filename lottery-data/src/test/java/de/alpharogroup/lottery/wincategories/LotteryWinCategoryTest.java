/**
 * Commercial License
 *
 * Copyright (C) 2015 Asterios Raptis - All Rights Reserved
 *
 * Proprietary and confidential
 *
 * Unauthorized copying of this software and its files,
 * via any medium is strictly prohibited
 *
 * Written by Asterios Raptis
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.alpharogroup.lottery.wincategories;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Collection;
import java.util.Optional;

import org.testng.annotations.Test;

import de.alpharogroup.collections.set.SetFactory;

/**
 * The unit test class for the enum class {@link LotteryWinCategory}.
 */
public class LotteryWinCategoryTest
{

	/**
	 * Test method for {@link LotteryWinCategory#getLotteryWinCategory(Collection, boolean)}
	 */
	@Test
	public void testGetLotteryWinCategoryCollectionOfIntegerBoolean()
	{
		Optional<LotteryWinCategory> expected;
		Optional<LotteryWinCategory> actual;
		Collection<Integer> wonLotteryTicket;
		boolean withSuperNumber;
		Integer expectedFixedWinningUnits;
		Integer actualFixedWinningUnits;

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18, 25, 30);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.FIRST_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18, 25, 30);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.SECOND_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18, 25);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.THIRD_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18, 25);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.FOURTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.FIFTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.SIXTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.SEVENTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.EIGHTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.NINTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);
		expectedFixedWinningUnits = 5;
		LotteryWinCategory lotteryWinCategory = actual.get();
		actualFixedWinningUnits = lotteryWinCategory.getWinCategory().getFixedWinningUnits();
		assertEquals(actualFixedWinningUnits, expectedFixedWinningUnits);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.NONE);
		actual = LotteryWinCategory.getLotteryWinCategory(wonLotteryTicket, withSuperNumber);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link LotteryWinCategory#getLotteryWinCategory(Collection, Collection, boolean)}
	 */
	@Test
	public void testGetLotteryWinCategoryCollectionOfIntegerCollectionOfIntegerBoolean()
	{
		Optional<LotteryWinCategory> expected;
		Optional<LotteryWinCategory> actual;
		Collection<Integer> drawnLotteryNumbers;
		Collection<Integer> wonLotteryTicket;
		boolean withSuperNumber;

		drawnLotteryNumbers = SetFactory.newTreeSet(6, 12, 15, 18, 25, 30);
		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18, 25, 30);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.FIRST_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18, 25, 30);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.SECOND_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18, 25);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.THIRD_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18, 25);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.FOURTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.FIFTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15, 18);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.SIXTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.SEVENTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12, 15);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.EIGHTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12);
		withSuperNumber = true;
		expected = Optional.of(LotteryWinCategory.NINTH_CLASS);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);

		wonLotteryTicket = SetFactory.newTreeSet(6, 12);
		withSuperNumber = false;
		expected = Optional.of(LotteryWinCategory.NONE);
		actual = LotteryWinCategory.getLotteryWinCategory(drawnLotteryNumbers, wonLotteryTicket,
			withSuperNumber);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for creation of object {@link LotteryWinCategory}
	 */
	@Test
	public void testObjectCreation()
	{
		WinCategory expected;
		WinCategory actual;
		LotteryWinCategory object = LotteryWinCategory.EIGHTH_CLASS;
		assertNotNull(object);

		expected = WinCategory.builder().quotaOfProfit(45.0d).quantityOfWonNumbers(3)
			.withSuperNumber(false).build();
		actual = object.getWinCategory();
		assertEquals(expected, actual);
	}
}
