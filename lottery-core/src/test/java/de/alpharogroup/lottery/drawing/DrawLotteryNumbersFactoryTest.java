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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.security.SecureRandom;
import java.util.Set;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.math.MathExtensions;
import de.alpharogroup.random.DefaultSecureRandom;

/**
 * The unit test class for the class {@link DrawLotteryNumbersFactory}
 */
public class DrawLotteryNumbersFactoryTest
{

	/**
	 * Test method for {@link DrawLotteryNumbersFactory#draw(int, int)}
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
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 7 of 36
		volume = 36;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 7 of 35
		volume = 35;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
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
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 49
		volume = 49;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 48
		volume = 48;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 45
		volume = 45;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 42
		volume = 42;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 6 of 30
		volume = 30;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
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
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 75
		volume = 75;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 69
		volume = 69;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 49
		volume = 49;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 42
		volume = 42;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 40
		volume = 40;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}

		// simulate a draw of 5 of 35
		volume = 35;
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, volume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(1, volume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawLotteryNumbersFactory#draw(int, int, int)}
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
		lotteryNumbers = DrawLotteryNumbersFactory.draw(max, minVolume, maxVolume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}


	/**
	 * Test method for
	 * {@link DrawLotteryNumbersFactory#drawWithShuffle(int, int, int, SecureRandom)}
	 */
	@Test
	public void testDrawWithShuffle()
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
		lotteryNumbers = DrawLotteryNumbersFactory.drawWithShuffle(max, minVolume, maxVolume);
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for
	 * {@link DrawLotteryNumbersFactory#drawWithShuffle(int, int, int, SecureRandom)}
	 */
	@Test
	public void testDrawWithShuffleSecureRandom()
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
		lotteryNumbers = DrawLotteryNumbersFactory.drawWithShuffle(max, minVolume, maxVolume,
			DefaultSecureRandom.get());
		actual = lotteryNumbers.size();
		expected = max;
		assertEquals(actual, expected);
		for (Integer lotteryNumber : lotteryNumbers)
		{
			assertTrue(MathExtensions.isBetween(minVolume, maxVolume, lotteryNumber, true, true));
		}
	}

	/**
	 * Test method for {@link DrawLotteryNumbersFactory} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DrawLotteryNumbersFactory.class);
	}

}
