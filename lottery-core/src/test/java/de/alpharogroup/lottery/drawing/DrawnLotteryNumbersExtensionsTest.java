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
package de.alpharogroup.lottery.drawing;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.meanbean.test.BeanTestException;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.math.MathExtensions;

import static org.testng.Assert.*;

/**
 * The class {@link DrawnLotteryNumbersExtensionsTest}.
 */
public class DrawnLotteryNumbersExtensionsTest
{

	/**
	 * Test method for {@link DrawnLotteryNumbersExtensions#drawParanoidFromMultiMap(int, int, int, int)}
	 */
	@Test
	public void testDrawParanoidFromMultiMap(){
		int actual;
		int expected;
		Set<Integer> lotteryNumbers;
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 1000;
		lotteryNumbers = DrawnLotteryNumbersExtensions
			.drawParanoidFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount);
		actual = lotteryNumbers.size();
		expected = maxNumbers;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersExtensions#drawFromMultiMap(int, int, int, int)}
	 */
	@Test
	public void testDrawFromMultiMap(){
		int actual;
		int expected;
		Set<Integer> lotteryNumbers;
		int maxNumbers;
		int minVolume;
		int maxVolume;
		int drawCount;

		maxNumbers = 7;
		minVolume = 1;
		maxVolume = 70;
		drawCount = 10000;
		lotteryNumbers = DrawnLotteryNumbersExtensions
			.drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount);
		actual = lotteryNumbers.size();
		expected = maxNumbers;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersExtensions#drawDefaultAlgorithm(int, int, int)}.
	 */
	@Test
	public void testDrawDefaultAlgorithm()
	{
		int actual;
		int expected;

		Set<Integer> lotteryNumbers;
		int max;
		int minVolume;
		int maxVolume;


		// simulate a draw of 7 numbers in between of 5 and 39
		max = 7;
		minVolume = 5;
		maxVolume = 39;
		lotteryNumbers = DrawnLotteryNumbersExtensions.drawDefaultAlgorithm(max, minVolume,
			maxVolume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersExtensions#drawGameSeventySeven()}.
	 */
	@Test
	public void testDrawGameSeventySeven()
	{
		int actual;
		actual = DrawnLotteryNumbersExtensions.drawGameSeventySeven();
		assertTrue(MathExtensions.isBetween(0, 9999999, actual, true, true));
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersExtensions#draw(int, int)}.
	 */
	@Test
	public void testDrawIntInt()
	{
		int actual;
		int expected;
		Set<Integer> lotteryNumbers;
		int volume;
		int max;

		max = 7;

		// simulate a draw of 7 of 39
		volume = 39;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 7 of 36
		volume = 36;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 7 of 35
		volume = 35;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		max = 6;

		// simulate a draw of 6 of 59
		volume = 59;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 49
		volume = 49;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 48
		volume = 48;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 45
		volume = 45;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 42
		volume = 42;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 30
		volume = 30;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		max = 5;

		// simulate a draw of 5 of 90
		volume = 90;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 75
		volume = 75;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 69
		volume = 69;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 49
		volume = 49;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 42
		volume = 42;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 40
		volume = 40;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 35
		volume = 35;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersExtensions#draw(int, int, int)}.
	 */
	@Test
	public void testDrawIntIntInt()
	{
		int actual;
		int expected;
		Set<Integer> lotteryNumbers;
		int max;
		int minVolume;
		int maxVolume;


		// simulate a draw of 7 numbers in between of 5 and 39
		max = 7;
		minVolume = 5;
		maxVolume = 39;
		lotteryNumbers = DrawnLotteryNumbersExtensions.draw(max, minVolume, maxVolume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersExtensions#drawSuperNumber(Set, int)}.
	 */
	@Test
	public void testDrawSuperNumber()
	{
		Set<Integer> alreadyDrawnNumbers = SetFactory.newTreeSet(6, 12, 15, 18, 25, 30);
		int superNumber = DrawnLotteryNumbersExtensions.drawSuperNumber(alreadyDrawnNumbers, 49);
		assertFalse(alreadyDrawnNumbers.contains(superNumber));
		assertTrue(MathExtensions.isBetween(1, 49, superNumber, true, true));
	}

	/**
	 * Test method for {@link DrawnLotteryNumbersExtensions} with {@link BeanTester}
	 */
	@Test(expectedExceptions = { BeanTestException.class, InvocationTargetException.class,
			UnsupportedOperationException.class })
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawnLotteryNumbersExtensions.class);
	}

}
